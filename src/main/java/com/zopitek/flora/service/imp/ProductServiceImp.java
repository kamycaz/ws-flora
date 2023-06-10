package com.zopitek.flora.service.imp;

import com.zopitek.flora.entity.Client;
import com.zopitek.flora.entity.Product;
import com.zopitek.flora.model.projection.ProductResponse;
import com.zopitek.flora.params.ErrorMessages;
import com.zopitek.flora.repository.ProductRepository;
import com.zopitek.flora.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Integer save(Product product) throws Exception {
        try {
            productRepository.save(product);
            return 1;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Product> findAll() throws Exception {
        try {
            return (List<Product>) productRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Product findById(Long id) throws Exception {
        try {
            Optional optinal = productRepository.findById(id);
            if(optinal.isEmpty()){
                throw new Exception(ErrorMessages.NOT_FOUND);
            } else {
                return (Product) optinal.get();
            }
        }  catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<ProductResponse> findByName(String name) throws Exception {
        try {
            return productRepository.findBasicListByName(name);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
