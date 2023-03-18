package com.onebox.cartmanagement.model.entity;



import javax.persistence.*;

@Entity
@Table(name = "Products")
public class ProductsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    @Column
    private String description;

    @Column
    private Integer amount;
  
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name="CartId", nullable=false )
    private CartEntity cart;

    public ProductsEntity() {

    }
    public ProductsEntity(String description, Integer amount, CartEntity cart) {
        this.cart = cart;
        this.description = description;
        this.amount = amount;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long iD) {
        ID = iD;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public CartEntity getCart() {
        return cart;
    }

    public void setCart(CartEntity cart) {
        this.cart = cart;
    }

}
