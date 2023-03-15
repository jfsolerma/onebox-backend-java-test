package com.onebox.cartmanagement.model.entity;


import org.hibernate.annotations.SQLDelete;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Cart")
@SQLDelete(sql = "DELETE FROM Cart WHERE ID=?")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    @OneToMany(mappedBy="cart", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Products> items;

}
