package com.fralermo.springbootNgDemo.infra.rest.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fralermo.springbootNgDemo.application.ports.BrandPort;
import com.fralermo.springbootNgDemo.application.ports.CurrencyPort;
import com.fralermo.springbootNgDemo.application.ports.PricePort;
import com.fralermo.springbootNgDemo.application.ports.ProductPort;
import com.fralermo.springbootNgDemo.domain.entities.Brand;
import com.fralermo.springbootNgDemo.domain.entities.Currency;
import com.fralermo.springbootNgDemo.domain.entities.Price;
import com.fralermo.springbootNgDemo.domain.entities.Product;
import com.fralermo.springbootNgDemo.infra.rest.dto.input.PriceRequestDTO;
import com.fralermo.springbootNgDemo.infra.rest.dto.output.PriceResponseDTO;
import com.fralermo.springbootNgDemo.infra.rest.exceptions.BrandNotFoundException;
import com.fralermo.springbootNgDemo.infra.rest.exceptions.CurrencyNotFoundException;
import com.fralermo.springbootNgDemo.infra.rest.exceptions.ProductNotFoundException;
import com.fralermo.springbootNgDemo.infra.rest.mapper.ResponseDTOMapper;

@RestController
@RequestMapping("/api/v1/price")
public class PriceController {

	@Autowired
	private PricePort pricePort;
	
	@Autowired 
	private BrandPort brandPort;
	
	@Autowired
	private CurrencyPort currencyPort;
	
	@Autowired
	private ProductPort productPort;
	
	
	@GetMapping("/findAll")
	public ResponseEntity<List<PriceResponseDTO>> getPrices() {
		
		var mapper = Mappers.getMapper(ResponseDTOMapper.class);
		List<PriceResponseDTO> prices = this.pricePort.findAll().stream().map(x -> mapper.convertPriceToPriceResponseDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok(prices);
		
	}
	
	
	@GetMapping("/query")
	public ResponseEntity<PriceResponseDTO> getPricesQuery(
			@RequestParam("localDateTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime localDateTime,
			Long productId, 
			Long brandId) {

		var mapper = Mappers.getMapper(ResponseDTOMapper.class);
		Optional<PriceResponseDTO> price = this.pricePort.findPrices(localDateTime, productId, brandId).stream()
				.map(x -> mapper.convertPriceToPriceResponseDTO(x)).findFirst();
		
		return ResponseEntity.ok(price.orElseGet(null));
		
	}
	
	@PostMapping()
	@Transactional
	public ResponseEntity<Price> createPrice(@RequestBody PriceRequestDTO createPriceData) throws ProductNotFoundException, BrandNotFoundException, CurrencyNotFoundException {
		
		Product product = this.productPort.findProduct(createPriceData.getProductId()).orElseThrow(ProductNotFoundException::new);
		Brand brand = this.brandPort.findBrand(createPriceData.getBrandId()).orElseThrow(BrandNotFoundException::new);
		Currency currency = this.currencyPort.findCurrency(createPriceData.getCurrencyISO()).orElseThrow(CurrencyNotFoundException::new);
		
		Price price = Price.builder()
				//.priceList(0L)
				.brand(brand)
				.product(product)
				.currency(currency)
				.startDate(createPriceData.getStartDate())
				.endDate(createPriceData.getEndDate())
				.priority(createPriceData.getPriority())
				.price(createPriceData.getPrice())
				.build();
		
		this.pricePort.createPrice(price);
		
		return ResponseEntity.ok(null);
	}
	
	
	
}
