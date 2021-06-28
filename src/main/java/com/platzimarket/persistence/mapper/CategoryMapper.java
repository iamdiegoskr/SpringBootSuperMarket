package com.platzimarket.persistence.mapper;

import com.platzimarket.domain.models.Category;
import com.platzimarket.persistence.entity.CategoryEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mappings({
            @Mapping(source = "description", target = "category"),
            @Mapping(source = "status", target = "active")
    })
    Category toCategory(CategoryEntity category);

    @InheritInverseConfiguration
    @Mapping(target = "products", ignore = true)
    CategoryEntity toCategoryEntity(Category category);

}
