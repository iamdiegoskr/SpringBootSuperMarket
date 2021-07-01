package com.platzimarket.persistence.crud;

import com.platzimarket.persistence.entity.BuyEntity;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface BuyCrudRepository extends CrudRepository<BuyEntity,Integer> {

    Optional<List<BuyEntity>> findByIdClient(String idClient);

}
