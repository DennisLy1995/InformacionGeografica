package com.RIG.RIG.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RIG {

	@Id
	private int CODIGO;
	@Column
	private String NOMBRE_P;
	
	public RIG() {}

	public RIG(int cODIGO, String nOMBRE_P) {
		super();
		CODIGO = cODIGO;
		NOMBRE_P = nOMBRE_P;
	}

	public int getCODIGO() {
		return CODIGO;
	}

	public void setCODIGO(int cODIGO) {
		CODIGO = cODIGO;
	}

	public String getNOMBRE_P() {
		return NOMBRE_P;
	}

	public void setNOMBRE_P(String nOMBRE_P) {
		NOMBRE_P = nOMBRE_P;
	}
	
	
}
