package com.platzimarket.persistence.crud;

import com.platzimarket.persistence.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface CategoryCrudRepository extends CrudRepository<CategoryEntity,Integer> {

}
