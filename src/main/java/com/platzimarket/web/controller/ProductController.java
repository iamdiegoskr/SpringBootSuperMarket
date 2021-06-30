package com.platzimarket.web.controller;

import com.platzimarket.domain.models.Product;
import com.platzimarket.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    public List<Product> getByCategory(int categoryId){
        return  service.getByCategory(categoryId);
    }


    public Product saveProduct(Product product){
        return service.save(product);
    }

    public boolean deleteProduct(int productId){
        return service.deleteProduct(productId);
    }

}
