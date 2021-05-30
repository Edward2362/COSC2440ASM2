package com.example.cosc2440asm2.model;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "inventoryDeliveryNote")
public class InventoryDeliveryNote extends Note {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "inventoryDeliveryNoteID", cascade = CascadeType.ALL, fetch =
            FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    private List<DeliveryDetail> deliveryDetailList;

    public InventoryDeliveryNote() {
    }

    public InventoryDeliveryNote(List<DeliveryDetail> deliveryDetailList) {
        this.deliveryDetailList = deliveryDetailList;
    }

    public InventoryDeliveryNote(Date date, List<DeliveryDetail> deliveryDetailList) {
        super(date);
        this.deliveryDetailList = deliveryDetailList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<DeliveryDetail> getDeliveryDetailList() {
        return deliveryDetailList;
    }

    public void setDeliveryDetailList(List<DeliveryDetail> deliveryDetailList) {
        this.deliveryDetailList = deliveryDetailList;
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
