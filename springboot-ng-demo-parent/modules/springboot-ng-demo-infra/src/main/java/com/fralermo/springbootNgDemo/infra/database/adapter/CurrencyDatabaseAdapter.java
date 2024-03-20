package com.fralermo.springbootNgDemo.infra.database.adapter;

import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fralermo.springbootNgDemo.application.ports.CurrencyPort;
import com.fralermo.springbootNgDemo.domain.entities.Currency;
import com.fralermo.springbootNgDemo.infra.database.mapper.EntityMapper;
import com.fralermo.springbootNgDemo.infra.database.repository.CurrencyJPARepository;

@Service
public class CurrencyDatabaseAdapter implements CurrencyPort {
	
	private static EntityMapper mapper;

	static {
		mapper = Mappers.getMapper(EntityMapper.class);
	}
	
	@Autowired
	private CurrencyJPARepository currencyRepository;
	
	@Override
	public Optional<Currency> findCurrency(String iso) {
		return this.currencyRepository.findById(iso).stream().map(x -> mapper.convertEntityCurrencyToDomainCurrency(x)).findAny();

	}

}
