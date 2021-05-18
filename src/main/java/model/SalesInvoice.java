package model;

import javax.persistence.*;

@Entity
@Table(name = "salesInvoice")
public class SalesInvoice extends Note {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn
    private Customer customer;

    public SalesInvoice(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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
