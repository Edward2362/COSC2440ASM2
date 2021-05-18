package service;

import model.Staff;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class StaffService {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){this.sessionFactory=sessionFactory;}

    public List<Staff> getAllStaffs(){
        Criteria criteria= sessionFactory.getCurrentSession().createCriteria(Staff.class);
        return criteria.list();
    }

}
