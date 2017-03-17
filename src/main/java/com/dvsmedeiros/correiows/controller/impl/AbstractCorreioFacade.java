package com.dvsmedeiros.correiows.controller.impl;

import java.util.HashMap;
import java.util.Map;

import com.dvsmedeiros.correiows.controller.IFreteFacade;
import com.dvsmedeiros.correiows.domain.FreteConfig;

public abstract class AbstractCorreioFacade implements IFreteFacade {
	
	protected FreteConfig config;
	
	public AbstractCorreioFacade(FreteConfig config ) {
		setConfig(config);		
	}
		
	public void setConfig(FreteConfig freteConfig) {
		this.config = freteConfig;		
	}
}
