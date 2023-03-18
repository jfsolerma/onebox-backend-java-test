package com.onebox.cartmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.onebox.cartmanagement.model.entity.ProductsEntity;


public interface ProductsRepository extends JpaRepository<ProductsEntity, Long> {
}
