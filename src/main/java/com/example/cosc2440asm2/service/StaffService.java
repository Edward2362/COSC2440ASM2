package com.example.cosc2440asm2.service;

import com.example.cosc2440asm2.model.*;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StaffService {


    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){this.sessionFactory=sessionFactory;}

    public List<Staff> getAllStaffs(){
        Query query = sessionFactory.getCurrentSession().createQuery(
                "from Staff"
        );
        return query.list();
    }

    public List<Staff> getStaffById(int id){
        Query query = sessionFactory.getCurrentSession().createQuery("from Staff where id=:id");
        query.setParameter("id", id);
        return query.list();
    }

    public int addStaff(Staff staff){
        sessionFactory.getCurrentSession().save(staff);
        return staff.getId();
    }


    public int updateStaff(int id, Staff staff){
        String strId = String.valueOf(id);
        Query query = sessionFactory.getCurrentSession().createQuery(
                "update Staff set name = :staffName, address = :staffAddress, phone = :staffPhone, email = :staffEmail where id = :id"
        );
        query.setParameter("id", id);
        query.setParameter("staffName", staff.getName());
        query.setParameter("staffAddress", staff.getAddress());
        query.setParameter("staffPhone", staff.getPhone());
        query.setParameter("staffEmail", staff.getEmail());
        return query.executeUpdate();
    }

    public int deleteStaff(int id){
        Staff existedStaff = sessionFactory.getCurrentSession().get(Staff.class, id);
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SaleInvoice.class);
        for (Object object: criteria.list()){
            SaleInvoice saleInvoice = (SaleInvoice) object;
            if (saleInvoice.getStaffID() != null) {
                if (saleInvoice.getStaffID().getId() == id) {
                    saleInvoice.setStaffID(null);
                    sessionFactory.getCurrentSession().update(saleInvoice);
                }
            }
        }
        criteria = sessionFactory.getCurrentSession().createCriteria(InventoryDeliveryNote.class);
        for (Object object: criteria.list()){
            InventoryDeliveryNote inventoryDeliveryNote = (InventoryDeliveryNote) object;
            if (inventoryDeliveryNote.getStaffID() != null){
                if (inventoryDeliveryNote.getStaffID().getId() == id){
                    inventoryDeliveryNote.setStaffID(null);
                    sessionFactory.getCurrentSession().update(inventoryDeliveryNote);
                }
            }
        }
        criteria = sessionFactory.getCurrentSession().createCriteria(InventoryReceiveNote.class);
        for (Object object: criteria.list()){
            InventoryReceiveNote inventoryReceiveNote = (InventoryReceiveNote) object;
            if (inventoryReceiveNote.getStaffID() != null){
                if (inventoryReceiveNote.getStaffID().getId() == id){
                    inventoryReceiveNote.setStaffID(null);
                    sessionFactory.getCurrentSession().update(inventoryReceiveNote);
                }
            }
        }
        criteria = sessionFactory.getCurrentSession().createCriteria(Order.class);
        for (Object object: criteria.list()){
            Order order = (Order) object;
            if (order.getStaffID() != null){
                if (order.getStaffID().getId() == id){
                    order.setStaffID(null);
                    sessionFactory.getCurrentSession().update(order);
                }
            }
        }
        sessionFactory.getCurrentSession().delete(existedStaff);
        return existedStaff.getId();
    }

}
