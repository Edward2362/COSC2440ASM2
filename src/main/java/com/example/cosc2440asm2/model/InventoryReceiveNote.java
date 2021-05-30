package com.example.cosc2440asm2.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.FetchType;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "inventoryReceiveNote")
public class InventoryReceiveNote extends Note{
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "inventoryReceiveNoteID", cascade = CascadeType.ALL, fetch =
            FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    private List<ReceivingDetail> receivingDetailList;

    public  InventoryReceiveNote(){};

    public InventoryReceiveNote(List<ReceivingDetail> receivingDetailList) {
        this.receivingDetailList = receivingDetailList;
    }

    public InventoryReceiveNote(Date date, List<ReceivingDetail> receivingDetailList) {
        super(date);
        this.receivingDetailList = receivingDetailList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ReceivingDetail> getReceivingDetailList() {
        return receivingDetailList;
    }

    public void setReceivingDetailList(List<ReceivingDetail> receivingDetailList) {
        this.receivingDetailList = receivingDetailList;
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
