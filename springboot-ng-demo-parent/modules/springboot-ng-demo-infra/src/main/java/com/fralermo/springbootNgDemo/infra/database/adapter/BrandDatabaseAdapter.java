package com.fralermo.springbootNgDemo.infra.database.adapter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fralermo.springbootNgDemo.application.ports.BrandPort;
import com.fralermo.springbootNgDemo.domain.entities.Brand;
import com.fralermo.springbootNgDemo.infra.database.mapper.EntityMapper;
import com.fralermo.springbootNgDemo.infra.database.repository.BrandJPARepository;

@Service
public class BrandDatabaseAdapter implements BrandPort {
	
	private static EntityMapper mapper;
	
	static {
		mapper = Mappers.getMapper(EntityMapper.class);
	}
	
	@Autowired
	private BrandJPARepository brandReposiotry;
	
	@Override
	public List<Brand> findAll() {
		
		List<Brand> prices = this.brandReposiotry.findAll().stream().map(x -> mapper.convertEntityBrandToDomainBrand(x)).collect(Collectors.toList());
		return prices;
	}

	@Override
	public Optional<Brand> findBrand(Long brandId) {
		return this.brandReposiotry.findById(brandId).stream().map(x -> mapper.convertEntityBrandToDomainBrand(x)).findAny();
	}
	
	

}
