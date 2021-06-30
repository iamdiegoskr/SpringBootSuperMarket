package com.platzimarket.persistence.crud;

import com.platzimarket.persistence.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<ProductEntity,Integer> {

    // get list products by category Query Methods
    List<ProductEntity> findByIdCategoryOrderByNameAsc(int idCategoria);

    //get scarce products
    Optional<List<ProductEntity>> findByQuantityStockLessThanAndStatus(int quantityStock,boolean status);

    //get many products in stock
    Optional<List<ProductEntity>> findByQuantityStockGreaterThan(int quantityStock);

    List<ProductEntity> findBySalePriceGreaterThan(double salePrice);

    /*@Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
    List<ProductEntity> getProductsByCategory(int idCategoria);*/

}
