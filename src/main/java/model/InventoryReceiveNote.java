package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "inventoryReciveNote")
public class InventoryReceiveNote extends Note{
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    public InventoryReceiveNote(){};

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
