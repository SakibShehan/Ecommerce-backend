package com.shehan.E_Commerce_Backend.Mappers;

import com.shehan.E_Commerce_Backend.DTOs.AddProductDto;
import com.shehan.E_Commerce_Backend.DTOs.ProductDto;
import com.shehan.E_Commerce_Backend.entities.Product;
import com.shehan.E_Commerce_Backend.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface AddProductMapper {
    @Mapping(target = "category", ignore = true)
    Product toEntity(AddProductDto request);


    AddProductDto toDto(Product product);
}
