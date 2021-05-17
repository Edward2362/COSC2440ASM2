package service;

import model.Order;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class OrderService {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Order> getAllOrders(){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Order.class);
        return criteria.list();
    }
}
