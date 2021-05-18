package model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Staff extends AbstractForCP{
    @OneToMany(mappedBy = "staff", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<DeliveryDetail> deliveryDetailId;

    @OneToMany(mappedBy = "staff", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<InventoryReceiveNote> inventoryReceiveNoteId;

    @OneToMany(mappedBy = "staff", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Order> orderId;

    @OneToMany(mappedBy = "staff", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SaleInvoice> saleInvoiceId;
}
