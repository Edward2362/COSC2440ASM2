package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Provider")
public class Provider extends AbstractForCP{
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Provider() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getAddress() {
        return super.getAddress();
    }

    @Override
    public void setAddress(String address) {
        super.setAddress(address);
    }

    @Override
    public String getPhone() {
        return super.getPhone();
    }

    @Override
    public void setPhone(String phone) {
        super.setPhone(phone);
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }

    @Override
    public String getFax() {
        return super.getFax();
    }

    @Override
    public void setFax(String fax) {
        super.setFax(fax);
    }

    @Override
    public String getContactPerson() {
        return super.getContactPerson();
    }

    @Override
    public void setContactPerson(String contactPerson) {
        super.setContactPerson(contactPerson);
    }
}
