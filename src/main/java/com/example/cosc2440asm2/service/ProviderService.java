package com.example.cosc2440asm2.service;

import com.example.cosc2440asm2.model.Order;
import com.example.cosc2440asm2.model.Provider;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProviderService {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){this.sessionFactory=sessionFactory;}

    public List<Provider> getAllProviders(){
        Query query = sessionFactory.getCurrentSession().createQuery(
                "from Provider"
        );
        return query.list();
    }

    public List<Provider> getProviderById(int id){
        Query query = sessionFactory.getCurrentSession().createQuery("from Provider where id=:id");
        query.setParameter("id", id);
        return query.list();
    }

    public int addProvider(Provider provider){
        sessionFactory.getCurrentSession().save(provider);
        return provider.getId();
    }

    public int updateProvider(int id, Provider provider){
        Query query = sessionFactory.getCurrentSession().createQuery(
                "update Provider set name=:providerName, address=:providerAddress, phone=:providerPhone, email=:providerEmail, fax=:providerFax, contactPerson=:providerContact where id=:id"
        );
        query.setParameter("id", id);
        query.setParameter("providerName", provider.getName());
        query.setParameter("providerAddress", provider.getAddress());
        query.setParameter("providerPhone", provider.getPhone());
        query.setParameter("providerEmail", provider.getEmail());
        query.setParameter("providerFax", provider.getFax());
        query.setParameter("providerContact", provider.getContactPerson());
        return query.executeUpdate();
    }

    public int deleteProvider(int id){
        Provider existedProvider = (Provider) sessionFactory.getCurrentSession().get(Provider.class, id);
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Order.class);
        for (Object object: criteria.list()){
            Order order = (Order) object;
            if (order.getProviderID() != null){
                if (order.getProviderID().getId() == id){
                    order.setProviderID(null);
                    sessionFactory.getCurrentSession().update(order);
                }
            }
        }
        sessionFactory.getCurrentSession().delete(existedProvider);
        return existedProvider.getId();
    }
}
