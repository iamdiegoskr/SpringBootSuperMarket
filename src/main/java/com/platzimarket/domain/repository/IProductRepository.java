package com.platzimarket.domain.repository;

import com.platzimarket.domain.models.Product;

import java.util.List;
import java.util.Optional;

public interface IProductRepository {

    List<Product> getAllProducts();
    Optional<List<Product>> getProductsByCategory(int categoryId);
    Optional<List<Product>> getScarceProducts(int quantity);
    Optional<List<Product>> getAbundantProducts(int quantity);
    List<Product> getExpensiveProducts(double price);
    Optional<Product> getProduct(int id);
    Product saveProduct(Product product);
    void removeProduct(int id);

}
