package com.onebox.cartmanagement.model.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.onebox.cartmanagement.base.BaseServiceTest;
import com.onebox.cartmanagement.model.dto.CartDto;
import com.onebox.cartmanagement.model.dto.ProductsDto;
import com.onebox.cartmanagement.model.entity.CartEntity;
import com.onebox.cartmanagement.model.entity.ProductsEntity;

public class CartConverterTest extends BaseServiceTest {

    CartConverter cartConverter;
    CartEntity cartEntityTest;

    @BeforeEach
    void setUp() {
        cartConverter = new CartConverter();
        cartEntityTest = new CartEntity();
        cartEntityTest.setID(1L);
        List<ProductsEntity> productEntityList = new ArrayList<ProductsEntity>();
        productEntityList.add(new ProductsEntity("descriptionTest", 1, cartEntityTest));
        cartEntityTest.setProducts(productEntityList);

    }

    @Test
    void testProductsToEntity() {
        ProductsDto productsDto = new ProductsDto("descriptionTest", 1);
        List<ProductsDto> productsDtoList = new ArrayList<ProductsDto>();
        productsDtoList.add(productsDto);
        CartEntity cartEntityResult = cartConverter.ProductsToEntity(productsDtoList, cartEntityTest);
        assertNotNull(cartEntityResult);
        assertEquals(cartEntityTest.getID(), cartEntityResult.getID());
        assertEquals(cartEntityTest.getProducts().get(0).getCart().getID(), cartEntityResult.getID());
        assertEquals(cartEntityTest.getProducts().get(0).getDescription(), "descriptionTest");
    }

    @Test
    void testToDto() {
        CartDto cartDto = cartConverter.toDto(cartEntityTest);
        assertNotNull(cartDto);
        assertEquals(cartDto.getId(), cartEntityTest.getID());
    }
}
