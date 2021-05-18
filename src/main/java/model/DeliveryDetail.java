package model;


import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.*;

@Entity
@Table(name = "deliveryDetail")
public class DeliveryDetail extends NoteDetail{

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
  
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="product_id", nullable = false)
    private Product product;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="staff_id", nullable = false)
    private Staff staff;

    public DeliveryDetail() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public Product getProductID() {
        return super.getProductID();
    }

    @Override
    public void setProductID(Product id) {
        super.setProductID(id);
    }

    @Override
    public int getQuantity() {
        return super.getQuantity();
    }

    @Override
    public void setQuantity(int quantity) {
        super.setQuantity(quantity);
    }
}
