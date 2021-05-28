package com.example.cosc2440asm2.service;

import com.example.cosc2440asm2.model.DeliveryDetail;
import com.example.cosc2440asm2.model.OrderDetail;
import com.example.cosc2440asm2.model.ReceivingDetail;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DeliveryDetailService {
    @Autowired
    private SessionFactory sessionFactory;

    public List<DeliveryDetail> getAllDeliveryDetails(){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(DeliveryDetail.class);
        return criteria.list();
    }

    public DeliveryDetail getDeliveryDetailById(int deliveryDetailId) {
        return (DeliveryDetail) sessionFactory.getCurrentSession().get(DeliveryDetail.class, deliveryDetailId);
    }

//    public int addReceivingDetails(ReceivingDetail receivingDetail) {
//        sessionFactory.getCurrentSession().save(receivingDetail);
//        return receivingDetail.getId();
//    }

    public int  deleteDeliveryDetails(int deliveryDetailId){
        DeliveryDetail existedDeliveryDetail = (DeliveryDetail) sessionFactory.getCurrentSession().get(DeliveryDetail.class, deliveryDetailId );
        existedDeliveryDetail.getInventoryDeliveryNoteID().getDeliveryDetailList().remove(existedDeliveryDetail);
        sessionFactory.getCurrentSession().delete(existedDeliveryDetail);
        return existedDeliveryDetail.getId();
    }

    public int updateDeliveryDetail(int deliveryDetailId, DeliveryDetail deliveryDetail){
        DeliveryDetail existedDeliveryDetail = (DeliveryDetail) sessionFactory.getCurrentSession().get(DeliveryDetail.class, deliveryDetailId);
        existedDeliveryDetail.setProductID(deliveryDetail.getProductID());
        existedDeliveryDetail.setQuantity(deliveryDetail.getQuantity());
        sessionFactory.getCurrentSession().update(existedDeliveryDetail);
        return existedDeliveryDetail.getId();
    }

//    public List<OrderDetail> getAllOrderDetails(){
//        Query query = sessionFactory.getCurrentSession().createQuery(
//                "select deliveryDetail"
//        );
//        return query.list();
//    }
//
//    public List<OrderDetail> getOrderDetailById(int id){
//        Query query = sessionFactory.getCurrentSession().createQuery(
//                "select orderDetail where id=:id"
//        );
//        query.setString("id", "%"+id+"%");
//        return query.list();
//    }
//
//    public int addOrderDetail(OrderDetail orderDetail){
//        Query query = sessionFactory.getCurrentSession().createQuery(
//                "insert into orderDetail(productId=:productId, quantity=:quantity, price=:price)"
//        );
//        query.setString("productId", "&"+orderDetail.getProductID()+"%");
//        query.setString("quantity", "&"+orderDetail.getQuantity()+"%");
//        query.setString("price", "&"+orderDetail.getPrice()+"%");
//
//        return query.executeUpdate();
//    }
//
//    public int updateOrderDetail(int id, OrderDetail orderDetail){
//        Query query = sessionFactory.getCurrentSession().createQuery(
//                "update orderDetail productId=:productId, quantity=:quantity, price=:price where id=:id"
//        );
//        query.setString("productId", "&"+orderDetail.getProductID()+"%");
//        query.setString("quantity", "&"+orderDetail.getQuantity()+"%");
//        query.setString("price", "&"+orderDetail.getPrice()+"%");
//        query.setString("id", "&"+id+"%");
//
//        return query.executeUpdate();
//    }
//
//    public int deleteOrderDetail(int id){
//        Query query = sessionFactory.getCurrentSession().createQuery(
//                "delete orderDetail where id=:id"
//        );
//        query.setString("id", "&"+id+"%");
//
//        return query.executeUpdate();
//    }
}
