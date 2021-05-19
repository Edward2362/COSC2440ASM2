package model;


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
    private List<DeliveryDetail> deliveryDetailList;

    public InventoryDeliveryNote() {
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
