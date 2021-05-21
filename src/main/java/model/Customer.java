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

    @OneToMany(mappedBy = "customerID", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<SaleInvoice> saleInvoiceId;

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<SaleInvoice> getSaleInvoiceId() {
        return saleInvoiceId;
    }

    public void setSaleInvoiceId(List<SaleInvoice> saleInvoiceId) {
        this.saleInvoiceId = saleInvoiceId;
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
