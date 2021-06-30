package com.platzimarket.persistence;

import com.platzimarket.domain.models.Product;
import com.platzimarket.domain.repository.IProductRepository;
import com.platzimarket.persistence.crud.ProductCrudRepository;
import com.platzimarket.persistence.entity.ProductEntity;
import com.platzimarket.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class ProductRepository implements IProductRepository {

    @Autowired
    private ProductCrudRepository productCrudRepository;

    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAllProducts() {
        List<ProductEntity> products = (List<ProductEntity>) productCrudRepository.findAll();
        return mapper.toProducts(products);
    }

    @Override
    public Optional<List<Product>> getProductsByCategory(int categoryId) {
        return productCrudRepository.findByIdCategoryOrderByNameAsc(categoryId)
                .map(products->mapper.toProducts(products));
    }

    @Override
    public Optional<List<Product>> getScarceProducts(int quantity) {
        Optional<List<ProductEntity>> productsScarce = productCrudRepository.findByQuantityStockLessThanAndStatus(quantity,true);
        return productsScarce.map(productEntities -> mapper.toProducts(productEntities));
    }

    @Override
    public Optional<List<Product>> getAbundantProducts(int quantity) {
        Optional<List<ProductEntity>> productsAbundant = productCrudRepository.findByQuantityStockGreaterThan(quantity);
        return productsAbundant.map(productEntities -> mapper.toProducts(productEntities));
    }

    @Override
    public List<Product> getExpensiveProducts(double price) {
        List<ProductEntity> productsExpensive = productCrudRepository.findBySalePriceGreaterThan(price);
        return mapper.toProducts(productsExpensive);
    }

    @Override
    public Optional<Product> getProduct(int id) {
        return productCrudRepository.findById(id).map(prod -> mapper.toProduct(prod));
    }

    @Override
    public Product saveProduct(Product product) {
        ProductEntity productEntity = mapper.toProductEntity(product);
        return mapper.toProduct(productCrudRepository.save(productEntity));
    }

    @Override
    public void removeProduct(int id) {
        productCrudRepository.deleteById(id);
    }




}
