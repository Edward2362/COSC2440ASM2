package com.example.cosc2440asm2.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sale_invoice_id", nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
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
