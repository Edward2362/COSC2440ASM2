package model;

import javax.persistence.*;

@MappedSuperclass
public abstract class NoteDetail {

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="product_id", nullable = false)
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
