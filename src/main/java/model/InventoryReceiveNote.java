package model;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class InventoryReceiveNote extends InventoryNote{
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="staff_id", nullable = false)
    private Staff staff;
}
