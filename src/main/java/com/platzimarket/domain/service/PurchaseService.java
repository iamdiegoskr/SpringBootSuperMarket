package com.platzimarket.domain.service;

import com.platzimarket.domain.models.Purchase;
import com.platzimarket.domain.repository.IPurchaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    private IPurchaseRepository repo;

    public List<Purchase> getAll(){
        return  repo.getAllPurchase();
    }

    public Optional<List<Purchase>> getAllByClient(String clientId){
        return repo.getPurchaseByClient(clientId);
    }

    public Purchase save(Purchase purchase){
        return repo.savePurchase(purchase);
    }


}
