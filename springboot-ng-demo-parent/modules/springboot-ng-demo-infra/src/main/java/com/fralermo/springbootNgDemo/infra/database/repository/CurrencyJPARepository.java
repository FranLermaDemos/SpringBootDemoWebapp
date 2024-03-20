package com.fralermo.springbootNgDemo.infra.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fralermo.springbootNgDemo.infra.database.entity.CurrencyEntity;

@Repository
public interface CurrencyJPARepository extends JpaRepository<CurrencyEntity, String>{
	
}
