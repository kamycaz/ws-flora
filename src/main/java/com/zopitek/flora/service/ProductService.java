package com.zopitek.flora.service;

import com.zopitek.flora.entity.Client;
import com.zopitek.flora.entity.Product;
import com.zopitek.flora.model.projection.ProductResponse;

import java.util.List;

public interface ProductService {

    public Integer save(Product product) throws Exception;

    public List<Product> findAll() throws Exception;

    public Product findById(Long id) throws Exception;

    public List<ProductResponse> findByName(String name) throws Exception;


}
