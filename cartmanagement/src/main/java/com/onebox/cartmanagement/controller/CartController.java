package com.onebox.cartmanagement.controller;

import com.onebox.cartmanagement.model.request.CartRequest;
import com.onebox.cartmanagement.model.response.CartDeleteResponse;
import com.onebox.cartmanagement.model.response.CartResponse;
import com.onebox.cartmanagement.service.impl.CartServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {

    @Autowired
    private CartServiceImpl cartService;

    @GetMapping("/cart/{id}")
    public ResponseEntity<CartResponse> getCustomer(@PathVariable("id") Long id) {
        CartResponse response = cartService.getCart(id);

        if (response.getCart() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

    }

    @PostMapping("/cart")
    public ResponseEntity<CartResponse> createCustomer(@RequestBody CartRequest request) {
        CartResponse response = cartService.addProductsToCart(request);
        if (response == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @DeleteMapping("/cart/{id}")
    public ResponseEntity<CartDeleteResponse> deleteCustomer(@PathVariable("id") Long id) {
        CartDeleteResponse response = cartService.deleteCart(id);
        if (0 == response.getDeletedCount()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }
    

}
