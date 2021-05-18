package service;

import model.Provider;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class ProviderService {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Provider> getAllProviders(){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Provider.class);
        return criteria.list();
    }
}
