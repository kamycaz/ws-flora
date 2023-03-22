package com.zopitek.flora.controller;


import com.zopitek.flora.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/private/web")
public class WebController {

    @Autowired
    private ProductService productService;
}
