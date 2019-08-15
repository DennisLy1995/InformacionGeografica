package com.RIG.RIG.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Region_Biologica {

	@Id
	private String NOMBRE_RB;
	@Column
	private String NOMBRE_P;
	@Column
	private int SUPERFICIE_T;
	@Column
	private int SUPERFICIE_M;
	
	public Region_Biologica() {
		
	}

	public Region_Biologica(String nOMBRE_RB, String nOMBRE_P, int sUPERFICIE_T, int sUPERFICIE_M) {
		super();
		NOMBRE_RB = nOMBRE_RB;
		NOMBRE_P = nOMBRE_P;
		SUPERFICIE_T = sUPERFICIE_T;
		SUPERFICIE_M = sUPERFICIE_M;
	}

	public String getNOMBRE_RB() {
		return NOMBRE_RB;
	}

	public void setNOMBRE_RB(String nOMBRE_RB) {
		NOMBRE_RB = nOMBRE_RB;
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
	
	
	
}
