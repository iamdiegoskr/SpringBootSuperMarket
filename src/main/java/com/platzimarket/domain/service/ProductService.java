package com.platzimarket.domain.service;

import com.platzimarket.domain.models.Product;
import com.platzimarket.domain.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private IProductRepository repository;

    public List<Product> getAll(){
        return repository.getAllProducts();
    }

    public Optional<Product> getProduct(int productId){
        return repository.getProduct(productId);
    }

    public List<Product> getByCategory(int categoryId){
        return repository.getProductsByCategory(categoryId);
    }

    public Product save(Product product){
        return repository.saveProduct(product);
    }

    public boolean deleteProduct(int productId){
        return getProduct(productId).map(product ->{
            repository.removeProduct(productId);
            return true;
        }).orElse(false);
    }



}
