package com.example.cosc2440asm2.model;



import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.*;

@Entity
@Table(name = "reveivingDetail")
public class ReceivingDetail extends NoteDetail{

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "inventory_receive_note_id", nullable = false)
    private InventoryReceiveNote inventoryReceiveNoteID;

    public ReceivingDetail() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public InventoryReceiveNote getInventoryReceiveNoteID() {
        return inventoryReceiveNoteID;
    }

    public void setInventoryReceiveNoteID(InventoryReceiveNote inventoryReceiveNoteID) {
        this.inventoryReceiveNoteID = inventoryReceiveNoteID;
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
