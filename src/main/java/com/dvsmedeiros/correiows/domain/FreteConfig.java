package com.dvsmedeiros.correiows.domain;

import java.util.HashMap;
import java.util.Map;

public class FreteConfig {

	private String empresa;
	private String senha;
	private Boolean emMaos;
	private Boolean avisoRecebimento;

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getServico() {
		StringBuilder sb = new StringBuilder();
		
		for(Integer key : getServicos().keySet() ){
			sb.append(String.valueOf(key));
			sb.append(",");
		}
		if(sb.toString().endsWith(",")){
			return sb.toString().substring(0, sb.toString().lastIndexOf(","));
		}
		return sb.toString();
	}

	public String getEmMaos() {
		
		if(emMaos){
			return "S";
		}
		return "N";
	}

	public void setEmMaos(boolean emMaos) {
		this.emMaos = emMaos;
	}

	public String getAvisoRecebimento() {
		if(avisoRecebimento){
			return "S";
		}
		return "N";
	}

	public void setAvisoRecebimento(boolean avisoRecebimento) {
		
		this.avisoRecebimento = avisoRecebimento;
	}
	
	public Map<Integer, String> getServicos() {
		
		Map<Integer, String> servicos = new HashMap<Integer, String>();
		servicos.put(40010, "SEDEX");
		servicos.put(40045, "SEDEX a Cobrar");
		servicos.put(41106, "PAC");
		
		return servicos;
	}
	
}
