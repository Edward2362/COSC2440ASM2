package com.example.cosc2440asm2.service;

import com.example.cosc2440asm2.model.SaleInvoice;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SaleInvoiceService {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){this.sessionFactory=sessionFactory;}

    public int addSaleInvoice(SaleInvoice saleInvoice) {
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
}
