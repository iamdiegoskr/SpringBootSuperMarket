package com.platzimarket.web.controller;

import com.platzimarket.domain.models.Product;
import com.platzimarket.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping()
    public List<Product> getAll() {
        return service.getAll();
    }

    @GetMapping("/{productId}")
    public Optional<Product> getProduct(@PathVariable() int productId){
        return service.getProduct(productId);
    }

    @GetMapping("/category/{categoryId}")
    public List<Product> getByCategory(@PathVariable() int categoryId){
        return  service.getByCategory(categoryId);
    }

    @PostMapping()
    public Product saveProduct(@RequestBody Product product){
        return service.save(product);
    }

    @DeleteMapping("/delete/{id}")
    public boolean removeProduct(@PathVariable() int id){
        return service.removeProduct(id);
    }

}
