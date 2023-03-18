package com.onebox.cartmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.onebox.cartmanagement.model.entity.CartEntity;


public interface CartRepository extends JpaRepository<CartEntity, Long> {
    
    //query to delete expired cart 10 minutes (600000 miliseconds)
    @Modifying
    @Query("delete from CartEntity c where (c.dateExpiring + 600000) <=:date")
    public void deleteExpiredCart( @Param("date")Long date);
}
