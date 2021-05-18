package model;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Order {
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="staff_id", nullable = false)
    private Staff staff;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="provider_id", nullable = false)
    private Provider provider;
}
