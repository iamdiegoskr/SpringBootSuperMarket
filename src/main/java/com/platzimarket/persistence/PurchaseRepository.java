package com.platzimarket.persistence;

import com.platzimarket.domain.models.Purchase;
import com.platzimarket.domain.repository.IPurchaseRepository;
import com.platzimarket.persistence.crud.BuyCrudRepository;
import com.platzimarket.persistence.entity.BuyEntity;
import com.platzimarket.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PurchaseRepository implements IPurchaseRepository {

    @Autowired
    private BuyCrudRepository repository;

    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAllPurchase() {
        List<BuyEntity> purchases = (List<BuyEntity>) repository.findAll();
        return mapper.toPurchases(purchases);
    }

    @Override
    public Optional<List<Purchase>> getPurchaseByClient(String clientId) {
        return repository.findByIdClient(clientId).map(buyEntities -> mapper.toPurchases(buyEntities));
    }

    @Override
    public Purchase savePurchase(Purchase purchase) {
        BuyEntity buyEntity = mapper.toBuyEntity(purchase);

        buyEntity.getProducts().forEach(productEntity -> {
            productEntity.setBuy(buyEntity);
        });

        return mapper.toPurchase(repository.save(buyEntity));
    }
}
