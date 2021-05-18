package model;

import javax.persistence.*;

@Entity
public class AbstractForCP {
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String phone;

    @Column
    private String email;

    @Column
    private String fax;

    // TODO
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="contact")
//    private AbstractForCP contactPerson;
}
