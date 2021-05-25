package model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Order")
public class Order {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "staffId", nullable = false)
    private Staff staffID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "providerId", nullable = false)
    private Provider providerID;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "detailId", nullable = false)
    private List<OrderDetail> orderDetailID;

    public Order() {
    }

//    public Order(int id, Date date, Staff staffID, Provider providerID, OrderDetail orderDetailID) {
//        this.id = id;
//        this.date = date;
//        this.staffID = staffID;
//        this.providerID = providerID;
//        this.orderDetailID = orderDetailID;
//    }

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

    public List<OrderDetail> getOrderDetailID() {
        return orderDetailID;
    }

//    public void setOrderDetailID(OrderDetail orderDetailID) {
//        this.orderDetailID = orderDetailID;
//    }
}
