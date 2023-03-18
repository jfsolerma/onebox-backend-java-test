package com.onebox.cartmanagement.service.impl;

import com.onebox.cartmanagement.model.converter.CartConverter;
import com.onebox.cartmanagement.model.entity.CartEntity;
import com.onebox.cartmanagement.model.request.CartRequest;
import com.onebox.cartmanagement.model.response.CartDeleteResponse;
import com.onebox.cartmanagement.model.response.CartResponse;
import com.onebox.cartmanagement.repository.CartRepository;
import com.onebox.cartmanagement.service.CartService;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository repository;

    @Autowired
    private CartConverter cartConverter;


    @Override
    public CartResponse getCart(Long id) {
        final CartResponse response = new CartResponse();
        Optional<CartEntity> cartEntity = repository.findById(id);
        if (cartEntity != null && cartEntity.isPresent()) {
            response.setCart(cartConverter.toDto(cartEntity.get()));
        }

        return response;
    }

    @Override
    public CartResponse addProductsToCart(CartRequest request) {
        
        CartResponse response = new CartResponse();
        Optional<CartEntity> cartRepo = null;
        if (request.getId() != null) {
            cartRepo = repository.findById(request.getId());
            if(cartRepo != null && !cartRepo.isPresent()) {
                //No id found
                return null;
            }
        }
        
        CartEntity cartEntity;
        if (cartRepo != null && cartRepo.isPresent()) {
            cartEntity = cartConverter.ProductsToEntity(request.getProducts(), cartRepo.get());
            //update date expiring Cart
            cartEntity.setDateExpiring(new Date().getTime());
        } else {
            cartEntity = new CartEntity();
            cartEntity = repository.save(cartEntity);
            cartEntity = cartConverter.ProductsToEntity(request.getProducts(), cartEntity);
        }
        response.setCart(cartConverter.toDto(cartEntity));
        repository.saveAndFlush(cartEntity);
        return response;

    }

    @Override
    public CartDeleteResponse deleteCart(Long id) {

        CartDeleteResponse response = new CartDeleteResponse();
        if (repository.existsById(id)) {
            repository.deleteById(id);
            response.setDeletedCount(1);
        }
        return response;

    }

}
