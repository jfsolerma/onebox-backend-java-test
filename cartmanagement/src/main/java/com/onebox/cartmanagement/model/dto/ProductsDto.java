package com.onebox.cartmanagement.model.dto;

public class ProductsDto {


    private String description;

    private Integer amount;

    public ProductsDto(String description, Integer amount) {
        this.description = description;
        this.amount = amount;
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

}
