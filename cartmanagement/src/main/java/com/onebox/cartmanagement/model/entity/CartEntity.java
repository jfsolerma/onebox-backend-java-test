package com.onebox.cartmanagement.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Cart")
public class CartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    @Column
    private Long dateExpiring;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductsEntity> products;

    public CartEntity() {
        this.dateExpiring = new Date().getTime();
    }

    public CartEntity(List<ProductsEntity> products) {
        this.products = products;
        this.dateExpiring = new Date().getTime();
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long iD) {
        ID = iD;
    }

    public List<ProductsEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductsEntity> products) {
        this.products = products;
    }

    public Long getDateExpiring() {
        return dateExpiring;
    }

    public void setDateExpiring(Long dateExpiring) {
        this.dateExpiring = dateExpiring;
    }

}
