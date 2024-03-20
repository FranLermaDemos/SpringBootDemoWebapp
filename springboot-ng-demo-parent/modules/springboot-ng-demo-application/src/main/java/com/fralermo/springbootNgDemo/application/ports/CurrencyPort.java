package com.fralermo.springbootNgDemo.application.ports;

import java.util.Optional;

import com.fralermo.springbootNgDemo.domain.entities.Currency;

public interface CurrencyPort {

	public Optional<Currency> findCurrency(String iso);
	
}
