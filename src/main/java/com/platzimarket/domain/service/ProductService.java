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
    private IProductRepository repo;

    public List<Product> getAll(){
        return repo.getAllProducts();
    }

    public Optional<Product> getProduct(int productId){
        return repo.getProduct(productId);
    }

    public List<Product> getByCategory(int categoryId){
        return  repo.getProductsByCategory(categoryId);
    }

    public Product saveProduct(Product product){
        return  repo.saveProduct(product);
    }

    public boolean deleteProduct(int productId){
        /*if(getProduct(productId).isPresent()){
            repo.removeProduct(productId);
            return true;
        }else{
            return false;
        }*/

        return getProduct(productId).map(product ->{
            repo.removeProduct(productId);
            return true;
        }).orElse(false);

    }





}
