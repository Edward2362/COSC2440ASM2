package com.example.cosc2440asm2.model;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order_note")
public class Order extends Note{

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "providerId")
    private Provider providerID;

    @OneToMany(mappedBy = "orderID", cascade = CascadeType.ALL, fetch =
            FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    private List<OrderDetail> orderDetailList;

    public Order() {
    }

    public Order(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Provider getProviderID() {
        return providerID;
    }

    public void setProviderID(Provider providerID) {
        this.providerID = providerID;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
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
