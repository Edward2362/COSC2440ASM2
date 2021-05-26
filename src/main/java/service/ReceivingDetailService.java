package service;

import model.ReceivingDetail;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class ReceivingDetailService {
    @Autowired
    private SessionFactory sessionFactory;

    public List<ReceivingDetail> getAllReceivingDetails(){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ReceivingDetail.class);
        return criteria.list();
    }
}
