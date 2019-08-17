package com.RIG.RIG.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pais {

	@Id
	private String NOMBRE_P;
	@Column
	private String CONTINENTE;
	@Column
	private int RIG;
	
	
	public Pais() {}
	
	public Pais(String nOMBRE_P, String cONTINENTE, int rIG) {
		super();
		NOMBRE_P = nOMBRE_P;
		CONTINENTE = cONTINENTE;
		RIG = rIG;
	}

	public String getNOMBRE_P() {
		return NOMBRE_P;
	}
	
	public void setNOMBRE_P(String nOMBRE_P) {
		NOMBRE_P = nOMBRE_P;
	}
	
	public String getCONTINENTE() {
		return CONTINENTE;
	}
	
	public void setCONTINENTE(String cONTINENTE) {
		CONTINENTE = cONTINENTE;
	}

	public int getRIG() {
		return RIG;
	}

	public void setRIG(int rIG) {
		RIG = rIG;
	}
	
}
