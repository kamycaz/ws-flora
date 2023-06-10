package com.zopitek.flora.controller;


import com.zopitek.flora.model.ErrorResponseDTO;
import com.zopitek.flora.model.StandarResponseDTO;
import com.zopitek.flora.model.forms.SaleForm;
import com.zopitek.flora.model.forms.SaleLineForm;
import com.zopitek.flora.params.ErrorMessages;
import com.zopitek.flora.service.SaleService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/private/app")
@CrossOrigin("*")
public class AppController {

    @Autowired
    private SaleService saleService;

    @Transactional
    @PostMapping("/add")
    public ResponseEntity<?> addSaleLine(@RequestBody SaleForm sale) throws Exception {
        try {
            if (sale != null) {
                //return new ResponseEntity<>(saleLineService.save(product), HttpStatus.OK);
                System.out.println("El parray tiene un tamaño de " + sale.getLines().size());

               for (SaleLineForm saleLineForm : sale.getLines()) {
                    System.out.println("El producto recibido es " + saleLineForm.toString());
                }
               saleService.save(sale);

                return new ResponseEntity<>(new StandarResponseDTO("OK", "Factura generada correctamente"), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new StandarResponseDTO("KO", ErrorMessages.MISSING_PARAMS), HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e){
            return new ResponseEntity<>(new StandarResponseDTO("KO", e.getMessage()), HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping("/sales/getByClient/{id}")
    public ResponseEntity<?> getSalesByClient(@PathVariable Integer id) throws Exception {
        try {
            return new ResponseEntity<>(saleService.getSaleList(id), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(new StandarResponseDTO("KO", e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/sales/get")
    public ResponseEntity<?> getSales() throws Exception {
        try {
            return new ResponseEntity<>(saleService.getSales(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(new StandarResponseDTO("KO", e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/sales/paid/{id}")
    public ResponseEntity<?> setPaid(@PathVariable Integer id) throws Exception {
        try {
            saleService.setPaid(id);
            return new ResponseEntity<>(new StandarResponseDTO("OK", "Factura "+ id + " pagada correctamente"), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(new StandarResponseDTO("KO", e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/salelines/getBySale/{id}")
    public ResponseEntity<?> getSaleLines(@PathVariable Integer id) throws Exception {
        try {
            return new ResponseEntity<>(saleService.getSaleLines(id), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(new StandarResponseDTO("KO", e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }

}
