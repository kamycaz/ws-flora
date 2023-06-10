package com.zopitek.flora.controller.shared;


import com.zopitek.flora.model.ErrorResponseDTO;
import com.zopitek.flora.model.StandarResponseDTO;
import com.zopitek.flora.service.ProvinceService;
import com.zopitek.flora.service.RegionService;
import com.zopitek.flora.service.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/private/location")
@CrossOrigin("*")
public class LocationController {

    @Autowired
    private RegionService regionService;

    @Autowired
    private ProvinceService provinceService;

    @Autowired
    private TownService townService;

    @GetMapping("/region/get")
    public ResponseEntity<?> getRegions() throws Exception {
        try {
            return new ResponseEntity<>(regionService.get(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>( new StandarResponseDTO("KO",e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/province/get")
    public ResponseEntity<?> getProvincies() throws Exception {
        try {
            return new ResponseEntity<>(provinceService.get(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(new StandarResponseDTO("KO",e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/province/getByRegion/{id}")
    public ResponseEntity<?> getProvinciesByRegion(@PathVariable Integer id) throws Exception {
        try {
            return new ResponseEntity<>(provinceService.getByRegion(id), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>( new StandarResponseDTO("KO",e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/town/getByProvince/{id}")
    public ResponseEntity<?> getTownsByProvince(@PathVariable Integer id) throws Exception {
        try {
            return new ResponseEntity<>(townService.getTownByProvince(id), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>( new StandarResponseDTO("KO",e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }
}
