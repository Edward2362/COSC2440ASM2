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
public class SalesInvoiceService {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){this.sessionFactory=sessionFactory;}

    public List<SaleInvoice> getAllSalesInvoices(){
        Criteria criteria= sessionFactory.getCurrentSession().createCriteria(SaleInvoice.class);
        return criteria.list();
    }
}
