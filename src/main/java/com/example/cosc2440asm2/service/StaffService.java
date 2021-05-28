package com.example.cosc2440asm2.service;

import com.example.cosc2440asm2.model.Staff;
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
        this.sessionFactory.getCurrentSession().save(staff);
        return staff.getId();
    }

    public int updateStaff(int id, Staff staff){
        Query query = sessionFactory.getCurrentSession().createQuery(
                "update Staff set name = :staffName, address = :staffAddress, phone = :staffPhone, email = :staffEmail where id = :id"
        );
//        query.setParameter()("id", "%" + String.valueOf(id) + "%");
        query.setParameter("id", id);
        query.setParameter("staffName", staff.getName());
        query.setParameter("staffAddress", staff.getAddress());
        query.setParameter("staffPhone", staff.getPhone());
        query.setParameter("staffEmail", staff.getEmail());
        return query.executeUpdate();
    }

    public int deleteStaff(int id){
        Query query = sessionFactory.getCurrentSession().createQuery(
                "delete Staff where id=:id"
        );
        query.setParameter("id", id);
        return query.executeUpdate();
    }

}
