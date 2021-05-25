package service;

import model.Staff;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

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
        Query query = sessionFactory.getCurrentSession().createQuery(
                "insert into Staff(:staffName, :staffAddress, :staffPhone, :staffEmail)"
        );
        query.setString("staffName", "%" + staff.getName() + "%");
        query.setString("staffAddress", "%" + staff.getAddress() + "%");
        query.setString("staffPhone", "%" + staff.getPhone() + "%");
        query.setString("staffEmail", "%" + staff.getEmail() + "%");
        return query.executeUpdate();
    }

    public int updateStaff(int id, Staff staff){
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

    public int deleteStaff(int id){
        Query query = sessionFactory.getCurrentSession().createQuery(
                "delete Staff where id=:id"
        );
        query.setString("id", "%"+id+"%");
        return query.executeUpdate();
    }

}
