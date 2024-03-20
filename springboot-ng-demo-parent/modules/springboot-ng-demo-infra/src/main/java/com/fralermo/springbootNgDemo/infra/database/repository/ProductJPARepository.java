package com.fralermo.springbootNgDemo.infra.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fralermo.springbootNgDemo.infra.database.entity.ProductEntity;

@Repository
public interface ProductJPARepository extends JpaRepository<ProductEntity, Long> {

}
