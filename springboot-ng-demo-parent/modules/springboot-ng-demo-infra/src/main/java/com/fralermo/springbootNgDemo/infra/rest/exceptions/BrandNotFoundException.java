package com.fralermo.springbootNgDemo.infra.rest.exceptions;

public class BrandNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public BrandNotFoundException() {
		super("La marca no existe");
	}

}
