package com.RIG.RIG.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Region_Politica {

	@Id
	private String NOMBRE_RP;
	@Column
	private String NOMBRE_P;
	@Column
	private int SUPERFICIE_T;
	@Column
	private int SUPERFICIE_M;
	@Column
	private int POBLACION;
	
	public Region_Politica() {
		
	}

	public Region_Politica(String nOMBRE_RP, String nOMBRE_P, int sUPERFICIE_T, int sUPERFICIE_M, int pOBLACION) {
		super();
		NOMBRE_RP = nOMBRE_RP;
		NOMBRE_P = nOMBRE_P;
		SUPERFICIE_T = sUPERFICIE_T;
		SUPERFICIE_M = sUPERFICIE_M;
		POBLACION = pOBLACION;
	}

	public String getNOMBRE_RP() {
		return NOMBRE_RP;
	}

	public void setNOMBRE_RP(String nOMBRE_RP) {
		NOMBRE_RP = nOMBRE_RP;
	}

	public String getNOMBRE_P() {
		return NOMBRE_P;
	}

	public void setNOMBRE_P(String nOMBRE_P) {
		NOMBRE_P = nOMBRE_P;
	}

	public int getSUPERFICIE_T() {
		return SUPERFICIE_T;
	}

	public void setSUPERFICIE_T(int sUPERFICIE_T) {
		SUPERFICIE_T = sUPERFICIE_T;
	}

	public int getSUPERFICIE_M() {
		return SUPERFICIE_M;
	}

	public void setSUPERFICIE_M(int sUPERFICIE_M) {
		SUPERFICIE_M = sUPERFICIE_M;
	}

	public int getPOBLACION() {
		return POBLACION;
	}

	public void setPOBLACION(int pOBLACION) {
		POBLACION = pOBLACION;
	}
	
}
