package com.fralermo.springbootNgDemo.infra.rest.mapper;

import org.mapstruct.Mapper;

import com.fralermo.springbootNgDemo.domain.entities.Price;
import com.fralermo.springbootNgDemo.infra.rest.dto.input.PriceRequestDTO;

@Mapper
public interface RequestDTOMapper {

	PriceRequestDTO convertPriceToPriceResponseDTO(Price price);
	
}
