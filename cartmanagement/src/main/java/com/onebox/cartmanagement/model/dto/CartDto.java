package com.onebox.cartmanagement.model.dto;


import java.io.Serializable;
import java.util.List;


public class CartDto implements Serializable {
    private Long id;
    private List<ProductsDto> products;


    
    public CartDto(Long id, List<ProductsDto> products) {
        this.id = id;
        this.products = products;
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
