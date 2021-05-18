package model;


import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class DeliveryDetail extends NoteDetail{

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="product_id", nullable = false)
    private Product product;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="staff_id", nullable = false)
    private Staff staff;
}
