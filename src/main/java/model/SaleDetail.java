package model;


import javax.persistence.*;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@Table(name = "saleDetail")
public class SaleDetail extends NoteDetail{
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int price;

    @Column
    private long totalValue;

    @ManyToOne
    @JoinColumn(name = "sale_invoice_id", nullable = false)
    private SaleInvoice saleInvoiceID;

    public SaleDetail() {
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

    public long getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(long totalValue) {
        this.totalValue = totalValue;
    }

    public SaleInvoice getSaleInvoiceID() {
        return saleInvoiceID;
    }

    public void setSaleInvoiceID(SaleInvoice saleInvoiceID) {
        this.saleInvoiceID = saleInvoiceID;
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
