package com.onebox.cartmanagement.model.response;

import java.io.Serializable;

import com.onebox.cartmanagement.model.dto.CartDto;

public class CartResponse implements Serializable {
    private CartDto cart;

    public CartDto getCart() {
        return cart;
    }

    public void setCart(CartDto cart) {
        this.cart = cart;
    }
}
