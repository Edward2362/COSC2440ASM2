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
                "from InventoryDeliveryNote"
        );
        return query.list();
    }

    public List<InventoryDeliveryNote> getInventoryDeliveryNoteById(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "from InventoryDeliveryNote where id=:id"
        );
        query.setParameter("id", id);
        return query.list();
    }

    public int addInventoryDeliveryNote(InventoryDeliveryNote inventoryDeliveryNote) {
        for(DeliveryDetail deliveryDetail: inventoryDeliveryNote.getDeliveryDetailList()){
            deliveryDetail.setInventoryDeliveryNoteID(inventoryDeliveryNote);
        }
        sessionFactory.getCurrentSession().save(inventoryDeliveryNote);
        return inventoryDeliveryNote.getId();
    }

    public int updateInventoryDeliveryNote(int id, InventoryDeliveryNote deliveryNote) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "update InventoryDeliveryNote set date=:date, staffID=:staffId where id=:id"
        );
        query.setParameter("date", deliveryNote.getDate());
        query.setParameter("staffId", deliveryNote.getStaffID());
        query.setParameter("id", id);
        return query.executeUpdate();
    }

    public int deleteInventoryDeliveryNote(int id) {
        InventoryDeliveryNote existedInventoryDeliveryNote = (InventoryDeliveryNote) sessionFactory.getCurrentSession().get(InventoryDeliveryNote.class, id);
        sessionFactory.getCurrentSession().delete(existedInventoryDeliveryNote);
        return existedInventoryDeliveryNote.getId();
    }

    public List<InventoryDeliveryNote> filterByDate(Date sDate, Date eDate){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(InventoryDeliveryNote.class);
        criteria.add(Restrictions.ge("date", sDate));
        criteria.add(Restrictions.le("date", eDate));
        return criteria.list();
    }

}
