package com.example.cosc2440asm2.service;

import com.example.cosc2440asm2.model.DeliveryDetail;
import com.example.cosc2440asm2.model.InventoryDeliveryNote;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    public List<InventoryDeliveryNote> getInventoryDeliveryNote(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "select inventoryDeliveryNote where id=:id"
        );
        query.setParameter("id", id);
        return query.list();
    }

    public int addInventoryDeliveryNote(InventoryDeliveryNote deliveryNote) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "insert into deliveryNote(date=:date, staffId=:staffId)"
        );
        query.setParameter("date", deliveryNote.getDate());
        query.setParameter("staffId", deliveryNote.getStaffID());

        for (DeliveryDetail deliveryDetail : deliveryNote.getDeliveryDetailList()){
            deliveryDetail.setInventoryDeliveryNoteID(deliveryNote);
        }

        return query.executeUpdate();
    }

    public int updateInventoryDeliveryNote(int id, InventoryDeliveryNote deliveryNote) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "update deliveryNote date=:date, staffId=:staffId where id=:id"
        );
        query.setParameter("date", deliveryNote.getDate());
        query.setParameter("staffId", deliveryNote.getStaffID());
        query.setParameter("id", id);



        return query.executeUpdate();
    }

    public int deleteInventoryDeliveryNote
            (int id) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "delete deliveryNote where id=:id"
        );
        query.setParameter("id", id);

        return query.executeUpdate();
    }
}
