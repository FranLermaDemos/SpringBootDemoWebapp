package com.fralermo.springbootNgDemo.infra.rest.exceptions;

public class CurrencyNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public CurrencyNotFoundException() {
		super("La moneda no existe");
	}

}
