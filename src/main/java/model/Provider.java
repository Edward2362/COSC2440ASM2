package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "provider")
public class Provider extends AbstractForCP{
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "provider", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Order> orderId;
}
