package com.example.cosc2440asm2.service;

import com.example.cosc2440asm2.model.Customer;
import com.example.cosc2440asm2.model.SaleDetail;
import com.example.cosc2440asm2.model.SaleInvoice;
import com.example.cosc2440asm2.model.Staff;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class SaleInvoiceService {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){this.sessionFactory=sessionFactory;}

    public int addSaleInvoice(SaleInvoice saleInvoice) {
        for (SaleDetail saleDetail: saleInvoice.getSaleDetailList()) {
            saleDetail.setSaleInvoiceID(saleInvoice);
        }
        sessionFactory.getCurrentSession().save(saleInvoice);
        return saleInvoice.getId();
    }

    public int deleteSaleInvoice(int saleInvoiceId) {
        SaleInvoice existedSaleInvoice = (SaleInvoice)sessionFactory.getCurrentSession().get(SaleInvoice.class, saleInvoiceId);
        sessionFactory.getCurrentSession().delete(existedSaleInvoice);
        return existedSaleInvoice.getId();
    }

    public int updateSaleInvoice(int saleInvoiceId, SaleInvoice saleInvoice) {
        SaleInvoice existedSaleInvoice = (SaleInvoice)sessionFactory.getCurrentSession().get(SaleInvoice.class, saleInvoiceId);
        existedSaleInvoice.setDate(saleInvoice.getDate());
        existedSaleInvoice.setCustomerID(saleInvoice.getCustomerID());
        existedSaleInvoice.setStaffID(saleInvoice.getStaffID());
        sessionFactory.getCurrentSession().update(existedSaleInvoice);
        return existedSaleInvoice.getId();
    }

    public SaleInvoice getSaleInvoiceById(int saleInvoiceId) {
        return (SaleInvoice)sessionFactory.getCurrentSession().get(SaleInvoice.class, saleInvoiceId);
    }

    public List<SaleInvoice> getAllSalesInvoices(){
        Criteria criteria= sessionFactory.getCurrentSession().createCriteria(SaleInvoice.class);
        return criteria.list();
    }

    public List<SaleInvoice> filterByDate(Date sDate, Date eDate){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SaleInvoice.class);
        criteria.add(Restrictions.ge("date", sDate));
        criteria.add(Restrictions.le("date", eDate));
        return criteria.list();
    }

    public List<SaleInvoice> filterByDateAndByCustomer(Date sDate, Date eDate, int customerID){
        Customer customer = sessionFactory.getCurrentSession().get(Customer.class, customerID);
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SaleInvoice.class);
        criteria.add(Restrictions.eq("customerID", customer));
        criteria.add(Restrictions.ge("date", sDate));
        criteria.add(Restrictions.le("date", eDate));
        return criteria.list();
    }

    public List<SaleInvoice> filterByDateAndByStaff(Date sDate, Date eDate, int staffID){
        Staff staff = sessionFactory.getCurrentSession().get(Staff.class, staffID);
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SaleInvoice.class);
        criteria.add(Restrictions.eq("staffID", staff));
        criteria.add(Restrictions.ge("date", sDate));
        criteria.add(Restrictions.le("date", eDate));
        return criteria.list();
    }
}
