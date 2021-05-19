package model;


import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.*;
import javax.xml.crypto.Data;

@Entity
@Table(name = "orderDetail")
public class OrderDetail extends NoteDetail{

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="product_id", nullable = false)
    private Product product;
  
    @Column
    private int price;

    public OrderDetail() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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
