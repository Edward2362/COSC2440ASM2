package com.example.cosc2440asm2.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Where;
import org.hibernate.sql.Delete;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "Staff")
public class Staff {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private String phone;

    @Column
    private String email;
  
//    @OneToMany(mappedBy = "staff", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @Cascade(org.hibernate.annotations.CascadeType.ALL)
//    private List<DeliveryDetail> deliveryDetailId;
//
//    @OneToMany(mappedBy = "staff", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<InventoryReceiveNote> inventoryReceiveNoteId;
//
//    @OneToMany(mappedBy = "staff", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<Order> orderId;
//
//    @OneToMany(mappedBy = "staff", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<SaleInvoice> saleInvoiceId;

    public Staff(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
