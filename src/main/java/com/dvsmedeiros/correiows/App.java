package com.dvsmedeiros.correiows;

import java.math.BigDecimal;
import java.rmi.RemoteException;
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
import com.dvsmedeiros.correiows.controller.impl.CorreioFacade;
import com.dvsmedeiros.correiows.domain.Frete;
import com.dvsmedeiros.correiows.domain.FreteConfig;
import com.dvsmedeiros.correiows.domain.FreteRetorno;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) throws RemoteException, ServiceException {
		
		FreteConfig config = new FreteConfig();
		config.setAvisoRecebimento(true);
		config.setEmMaos(false);
		
		IFreteFacade facade = new CorreioFacade(config);
		
		Frete frete = new Frete();
		frete.setAltura(new BigDecimal(22));
		frete.setCepDestino("12231090");
		frete.setCepOrigem("08696100");
		frete.setComprimento(new BigDecimal(22));
		frete.setDiametro(new BigDecimal(0));
		frete.setFormato(1);
		frete.setLargura(new BigDecimal(22));
		frete.setPeso("22");
		frete.setValorDeclarado(new BigDecimal(200.0));
		
		List<FreteRetorno> calculaFrete = facade.calculaFrete(frete);
		for (FreteRetorno freteRetorno : calculaFrete) {
			System.out.println(freteRetorno.getPrazo());
			System.out.println(freteRetorno.getTipoServico());
			System.out.println(freteRetorno.getValor());
			System.out.println("---------------------------------");
			
		}
		
	}
}
