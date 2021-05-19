package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer extends AbstractForCP{
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SaleInvoice> saleInvoiceId;
}
