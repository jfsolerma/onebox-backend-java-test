package com.onebox.cartmanagement.model.entity;


import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;

@Entity
@Table(name = "Products")
@SQLDelete(sql = "DELETE FROM Products WHERE ID=?")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    @Column
    private String description;

    @Column
    private Integer amount;
  
    @ManyToOne
    @JoinColumn(name="CartId", nullable=false)
    private Cart cart;

}
