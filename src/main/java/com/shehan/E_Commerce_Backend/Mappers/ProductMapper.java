package com.shehan.E_Commerce_Backend.Mappers;
import com.shehan.E_Commerce_Backend.DTOs.ProductDto;
import com.shehan.E_Commerce_Backend.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "categoryId", source = "category.id")
    ProductDto toDto(Product product);
}
