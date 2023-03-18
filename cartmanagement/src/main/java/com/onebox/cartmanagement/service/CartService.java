package com.onebox.cartmanagement.service;

import com.onebox.cartmanagement.model.request.CartRequest;
import com.onebox.cartmanagement.model.response.CartDeleteResponse;
import com.onebox.cartmanagement.model.response.CartResponse;

public interface CartService {
    public CartResponse getCart(Long id);

    public CartResponse addProductsToCart(CartRequest request);

    public CartDeleteResponse deleteCart(Long id);

}
