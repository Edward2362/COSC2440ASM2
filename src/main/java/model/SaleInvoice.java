package model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SaleInvoice {
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="staff_id", nullable = false)
    private Staff staff;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="customer_id", nullable = false)
    private Customer customer;
}
