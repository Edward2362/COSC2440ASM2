package service;

import model.DeliveryDetail;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class DeliveryDetailService {
    @Autowired
    private SessionFactory sessionFactory;

    public List<DeliveryDetail> getAllDeliveryDetails(){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(DeliveryDetail.class);
        return criteria.list();
    }
}
