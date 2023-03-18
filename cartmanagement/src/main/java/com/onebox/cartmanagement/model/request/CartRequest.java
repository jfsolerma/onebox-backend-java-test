package com.onebox.cartmanagement.model.request;


import java.io.Serializable;
import java.util.List;

import com.onebox.cartmanagement.model.dto.ProductsDto;


public class CartRequest implements Serializable {
    private Long id;
    private List<ProductsDto> products;


    
    public CartRequest(Long id, List<ProductsDto> products) {
        this.id = id;
        this.products = products;
    }

    public CartRequest() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public List<ProductsDto> getProducts() {
        return products;
    }
    public void setProducts(List<ProductsDto> products) {
        this.products = products;
    }
}
