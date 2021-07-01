package com.platzimarket.domain.repository;

import com.platzimarket.domain.models.Purchase;

import java.util.List;
import java.util.Optional;

public interface IPurchaseRepository {
    List<Purchase> getAllPurchase();
    Optional<List<Purchase>> getPurchaseByClient(String clientId);
    Purchase savePurchase(Purchase purchase);

}
