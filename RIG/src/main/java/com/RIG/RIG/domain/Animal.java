package com.RIG.RIG.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Animal {

	@Id
	private String NOMBRE_CIENTIFICO;
	@Column
	private String NOMBRE_POPULAR;
	@Column
	private int PELIGRO_EXT;
	
	private Animal() {}

	public Animal(String nOMBRE_CIENTIFICO, String nOMBRE_POPULAR, int pELIGRO_EXT) {
		super();
		NOMBRE_CIENTIFICO = nOMBRE_CIENTIFICO;
		NOMBRE_POPULAR = nOMBRE_POPULAR;
		PELIGRO_EXT = pELIGRO_EXT;
	}

	public String getNOMBRE_CIENTIFICO() {
		return NOMBRE_CIENTIFICO;
	}

	public void setNOMBRE_CIENTIFICO(String nOMBRE_CIENTIFICO) {
		NOMBRE_CIENTIFICO = nOMBRE_CIENTIFICO;
	}

	public String getNOMBRE_POPULAR() {
		return NOMBRE_POPULAR;
	}

	public void setNOMBRE_POPULAR(String nOMBRE_POPULAR) {
		NOMBRE_POPULAR = nOMBRE_POPULAR;
	}

	public int getPELIGRO_EXT() {
		return PELIGRO_EXT;
	}

	public void setPELIGRO_EXT(int pELIGRO_EXT) {
		PELIGRO_EXT = pELIGRO_EXT;
	}
	
	
	
}
