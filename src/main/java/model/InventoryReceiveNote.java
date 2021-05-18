package model;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "inventoryReciveNote")
public class InventoryReceiveNote extends Note{
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="staff_id", nullable = false)
    private Staff staff;


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
