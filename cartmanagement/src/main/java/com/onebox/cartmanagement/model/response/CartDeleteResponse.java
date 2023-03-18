package com.onebox.cartmanagement.model.response;


import java.io.Serializable;


public class CartDeleteResponse implements Serializable {
    private int deletedCount;

    public int getDeletedCount() {
        return deletedCount;
    }

    public void setDeletedCount(int deletedCount) {
        this.deletedCount = deletedCount;
    }
}
