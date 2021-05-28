package com.example.cosc2440asm2.service;

import com.example.cosc2440asm2.model.Customer;
import com.example.cosc2440asm2.model.SaleInvoice;
import com.example.cosc2440asm2.model.Staff;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerService {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Customer> getAllCustomers() {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "from Customer"
        );
        return query.list();
    }

    public List<Customer> getCustomerById(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Customer where id=:id");
        query.setParameter("id", id);
        return query.list();
    }

    public List<Customer> getCustomerByName(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Customer where name=:name");
        query.setParameter("name", name);
        return query.list();
    }

    public List<Customer> getCustomerByPhone(String phone) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Customer where phone=:phone");
        query.setParameter("phone", phone);
        return query.list();
    }

    public List<Customer> getCustomerByEmail(String email) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Customer where email=:email");
        query.setParameter("email", email);
        return query.list();
    }

    public int addCustomer(Customer customer) {
        sessionFactory.getCurrentSession().save(customer);
        return customer.getId();
    }

//    public int addCustomer(Customer customer) {
//        Query query = sessionFactory.getCurrentSession().createQuery(
//                "insert into Customer(:customerName, :customerAddress, :customerPhone, :customerEmail, :customerFax, :customerContact)"
//        );
//        query.setParameter("customerName", customer.getName());
//        query.setParameter("customerAddress", customer.getAddress());
//        query.setParameter("customerPhone", customer.getPhone());
//        query.setParameter("customerEmail", customer.getEmail());
//        query.setParameter("customerFax", customer.getFax());
//        query.setParameter("customerContact", customer.getContactPerson());
//
////        for (SaleInvoice saleInvoice : customer.getSaleInvoiceId()) {
////            saleInvoice.setCustomerID(customer);
////        }
//
//        return query.executeUpdate();
//    }

    public int updateCustomer(int id, Customer customer) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "update Customer set name=:customerName, address=:customerAddress, phone=:customerPhone, email=:customerEmail, fax=:customerFax, contactPerson=:customerContact where id=:id"
        );
        query.setParameter("id", id);
        query.setParameter("customerName", customer.getName());
        query.setParameter("customerAddress", customer.getAddress());
        query.setParameter("customerPhone", customer.getPhone());
        query.setParameter("customerEmail", customer.getEmail());
        query.setParameter("customerFax", customer.getFax());
        query.setParameter("customerContact", customer.getContactPerson());
        return query.executeUpdate();
    }

    public int deleteCustomer(int id) {
        Customer existedCustomer = sessionFactory.getCurrentSession().get(Customer.class, id);
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SaleInvoice.class);
        for (Object object: criteria.list()){
            SaleInvoice saleInvoice = (SaleInvoice) object;
            if (saleInvoice.getCustomerID() != null) {
                if (saleInvoice.getCustomerID().getId() == id) {
                    saleInvoice.setCustomerID(null);
                    sessionFactory.getCurrentSession().update(saleInvoice);
                }
            }
        }
        sessionFactory.getCurrentSession().delete(existedCustomer);
        return existedCustomer.getId();
    }
}
