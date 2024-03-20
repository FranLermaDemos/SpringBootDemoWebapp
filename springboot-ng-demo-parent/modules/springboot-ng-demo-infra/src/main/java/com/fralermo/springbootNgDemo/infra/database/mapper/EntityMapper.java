package com.fralermo.springbootNgDemo.infra.database.mapper;

import org.mapstruct.Mapper;

import com.fralermo.springbootNgDemo.domain.entities.Brand;
import com.fralermo.springbootNgDemo.domain.entities.Currency;
import com.fralermo.springbootNgDemo.domain.entities.Price;
import com.fralermo.springbootNgDemo.domain.entities.Product;
import com.fralermo.springbootNgDemo.infra.database.entity.BrandEntity;
import com.fralermo.springbootNgDemo.infra.database.entity.CurrencyEntity;
import com.fralermo.springbootNgDemo.infra.database.entity.PriceEntity;
import com.fralermo.springbootNgDemo.infra.database.entity.ProductEntity;

@Mapper
public interface EntityMapper {
	
	
	Price convertEntityPriceToDomainPrice(PriceEntity entity);	
	Product convertEntityProductToDomainProduct(ProductEntity entity);
	Currency convertEntityCurrencyToDomainCurrency(CurrencyEntity entity);
	Brand convertEntityBrandToDomainBrand(BrandEntity entity);
	
	PriceEntity convertDomainPriceToEntityPrice(Price domainModel);
}
