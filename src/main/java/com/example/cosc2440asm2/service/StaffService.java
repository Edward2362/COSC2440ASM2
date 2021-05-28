package com.example.cosc2440asm2.service;

import com.example.cosc2440asm2.model.Staff;
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
        query.setString("id", "%"+id+"%");
        return query.list();
    }

    public int addStaff(Staff staff){
        sessionFactory.getCurrentSession().save(staff);
        return staff.getId();
    }

//    public List<Staff> getAllStaffs(){
//        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Staff.class);
//        return criteria.list();
//    }
//
//    public int updateStaff(int staffId, Staff staff){
//        Staff existedStaff = (Staff) sessionFactory.getCurrentSession().get(Staff.class, staffId);
//        existedStaff.setAddress(staff.getAddress());
//        existedStaff.setEmail(staff.getEmail());
//        existedStaff.setName(staff.getName());
//        existedStaff.setPhone(staff.getPhone());
//        sessionFactory.getCurrentSession().update(existedStaff);
//        return existedStaff.getId();
//    }
//
//    public Staff getStaffById(int staffId) {
//        return (Staff) sessionFactory.getCurrentSession().get(Staff.class, staffId);
//    }
//
//    public int deleteStaff(int staffId) {
//        Staff existedStaff = (Staff) sessionFactory.getCurrentSession().get(Staff.class, staffId);
//
//        sessionFactory.getCurrentSession().delete(existedStaff);
//        return existedStaff.getId();
//    }

    public int updateStaff(int id, Staff staff){
        String strId = String.valueOf(id);
        Query query = sessionFactory.getCurrentSession().createQuery(
                "update Staff set name=:staffName, address=:staffAddress, phone=:staffPhone, email=:staffEmail where id=:id"
        );
        query.setString("id", "%" + id + "%");
        query.setString("staffName", "%" + staff.getName() + "%");
        query.setString("staffAddress", "%" + staff.getAddress() + "%");
        query.setString("staffPhone", "%" + staff.getPhone() + "%");
        query.setString("staffEmail", "%" + staff.getEmail() + "%");
        return query.executeUpdate();
    }
//
    public int deleteStaff(int id){
        Query query = sessionFactory.getCurrentSession().createQuery(
                "delete Staff where id=:id"
        );
        query.setString("id", "%"+id+"%");
        return query.executeUpdate();
    }

}
