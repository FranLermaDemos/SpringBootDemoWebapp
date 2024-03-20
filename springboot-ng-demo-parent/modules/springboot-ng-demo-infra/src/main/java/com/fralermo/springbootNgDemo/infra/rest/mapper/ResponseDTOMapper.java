package com.fralermo.springbootNgDemo.infra.rest.mapper;

import org.mapstruct.Mapper;

import com.fralermo.springbootNgDemo.domain.entities.Price;
import com.fralermo.springbootNgDemo.infra.rest.dto.output.PriceResponseDTO;

@Mapper
public interface ResponseDTOMapper {

	PriceResponseDTO convertPriceToPriceResponseDTO(Price price);
	
}
