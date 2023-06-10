package com.zopitek.flora.controller.shared;

import com.zopitek.flora.entity.Product;
import com.zopitek.flora.model.ErrorResponseDTO;
import com.zopitek.flora.model.StandarResponseDTO;
import com.zopitek.flora.params.ErrorMessages;
import com.zopitek.flora.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/private/product")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@RequestBody Product product) throws Exception {
        try {
            if (product != null) {
               if(productService.save(product)==1) {
                   return new ResponseEntity<>(new StandarResponseDTO("OK","Producto añadido correctamente"), HttpStatus.OK);
               } else {
                   return new ResponseEntity<>(new StandarResponseDTO("KO", ErrorMessages.WRITE_ERROR), HttpStatus.BAD_REQUEST);
               }
            } else {
                return new ResponseEntity<>(new StandarResponseDTO("KO",ErrorMessages.MISSING_PARAMS), HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e){
            return new ResponseEntity<>(new StandarResponseDTO("KO",e.getMessage()), HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getProducts() throws Exception {
        try {
            return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(new StandarResponseDTO("KO",e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getProduct(@PathVariable Long id) throws Exception {
        try {
            return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(new StandarResponseDTO("KO",e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/getByName/{name}")
    public ResponseEntity<?> getProduct(@PathVariable String name) throws Exception {
        try {
            return new ResponseEntity<>(productService.findByName(name), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(new StandarResponseDTO("KO",e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }


    @PutMapping("/update")
    public ResponseEntity<?> updateProduct(@RequestBody Product product) throws Exception {
        try {
            if (product != null) {
                if(product.getId() != null) {
                    return new ResponseEntity<>(productService.save(product), HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(new StandarResponseDTO("KO",ErrorMessages.MISSING_PARAMS), HttpStatus.BAD_REQUEST);
                }
            } else {
                return new ResponseEntity<>(new StandarResponseDTO("KO",ErrorMessages.MISSING_PARAMS), HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e){
            return new ResponseEntity<>(new StandarResponseDTO("KO",e.getMessage()), HttpStatus.BAD_REQUEST);

        }
    }
}
