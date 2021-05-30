package com.example.cosc2440asm2.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "saleInvoice")
public class SaleInvoice extends Note {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int totalPrice;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customerID;

    @OneToMany(mappedBy = "saleInvoiceID", cascade = CascadeType.ALL, fetch =
            FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    private List<SaleDetail> saleDetailList;

    public SaleInvoice(){};

    public SaleInvoice(List<SaleDetail> saleDetailList) {
        this.saleDetailList = saleDetailList;
    }

    public SaleInvoice(Date date, List<SaleDetail> saleDetailList) {
        super(date);
        this.saleDetailList = saleDetailList;
    }

    public SaleInvoice(Date date, Staff staffID, Customer customerID, List<SaleDetail> saleDetailList) {
        super(date, staffID);
        this.customerID = customerID;
        this.saleDetailList = saleDetailList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Customer customer) {
        this.customerID = customer;
    }

    public List<SaleDetail> getSaleDetailList() {
        return saleDetailList;
    }

    public void setSaleDetailList(List<SaleDetail> saleDetailList) {
        this.saleDetailList = saleDetailList;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public Date getDate() {
        return super.getDate();
    }

    @Override
    public void setDate(Date date) {
        super.setDate(date);
    }

    @Override
    public Staff getStaffID() {
        return super.getStaffID();
    }

    @Override
    public void setStaffID(Staff staff) {
        super.setStaffID(staff);
    }
}
