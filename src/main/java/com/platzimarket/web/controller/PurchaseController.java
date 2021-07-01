package com.platzimarket.web.controller;

import com.platzimarket.domain.models.Purchase;
import com.platzimarket.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService service;

    @GetMapping()
    public ResponseEntity<List<Purchase>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{idClient}")
    public ResponseEntity<List<Purchase>> getByClient(@PathVariable String idClient){
        return service.getAllByClient(idClient)
                .map(purchases -> new ResponseEntity<>(purchases,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PostMapping()
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase){
        return new ResponseEntity<>(service.save(purchase),HttpStatus.CREATED);
    }

}
