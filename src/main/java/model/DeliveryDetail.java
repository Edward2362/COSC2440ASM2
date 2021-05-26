package model;


import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.*;

@Entity
@Table(name = "deliveryDetail")
public class DeliveryDetail extends NoteDetail{

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "inventory_delivery_note_id", nullable = false)
    private InventoryDeliveryNote inventoryDeliveryNoteID;

    public DeliveryDetail() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public InventoryDeliveryNote getInventoryDeliveryNoteID() {
        return inventoryDeliveryNoteID;
    }

    public void setInventoryDeliveryNoteID(InventoryDeliveryNote inventoryDeliveryNoteID) {
        this.inventoryDeliveryNoteID = inventoryDeliveryNoteID;
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
