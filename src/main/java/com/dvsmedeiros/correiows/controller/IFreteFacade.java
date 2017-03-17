package com.dvsmedeiros.correiows.controller;

import java.util.List;
import java.util.Map;
import com.dvsmedeiros.correiows.domain.Frete;
import com.dvsmedeiros.correiows.domain.FreteConfig;
import com.dvsmedeiros.correiows.domain.FreteRetorno;

public interface IFreteFacade {
	
	public List<FreteRetorno> calculaFrete(Frete frete);
	public void setConfig(FreteConfig freteConfig);	
	
}
