package service;

import model.Order;
import model.OrderDetail;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

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
        query.setString("id", "%" + id + "%");
        return query.list();
    }

    public int addOrder(Order order) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "insert into Order(date=:date, staffId=:staffId, providerId:providerId)"
        );
        query.setString("date", "%" + order.getDate() + "%");
        query.setString("staffId", "%" + order.getStaffID() + "%");
        query.setString("providerId", "%" + order.getProviderID() + "%");

        for (OrderDetail orderDetail : order.getOrderDetailList()) {
            orderDetail.setOrderId(order);
        }
        return query.executeUpdate();
    }

    public int updateOrder(int id, Order order) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "update Order date=:date, staffId=:staffId, providerId:providerId where id=:id"
        );
        query.setString("date", "%" + order.getDate() + "%");
        query.setString("staffId", "%" + order.getStaffID() + "%");
        query.setString("providerId", "%" + order.getProviderID() + "%");
        query.setString("id", "%" + id + "%");
        return query.executeUpdate();
    }

    public int deleteOrder(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "delete Order where id=:id"
        );
        query.setString("id", "%" + id + "%");
        return query.executeUpdate();
    }
}
