package com.fralermo.springbootNgDemo.infra.rest.exceptions;

public class ProductNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ProductNotFoundException() {
		super("El producto no existe");
	}

}
