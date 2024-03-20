package com.fralermo.springbootNgDemo.application.ports;

import java.time.LocalDateTime;
import java.util.List;

import com.fralermo.springbootNgDemo.domain.entities.Price;

public interface PricePort {

	public List<Price> findAll();

    public List<Price> findPrices(LocalDateTime appDate, Long productId, Long brandId); 
    
    public void createPrice(Price price);
    
	
}
