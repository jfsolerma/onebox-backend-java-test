package com.onebox.cartmanagement.model.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.onebox.cartmanagement.model.dto.CartDto;
import com.onebox.cartmanagement.model.dto.ProductsDto;
import com.onebox.cartmanagement.model.entity.CartEntity;
import com.onebox.cartmanagement.model.entity.ProductsEntity;

@Component
public class CartConverter {

    private List<ProductsEntity> ProductsDtoToEntityList(List<ProductsDto> products, CartEntity cart) {
        List<ProductsEntity> productsEntity = new ArrayList<ProductsEntity>();
        for (ProductsDto product : products) {
            productsEntity
                    .add(new ProductsEntity(product.getDescription(), product.getAmount(), cart));
        }
        return productsEntity;
    }

    private List<ProductsDto> ProductsEntityToDtoList(List<ProductsEntity> products) {
        List<ProductsDto> productsDto = new ArrayList<ProductsDto>();
        for (ProductsEntity product : products) {
            productsDto.add(new ProductsDto(product.getDescription(), product.getAmount()));
        }
        return productsDto;

    }

    public CartDto toDto(CartEntity entity) {

        if (entity != null && entity.getProducts() != null && entity.getID() != null) {

            return new CartDto(entity.getID(), ProductsEntityToDtoList(entity.getProducts()));

        }
        return null;
    }

    public CartEntity ProductsToEntity(List<ProductsDto> products, CartEntity cart) {
        List<ProductsEntity> productListComplete;
        if (cart != null) {
            if (cart.getProducts() != null) {
                productListComplete = cart.getProducts();
            } else {
                productListComplete = new ArrayList<ProductsEntity>();

            }
            productListComplete.addAll(ProductsDtoToEntityList(products, cart));
            cart.setProducts(productListComplete);
        }
        return cart;
    }

}
