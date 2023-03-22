package com.zopitek.flora.service;

import com.zopitek.flora.entity.Client;
import com.zopitek.flora.entity.Product;

import java.util.List;

public interface ProductService {

    public Product save(Product product) throws Exception;

    public List<Product> findAll() throws Exception;

    public Product findById(Long id) throws Exception;


}
