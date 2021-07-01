package com.platzimarket.persistence.mapper;

import com.platzimarket.domain.models.PurchaseItem;
import com.platzimarket.persistence.entity.BuyProductsEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PurchaseItemMapper {

    @Mappings({
            @Mapping(source = "id.idProduct", target = "productId"),
            @Mapping(source = "status", target = "active")
    })
    PurchaseItem toPurchaseItem(BuyProductsEntity product);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "buy", ignore = true),
            @Mapping(target = "product", ignore = true),
            @Mapping(target = "id.idBuy", ignore = true)
    })
    BuyProductsEntity toBuyProductsEntity(PurchaseItem item);

}
