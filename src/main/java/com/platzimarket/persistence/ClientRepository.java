package com.platzimarket.persistence;

import com.platzimarket.persistence.crud.ClientCrudRepository;
import com.platzimarket.persistence.entity.ClientEntity;

import java.util.List;

public class ClientRepository {

    private ClientCrudRepository clientCrudRepository;

    public List<ClientEntity> getClientByName(String name){
        return clientCrudRepository.findByNameStartsWith(name);
    }

    public List<ClientEntity> getClientBySearch(String name){
        return clientCrudRepository.findByNameContainingIgnoreCaseOrderByNameAsc(name);
    }

    public List<ClientEntity> getClientByNameOrLastname(String name, String lastname){
        return clientCrudRepository.findByNameContainingAndLastnameContaining(name,lastname);
    }

    public boolean existClient(String dni){
        return clientCrudRepository.existByIdClient(dni);
    }


}
