package com.example.cosc2440asm2.service;

import com.example.cosc2440asm2.model.InventoryReceiveNote;
import com.example.cosc2440asm2.model.ReceivingDetail;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class InventoryReceiveNoteService {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<InventoryReceiveNote> getAllReceiveNotes() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(InventoryReceiveNote.class);
        return criteria.list();
    }

    public int getInventoryReceiveNoteById(int inventoryReceiveNoteId) {
        InventoryReceiveNote existedInventoryReceiveNote = (InventoryReceiveNote) sessionFactory.getCurrentSession().get(InventoryReceiveNote.class, inventoryReceiveNoteId);
        return existedInventoryReceiveNote.getId();
    }

    public int addInventoryReceiveNote(InventoryReceiveNote inventoryReceiveNote) {
        for(ReceivingDetail receivingDetail: inventoryReceiveNote.getReceivingDetailList())
        sessionFactory.getCurrentSession().save(inventoryReceiveNote);
        return inventoryReceiveNote.getId();
    }

    public int  deleteInventoryReceiveNote(int inventoryReceiveNoteId){
        InventoryReceiveNote existedInventoryReceiveNote = (InventoryReceiveNote) sessionFactory.getCurrentSession().get(InventoryReceiveNote.class, inventoryReceiveNoteId );
        sessionFactory.getCurrentSession().delete(existedInventoryReceiveNote);
        return existedInventoryReceiveNote.getId();
    }

    public int updateInventoryReceiveNote(int inventoryReceiveNoteId, InventoryReceiveNote inventoryReceiveNote){
        InventoryReceiveNote existedInventoryReceiveNote = (InventoryReceiveNote) sessionFactory.getCurrentSession().get(InventoryReceiveNote.class, inventoryReceiveNoteId);
        existedInventoryReceiveNote.setDate(inventoryReceiveNote.getDate());
        existedInventoryReceiveNote.setStaffID(inventoryReceiveNote.getStaffID());
        existedInventoryReceiveNote.setReceivingDetailList(inventoryReceiveNote.getReceivingDetailList());
        sessionFactory.getCurrentSession().update(existedInventoryReceiveNote);
        return existedInventoryReceiveNote.getId();
    }


}
