package com.dvsmedeiros.correiows;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.List;

import javax.xml.rpc.ServiceException;

import com.dvsmedeiros.correiows.controller.IFreteFacade;
import com.dvsmedeiros.correiows.controller.impl.CorreioFacade;
import com.dvsmedeiros.correiows.domain.Frete;
import com.dvsmedeiros.correiows.domain.FreteConfig;
import com.dvsmedeiros.correiows.domain.FreteRetorno;

public class App {

	public static void main(String[] args) throws RemoteException, ServiceException {

		FreteConfig config = new FreteConfig();
		config.setAvisoRecebimento(true);
		config.setEmMaos(false);

		IFreteFacade facade = new CorreioFacade(config);

		Frete frete = new Frete();
		frete.setAltura(new BigDecimal(30));
		frete.setCepOrigem("12226852");
		frete.setCepDestino("60743410");
		frete.setComprimento(new BigDecimal(22));
		frete.setDiametro(new BigDecimal(508888888));
		frete.setFormato(2);
		frete.setLargura(new BigDecimal(22));
		frete.setPeso("30");
		frete.setValorDeclarado(new BigDecimal(9.0));

		List<FreteRetorno> calculaFrete = facade.calculaFrete(frete);

		for (FreteRetorno freteRetorno : calculaFrete) {

			System.out.println(freteRetorno.getPrazo());
			System.out.println(freteRetorno.getTipoServico());
			System.out.println(freteRetorno.getValor());
			System.out.println("---------------------------------");

		}
	}
}

/**
 * BOX 
 * Altura: MIN = 2cm
 *         MAX = 105cm
 * Largura min 11 max 105
 * Comprimento: min 16 max 105
 * Diametro: nao tem
 * peso min 0 max 30
 * Cep   : Obrigatorio
 * 
 * ROLL
 * Altura: Não tem
 * Largura: nao tem
 * Comprimento: min = 18 max = 105
 * Diametro min 5 max 91
 * peso min 0 max 30
 * Cep   : Obrigatorio
 * 
 * ENVELOPE
 * Altura: Não tem
 * largura: min 11 max 60
 * Comprimento: min = 16 max = 60cm
 * Diametro nao tem
 * peso min 0 max 1 
 * Cep   : Obrigatorio
 *         
 */