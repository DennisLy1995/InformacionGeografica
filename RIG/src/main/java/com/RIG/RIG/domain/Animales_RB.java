package com.RIG.RIG.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Animales_RB {

	@Id
	private int CODIGO;
	@Column
	private String NOMBRE_CIENTIFICO;
	@Column
	private String NOMBRE_RB;
	@Column
	private int CANTIDAD;
	
	public Animales_RB() {
		super();
	}

	public Animales_RB(int cODIGO, String nOMBRE_CIENTIFICO, String nOMBRE_RB, int cANTIDAD) {
		super();
		CODIGO = cODIGO;
		NOMBRE_CIENTIFICO = nOMBRE_CIENTIFICO;
		NOMBRE_RB = nOMBRE_RB;
		CANTIDAD = cANTIDAD;
	}

	public int getCODIGO() {
		return CODIGO;
	}

	public void setCODIGO(int cODIGO) {
		CODIGO = cODIGO;
	}

	public String getNOMBRE_CIENTIFICO() {
		return NOMBRE_CIENTIFICO;
	}

	public void setNOMBRE_CIENTIFICO(String nOMBRE_CIENTIFICO) {
		NOMBRE_CIENTIFICO = nOMBRE_CIENTIFICO;
	}

	public String getNOMBRE_RB() {
		return NOMBRE_RB;
	}

	public void setNOMBRE_RB(String nOMBRE_RB) {
		NOMBRE_RB = nOMBRE_RB;
	}

	public int getCANTIDAD() {
		return CANTIDAD;
	}

	public void setCANTIDAD(int cANTIDAD) {
		CANTIDAD = cANTIDAD;
	}
	
	
	
}
