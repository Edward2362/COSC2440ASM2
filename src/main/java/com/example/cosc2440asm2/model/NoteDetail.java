package com.example.cosc2440asm2.model;

import javax.persistence.*;

@MappedSuperclass
public abstract class NoteDetail {

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="product_id")
    private Product productID;

    @Column
    protected int quantity;

    public NoteDetail() {
    }

    public Product getProductID() {
        return productID;
    }

    public void setProductID(Product id) {
        this.productID = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
