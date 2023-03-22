package com.zopitek.flora.repository;

import com.zopitek.flora.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
