package model;


import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order")
public class Order {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "staffID", nullable = false)
    private Staff staffID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "providerID", nullable = false)
    private Provider providerID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "DetailID", nullable = false)
    private OrderDetail orderDetailID;

    public Order() {
    }

    public Order(int id, Date date, Staff staffID, Provider providerID, OrderDetail orderDetailID) {
        this.id = id;
        this.date = date;
        this.staffID = staffID;
        this.providerID = providerID;
        this.orderDetailID = orderDetailID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Staff getStaffID() {
        return staffID;
    }

    public void setStaffID(Staff staffID) {
        this.staffID = staffID;
    }

    public Provider getProviderID() {
        return providerID;
    }

    public void setProviderID(Provider providerID) {
        this.providerID = providerID;
    }

    public OrderDetail getOrderDetailID() {
        return orderDetailID;
    }

    public void setOrderDetailID(OrderDetail orderDetailID) {
        this.orderDetailID = orderDetailID;
    }
}
