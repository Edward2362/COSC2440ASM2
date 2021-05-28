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

    public int addCustomer(Customer customer){
        sessionFactory.getCurrentSession().save(customer);
        return customer.getId();
    }

//    public List<Customer> getAllCustomers(){
//        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Customer.class);
//        return criteria.list();
//    }
//
//    public int updateCustomer(int customerId, Customer customer){
//        Customer existedCustomer = (Customer) sessionFactory.getCurrentSession().get(Customer.class, customerId);
//        existedCustomer.setAddress(customer.getAddress());
//        existedCustomer.setEmail(customer.getEmail());
//        existedCustomer.setName(customer.getName());
//        existedCustomer.setPhone(customer.getPhone());
//        existedCustomer.setFax(customer.getFax());
//        existedCustomer.setContactPerson(customer.getContactPerson());
//        sessionFactory.getCurrentSession().update(existedCustomer);
//        return existedCustomer.getId();
//    }
//
//    public int deleteCustomer(int customerId) {
//        Customer existedCustomer = (Customer) sessionFactory.getCurrentSession().get(Customer.class, customerId);
//        sessionFactory.getCurrentSession().delete(existedCustomer);
//        return existedCustomer.getId();
//    }
//
//    public Customer getCustomerById(int customerId) {
//        return (Customer) sessionFactory.getCurrentSession().get(Customer.class, customerId);
//    }
//
//    public List<Customer> getCustomerByName(String name) {
//        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Customer.class);
//        criteria.add(Restrictions.like("name", name, MatchMode.ANYWHERE));
//        return criteria.list();
//    }
//
//    public List<Customer> getCustomerByPhone(String phone) {
//        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Customer.class);
//        criteria.add(Restrictions.like("phone", phone, MatchMode.ANYWHERE));
//        return criteria.list();
//    }
//
//    public List<Customer> getCustomerByEmail(String email) {
//        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Customer.class);
//        criteria.add(Restrictions.like("email", email, MatchMode.ANYWHERE));
//        return criteria.list();
//    }
    public List<Customer> getAllCustomers() {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "from Customer"
        );
        return query.list();
    }

    public List<Customer> getCustomerById(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Customer where id=:id");
        query.setString("id", "%" + id + "%");
        return query.list();
    }

    public List<Customer> getCustomerByName(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Customer where name=:name");
        query.setString("name", "%" + name + "%");
        return query.list();
    }

    public List<Customer> getCustomerByPhone(String phone) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Customer where phone=:phone");
        query.setString("phone", "%" + phone + "%");
        return query.list();
    }

    public List<Customer> getCustomerByEmail(String email) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Customer where email=:email");
        query.setString("name", "%" + email + "%");
        return query.list();
    }

//    public int addCustomer(Customer customer) {
//        Query query = sessionFactory.getCurrentSession().createQuery(
//                "insert into Customer(:customerName, :customerAddress, :customerPhone, :customerEmail, :customerFax, :customerContact)"
//        );
//        query.setString("customerName", "%" + customer.getName() + "%");
//        query.setString("customerAddress", "%" + customer.getAddress() + "%");
//        query.setString("customerPhone", "%" + customer.getPhone() + "%");
//        query.setString("customerEmail", "%" + customer.getEmail() + "%");
//        query.setString("customerFax", "%" + customer.getFax() + "%");
//        query.setString("customerContact", "%" + customer.getContactPerson() + "%");
//
//        for (SaleInvoice saleInvoice : customer.getSaleInvoiceId()) {
//            saleInvoice.setCustomerID(customer);
//        }
//
//        return query.executeUpdate();
//    }

    public int updateCustomer(int id, Customer customer) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "update Customer set name=:customerName, address=:customerAddress, phone=:customerPhone, email=:customerEmail, fax=:customerFax, contactPerson=:customerContact where id=:id"
        );
        query.setString("id", "%" + id + "%");
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
