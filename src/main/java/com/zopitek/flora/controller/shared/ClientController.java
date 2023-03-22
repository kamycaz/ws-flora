package com.zopitek.flora.controller.shared;

import com.zopitek.flora.entity.Client;
import com.zopitek.flora.entity.Product;
import com.zopitek.flora.model.ErrorResponseDTO;
import com.zopitek.flora.params.ErrorMessages;
import com.zopitek.flora.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/private/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/add")
    public ResponseEntity<?> addClient(@RequestBody Client client) throws Exception {
        try {
            if (client != null) {
                return new ResponseEntity<>(clientService.save(client), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new ErrorResponseDTO(ErrorMessages.MISSING_PARAMS), HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e){
            return new ResponseEntity<>(new ErrorResponseDTO(e.getMessage()), HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getClients() throws Exception {
        try {
            return new ResponseEntity<>(clientService.findAll(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(new ErrorResponseDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }


    @GetMapping("/get/{id}")
    public ResponseEntity<?> getClients(@PathVariable Long id) throws Exception {
        try {
            return new ResponseEntity<>(clientService.findById(id), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(new ErrorResponseDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }


    @GetMapping("/getBasic")
    public ResponseEntity<?> getBasicClient() throws Exception {
        try {
            return new ResponseEntity<>(clientService.findBasicList(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(new ErrorResponseDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping("/update")
    public ResponseEntity<?> updateClient(@RequestBody Client client) throws Exception {
        try {
            if (client != null) {
                if(client.getId() != null) {
                    return new ResponseEntity<>(clientService.save(client), HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(new ErrorResponseDTO(ErrorMessages.MISSING_PARAMS), HttpStatus.BAD_REQUEST);
                }
            } else {
                return new ResponseEntity<>(new ErrorResponseDTO(ErrorMessages.MISSING_PARAMS), HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        }
    }
}
