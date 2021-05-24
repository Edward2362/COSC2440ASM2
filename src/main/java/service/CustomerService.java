package service;

import model.Customer;
import model.SaleInvoice;
import model.Staff;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class CustomerService {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Staff> getAllCustomers() {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "from Customer"
        );
        return query.list();
    }

    public List<Staff> getCustomerById(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Customer where id=:id");
        query.setString("id", "%" + id + "%");
        return query.list();
    }

    public List<Staff> getCustomerByName(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Customer where name=:name");
        query.setString("name", "%" + name + "%");
        return query.list();
    }

    public List<Staff> getCustomerByPhone(String phone) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Customer where phone=:phone");
        query.setString("phone", "%" + phone + "%");
        return query.list();
    }

    public List<Staff> getCustomerByEmail(String email) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Customer where email=:email");
        query.setString("name", "%" + email + "%");
        return query.list();
    }

    public int addCustomer(Customer customer) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "insert into Customer(:customerName, :customerAddress, :customerPhone, :customerEmail, :customerFax, :customerContact)"
        );
        query.setString("customerName", "%" + customer.getName() + "%");
        query.setString("customerAddress", "%" + customer.getAddress() + "%");
        query.setString("customerPhone", "%" + customer.getPhone() + "%");
        query.setString("customerEmail", "%" + customer.getEmail() + "%");
        query.setString("customerFax", "%" + customer.getFax() + "%");
        query.setString("customerContact", "%" + customer.getContactPerson() + "%");

        for (SaleInvoice saleInvoice : customer.getSaleInvoiceId()) {
            saleInvoice.setCustomerID(customer);
        }

        return query.executeUpdate();
    }

    public int updateCustomer(Customer customer) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "update Customer set name=:customerName, address=:customerAddress, phone=:customerPhone, email=:customerEmail, fax=:customerFax, contactPerson=:customerContact"
        );
        query.setString("customerName", "%" + customer.getName() + "%");
        query.setString("customerAddress", "%" + customer.getAddress() + "%");
        query.setString("customerPhone", "%" + customer.getPhone() + "%");
        query.setString("customerEmail", "%" + customer.getEmail() + "%");
        query.setString("customerFax", "%" + customer.getFax() + "%");
        query.setString("customerContact", "%" + customer.getContactPerson() + "%");
        return query.executeUpdate();
    }

    public int deleteCustomer(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "delete Customer c where c.id=:id"
        );
        query.setString("id", "%" + id + "%");
        return query.executeUpdate();
    }
}
