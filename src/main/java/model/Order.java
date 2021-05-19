package model;


import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order")
public class Order extends Note{

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "providerID", nullable = false)
    private Provider providerID;

    @OneToMany(mappedBy = "orderID", cascade = CascadeType.ALL, fetch =
            FetchType.EAGER)
    private List<OrderDetail> orderDetailList;

    public Order() {
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
