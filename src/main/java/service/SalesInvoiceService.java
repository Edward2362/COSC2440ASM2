package service;

import model.SalesInvoice;
import model.Staff;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class SalesInvoiceService {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){this.sessionFactory=sessionFactory;}

    public List<SalesInvoice> getAllSalesInvoices(){
        Criteria criteria= sessionFactory.getCurrentSession().createCriteria(SalesInvoice.class);
        return criteria.list();
    }
}
