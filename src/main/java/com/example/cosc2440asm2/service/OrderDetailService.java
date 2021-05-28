package com.example.cosc2440asm2.service;

import com.example.cosc2440asm2.model.OrderDetail;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderDetailService {
    @Autowired
    private SessionFactory sessionFactory;

    public List<OrderDetail> getAllOrderDetails(){
        Query query = sessionFactory.getCurrentSession().createQuery(
                "select orderDetail"
        );
        return query.list();
    }

    public List<OrderDetail> getOrderDetailById(int id){
        Query query = sessionFactory.getCurrentSession().createQuery(
                "select orderDetail where id=:id"
        );
        query.setParameter("id", id);
        return query.list();
    }

    public int addOrderDetail(OrderDetail orderDetail){
        Query query = sessionFactory.getCurrentSession().createQuery(
                "insert into orderDetail(productId=:productId, quantity=:quantity, price=:price)"
        );
        query.setParameter("productId", orderDetail.getProductID());
        query.setParameter("quantity", orderDetail.getQuantity());
        query.setParameter("price", orderDetail.getPrice());

        return query.executeUpdate();
    }

    public int updateOrderDetail(int id, OrderDetail orderDetail){
        Query query = sessionFactory.getCurrentSession().createQuery(
                "update orderDetail productId=:productId, quantity=:quantity, price=:price where id=:id"
        );
        query.setParameter("productId", orderDetail.getProductID());
        query.setParameter("quantity", orderDetail.getQuantity());
        query.setParameter("price", orderDetail.getPrice());
        query.setParameter("id", id);

        return query.executeUpdate();
    }

    public int deleteOrderDetail(int id){
        Query query = sessionFactory.getCurrentSession().createQuery(
                "delete orderDetail where id=:id"
        );
        query.setParameter("id", id);

        return query.executeUpdate();
    }

}
