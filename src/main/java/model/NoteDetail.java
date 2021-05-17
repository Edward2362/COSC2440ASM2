package model;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class NoteDetail {

    @JoinColumn
    protected Product productID;

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
