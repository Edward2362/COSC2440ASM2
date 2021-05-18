package service;

import model.OrderDetail;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class OrderDetailService {
    @Autowired
    private SessionFactory sessionFactory;

    public List<OrderDetail> getAllOrderDetails(){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(OrderDetail.class);
        return criteria.list();
    }
}
