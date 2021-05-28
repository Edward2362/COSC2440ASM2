package com.example.cosc2440asm2.service;

import com.example.cosc2440asm2.model.*;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class InventoryDeliveryNoteService {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<InventoryDeliveryNote> getAllDeliveryNote() {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "select inventoryDeliveryNote"
        );
        return query.list();
    }

    public List<InventoryDeliveryNote> getInventoryDeliveryNoteById(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "select inventoryDeliveryNote where id=:id"
        );
        query.setString("id", "%" + id + "%");
        return query.list();
    }

//    public int addInventoryDeliveryNote(InventoryDeliveryNote deliveryNote) {
//        Query query = sessionFactory.getCurrentSession().createQuery(
//                "insert into deliveryNote(date=:date, staffId=:staffId)"
//        );
//        query.setString("date", "&" + deliveryNote.getDate() + "%");
//        query.setString("staffId", "&" + deliveryNote.getStaffID() + "%");
//
//        for (DeliveryDetail deliveryDetail : deliveryNote.getDeliveryDetailList()){
//            deliveryDetail.setInventoryDeliveryNoteID(deliveryNote);
//        }
//
//        return query.executeUpdate();
//    }

    public int addInventoryDeliveryNote(InventoryDeliveryNote inventoryDeliveryNote) {
        for(DeliveryDetail deliveryDetail: inventoryDeliveryNote.getDeliveryDetailList()){
            deliveryDetail.setInventoryDeliveryNoteID(inventoryDeliveryNote);
        }
        sessionFactory.getCurrentSession().save(inventoryDeliveryNote);
        return inventoryDeliveryNote.getId();
    }

    public int updateInventoryDeliveryNote(int id, InventoryDeliveryNote deliveryNote) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "update deliveryNote date=:date, staffId=:staffId where id=:id"
        );
        query.setString("date", "&" + deliveryNote.getDate() + "%");
        query.setString("staffId", "&" + deliveryNote.getStaffID() + "%");
        query.setString("id", "&" + id + "%");



        return query.executeUpdate();
    }

    public int deleteInventoryDeliveryNote
            (int id) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "delete deliveryNote where id=:id"
        );
        query.setString("id", "&" + id + "%");

        return query.executeUpdate();
    }

    public List<InventoryDeliveryNote> filterByDate(Date sDate, Date eDate){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(InventoryDeliveryNote.class);
        criteria.add(Restrictions.ge("date", sDate));
        criteria.add(Restrictions.le("date", eDate));
        return criteria.list();
    }

}
