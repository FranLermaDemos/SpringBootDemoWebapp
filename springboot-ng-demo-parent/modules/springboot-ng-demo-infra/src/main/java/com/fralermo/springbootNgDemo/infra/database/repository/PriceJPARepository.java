package com.fralermo.springbootNgDemo.infra.database.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fralermo.springbootNgDemo.infra.database.entity.PriceEntity;

@Repository
public interface PriceJPARepository extends JpaRepository<PriceEntity, Long> {

    @Query("SELECT p FROM PriceEntity p where ?1 >= p.startDate AND ?1 <= p.endDate AND p.product.productId = ?2 AND p.brand.brandId = ?3")     
    public List<PriceEntity> findPrices(LocalDateTime data, Long productId, Long brandId, Sort sort);
	
}
