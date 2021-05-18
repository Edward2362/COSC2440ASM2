package model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "inventoryDeliveryNote")
public class InventoryDeliveryNote extends Note {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    public InventoryDeliveryNote() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    public Staff getStaff() {
        return super.getStaff();
    }

    @Override
    public void setStaff(Staff staff) {
        super.setStaff(staff);
    }

}
