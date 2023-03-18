package com.onebox.cartmanagement.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.onebox.cartmanagement.base.BaseControllerTest;
import com.onebox.cartmanagement.config.persistence.PersistenceConfig;

@WebMvcTest(value = CartController.class)
public class CartControllerTest extends BaseControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testCreateCustomer() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .post("/shop/cart")
                .accept(MediaType.APPLICATION_JSON);

        assertNotNull(mockMvc.perform(request));

    }

    @Test
    void testDeleteCustomer() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .delete("/shop/cart")
                .accept(MediaType.APPLICATION_JSON);

        assertNotNull(mockMvc.perform(request));

    }

    @Test
    void testGetCustomer() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/shop/cart")
                .accept(MediaType.APPLICATION_JSON);

        assertNotNull(mockMvc.perform(request));
    }

    @Configuration
    @Import(PersistenceConfig.class) // A @Component injected with ExampleService
    static class Config {
    }
}
