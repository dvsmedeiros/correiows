package com.dvsmedeiros.correiows.controller.impl;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.rpc.ServiceException;

import org.tempuri.CResultado;
import org.tempuri.CServico;
import org.tempuri.CalcPrecoPrazoWS;
import org.tempuri.CalcPrecoPrazoWSLocator;
import org.tempuri.CalcPrecoPrazoWSSoap;

import com.dvsmedeiros.correiows.controller.IFreteFacade;
import com.dvsmedeiros.correiows.domain.Frete;
import com.dvsmedeiros.correiows.domain.FreteConfig;
import com.dvsmedeiros.correiows.domain.FreteRetorno;

public class CorreioFacade extends AbstractCorreioFacade {
	
	public CorreioFacade(FreteConfig config) {
		super(config);
	}

	public List<FreteRetorno> calculaFrete(Frete frete) {
		
		List<FreteRetorno> resultado = new ArrayList<FreteRetorno>();
		
		try {
			
			CalcPrecoPrazoWS ws = new CalcPrecoPrazoWSLocator();
			CalcPrecoPrazoWSSoap soap = ws.getCalcPrecoPrazoWSSoap();						
			
			CResultado retornoWS = 
					soap.calcPrecoPrazo(
					config.getEmpresa(),
					config.getSenha(),
					config.getServico(),
					frete.getCepOrigem(),
					frete.getCepDestino(),
					frete.getPeso(),
					frete.getFormato(), 
					frete.getComprimento(), 
					frete.getAltura(), 
					frete.getLargura(), 
					frete.getDiametro(), 
					config.getEmMaos(),
					frete.getValorDeclarado(), 
					config.getAvisoRecebimento());
			
			for (CServico servico : retornoWS.getServicos()) {
				
				FreteRetorno retorno = new FreteRetorno();
				
				if (servico.getErro().equals("0")) {
					
					retorno.setValor(servico.getValor());
					retorno.setPrazo(servico.getPrazoEntrega());
					retorno.setTipoServico(config.getServicos().get(servico.getCodigo()));
					resultado.add(retorno);
				}
			}
		
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return resultado;
	}

	
	
}
