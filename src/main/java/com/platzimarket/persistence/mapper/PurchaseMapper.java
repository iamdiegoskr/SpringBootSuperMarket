package com.platzimarket.persistence.mapper;

import com.platzimarket.domain.models.Purchase;
import com.platzimarket.persistence.entity.BuyEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {

    @Mappings({
            @Mapping(source = "idBuy", target = "purchaseId"),
            @Mapping(source = "idClient", target = "clientId"),
            @Mapping(source = "commentary", target = "comment"),
            @Mapping(source = "status", target = "state"),
            @Mapping(source = "products", target = "items")
    })
    Purchase toPurchase(BuyEntity purchase);
    List<Purchase> toPurchases(List<BuyEntity> purchase);

    @InheritInverseConfiguration
    @Mapping(target = "client", ignore = true)
    BuyEntity toBuyEntity(Purchase purchase);

}
