package com.RIG.RIG.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class REGB_X_REGP {

	@Id
	private int CODIGO;
	@Column
	private String NOMBRE_RB;
	@Column
	private String NOMBRE_RP;
	
	public REGB_X_REGP() {
		super();
	}

	public REGB_X_REGP(int cODIGO, String nOMBRE_RB, String nOMBRE_RP) {
		super();
		CODIGO = cODIGO;
		NOMBRE_RB = nOMBRE_RB;
		NOMBRE_RP = nOMBRE_RP;
	}

	public int getCODIGO() {
		return CODIGO;
	}

	public void setCODIGO(int cODIGO) {
		CODIGO = cODIGO;
	}

	public String getNOMBRE_RB() {
		return NOMBRE_RB;
	}

	public void setNOMBRE_RB(String nOMBRE_RB) {
		NOMBRE_RB = nOMBRE_RB;
	}

	public String getNOMBRE_RP() {
		return NOMBRE_RP;
	}

	public void setNOMBRE_RP(String nOMBRE_RP) {
		NOMBRE_RP = nOMBRE_RP;
	}
	
	
	
	
}
