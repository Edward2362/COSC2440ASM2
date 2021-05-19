package model;

import javax.persistence.*;

@MappedSuperclass
public class AbstractForCP {

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private String phone;

    @Column
    private String email;

    @Column
    private String fax;

    @Column
    private String contactPerson;
}
