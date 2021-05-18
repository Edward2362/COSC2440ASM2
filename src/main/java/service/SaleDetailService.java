package service;

import model.SaleDetail;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class SaleDetailService {
    @Autowired
    private SessionFactory sessionFactory;

    public List<SaleDetail> getAllSaleDetails(){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SaleDetail.class);
        return criteria.list();
    }
}
