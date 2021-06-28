package com.platzimarket.persistence.crud;


import com.platzimarket.persistence.entity.ClientEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientCrudRepository extends CrudRepository<ClientEntity,String> {

    List<ClientEntity> findByNameStartsWith(String name);

    List<ClientEntity> findByNameContainingIgnoreCaseOrderByNameAsc(String name);

    List<ClientEntity> findByNameContainingAndLastnameContaining(String name,String lastname);

    boolean existByIdClient(String idClient);

}
