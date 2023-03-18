package com.onebox.cartmanagement.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.onebox.cartmanagement.base.BaseServiceTest;
import com.onebox.cartmanagement.model.dto.ProductsDto;
import com.onebox.cartmanagement.model.entity.CartEntity;
import com.onebox.cartmanagement.model.entity.ProductsEntity;
import com.onebox.cartmanagement.model.request.CartRequest;
import com.onebox.cartmanagement.model.response.CartDeleteResponse;
import com.onebox.cartmanagement.model.response.CartResponse;
import com.onebox.cartmanagement.repository.CartRepository;

public class CartServiceImplTest extends BaseServiceTest {

    CartEntity cartTest;

    @MockBean
    private CartRepository repository;

    @Autowired
    private CartServiceImpl cartService;

    @BeforeEach
    void setUp() {

        cartTest = new CartEntity();
        cartTest.setID(1L);
        List<ProductsEntity> productEntityList = new ArrayList<ProductsEntity>();
        productEntityList.add(new ProductsEntity("descriptionTest", 1, cartTest));
        cartTest.setProducts(productEntityList);

    }

    @Test
    void testAddProductsToCart() {
        CartRequest cartRequest = new CartRequest();
        cartRequest.setId(1L);
        ProductsDto productsDto = new ProductsDto("descriptionTest", 1);
        List<ProductsDto> productsDtoList = new ArrayList<ProductsDto>();
        productsDtoList.add(productsDto);
        cartRequest.setProducts(productsDtoList);

        when(repository.findById(cartTest.getID())).thenReturn(Optional.of(cartTest));
        when(repository.save(any())).thenReturn(cartTest);
        when(repository.saveAndFlush(any())).thenReturn(cartTest);

        final CartResponse response = cartService.addProductsToCart(cartRequest);

        assertNotNull(response);
        assertEquals(2, response.getCart().getProducts().size());
        assertEquals("descriptionTest", response.getCart().getProducts().get(0).getDescription());

    }

    @Test
    void testNewCart() {
        CartRequest cartRequest = new CartRequest();
        ProductsDto productsDto = new ProductsDto("descriptionTest", 1);
        List<ProductsDto> productsDtoList = new ArrayList<ProductsDto>();
        productsDtoList.add(productsDto);
        cartRequest.setProducts(productsDtoList);

        cartTest.setProducts(null);
        when(repository.save(any())).thenReturn(cartTest);
        when(repository.saveAndFlush(any())).thenReturn(cartTest);
        final CartResponse response = cartService.addProductsToCart(cartRequest);

        assertNotNull(response);
        assertEquals(1, response.getCart().getProducts().size());
        assertEquals("descriptionTest", response.getCart().getProducts().get(0).getDescription());
    }

    @Test
    void testDeleteCart() {
        
        when(repository.existsById(cartTest.getID())).thenReturn(true);
        final CartDeleteResponse response = cartService.deleteCart(cartTest.getID());

        assertNotNull(response);
        assertEquals(1L, response.getDeletedCount());
    }

    @Test
    void testGetCart() {
        when(repository.findById(cartTest.getID())).thenReturn(Optional.of(cartTest));
        final CartResponse response = cartService.getCart(cartTest.getID());
        assertNotNull(response);
        assertEquals(1, response.getCart().getId());
    }

    @Configuration
    @ComponentScan(basePackages = { "com.onebox.cartmanagement.service", "com.onebox.cartmanagement.model",
            "com.onebox.cartmanagement.repository" })
    static class Config {

    }
}
