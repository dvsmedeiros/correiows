package com.dvsmedeiros.correiows.domain;

import java.math.BigDecimal;

public class Frete {

	private String cepOrigem;
	private String cepDestino;
	private String peso;
	private Integer formato;
	private BigDecimal comprimento;
	private BigDecimal altura;
	private BigDecimal largura;
	private BigDecimal diametro;
	private BigDecimal valorDeclarado;

	public String getCepOrigem() {
		return cepOrigem;
	}

	public void setCepOrigem(String cepOrigem) {
		this.cepOrigem = cepOrigem;
	}

	public String getCepDestino() {
		return cepDestino;
	}

	public void setCepDestino(String cepDestino) {
		this.cepDestino = cepDestino;
	}
	
	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public Integer getFormato() {
		return formato;
	}

	public void setFormato(Integer formato) {
		this.formato = formato;
	}

	public BigDecimal getComprimento() {
		return comprimento;
	}

	public void setComprimento(BigDecimal comprimento) {
		this.comprimento = comprimento;
	}

	public BigDecimal getAltura() {
		return altura;
	}

	public void setAltura(BigDecimal altura) {
		this.altura = altura;
	}

	public BigDecimal getLargura() {
		return largura;
	}

	public void setLargura(BigDecimal largura) {
		this.largura = largura;
	}

	public BigDecimal getDiametro() {
		return diametro;
	}

	public void setDiametro(BigDecimal diametro) {
		this.diametro = diametro;
	}

	public BigDecimal getValorDeclarado() {
		return valorDeclarado;
	}

	public void setValorDeclarado(BigDecimal valorDeclarado) {
		this.valorDeclarado = valorDeclarado;
	}

}
