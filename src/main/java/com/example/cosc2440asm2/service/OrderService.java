package com.example.cosc2440asm2.service;

import com.example.cosc2440asm2.model.Order;
import com.example.cosc2440asm2.model.OrderDetail;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderService {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Order> getAllOrders() {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "select Order"
        );
        return query.list();
    }

    public List<Order> getOrderById(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "select Order where id=:id"
        );
        query.setParameter("id", id);
        return query.list();
    }

    public int addOrder(Order order) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "insert into Order(date=:date, staffId=:staffId, providerId:providerId)"
        );
        query.setParameter("date", order.getDate());
        query.setParameter("staffId", order.getStaffID());
        query.setParameter("providerId", order.getProviderID());

        for (OrderDetail orderDetail : order.getOrderDetailList()) {
            orderDetail.setOrderId(order);
        }
        return query.executeUpdate();
    }

    public int updateOrder(int id, Order order) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "update Order date=:date, staffId=:staffId, providerId:providerId where id=:id"
        );
        query.setParameter("date", order.getDate());
        query.setParameter("staffId", order.getStaffID());
        query.setParameter("providerId", order.getProviderID());
        query.setParameter("id", id);
        return query.executeUpdate();
    }

    public int deleteOrder(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "delete Order where id=:id"
        );
        query.setParameter("id", id);
        return query.executeUpdate();
    }
}
