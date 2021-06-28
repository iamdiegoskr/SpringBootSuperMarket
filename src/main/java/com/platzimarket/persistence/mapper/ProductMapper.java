package com.platzimarket.persistence.mapper;

import com.platzimarket.domain.models.Product;
import com.platzimarket.persistence.entity.ProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

    @Mapping(source = "salePrice", target = "price")
    @Mapping(source = "quantityStock", target = "stock")
    @Mapping(source = "status", target = "active")
    Product toProduct(ProductEntity product);
    List<Product> toProducts(List<ProductEntity> products);

    @InheritInverseConfiguration
    @Mapping(target = "barcode",ignore = true)
    ProductEntity toProductEntity(Product product);

}
