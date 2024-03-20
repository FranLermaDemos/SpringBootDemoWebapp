package com.fralermo.springbootNgDemo.infra.database.adapter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fralermo.springbootNgDemo.application.ports.PricePort;
import com.fralermo.springbootNgDemo.domain.entities.Price;
import com.fralermo.springbootNgDemo.infra.database.mapper.EntityMapper;
import com.fralermo.springbootNgDemo.infra.database.repository.PriceJPARepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PriceDatabaseAdapter implements PricePort {
	
	@Autowired
	private PriceJPARepository priceRepository;
	
	@Override
	public List<Price> findAll() {
		var mapper = Mappers.getMapper(EntityMapper.class);
		List<Price> prices = this.priceRepository.findAll().stream().map(x -> mapper.convertEntityPriceToDomainPrice(x)).collect(Collectors.toList());
		return prices;
	}

	@Override
	public List<Price> findPrices(LocalDateTime date, Long productId, Long brandId) {
		
		log.trace("call to findPrices({},{},{})", date, productId, brandId);
		var mapper = Mappers.getMapper(EntityMapper.class);
		
		return this.priceRepository.findPrices(date, productId, brandId, Sort.by("priority").descending())
				.stream().map(x -> mapper.convertEntityPriceToDomainPrice(x)).collect(Collectors.toList());
	}

	@Override
	public void createPrice(Price price) {
		var mapper = Mappers.getMapper(EntityMapper.class);
		this.priceRepository.save(mapper.convertDomainPriceToEntityPrice(price));
	}
	
	
}
