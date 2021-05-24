package service;

import model.Provider;
import model.Staff;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class ProviderService {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){this.sessionFactory=sessionFactory;}

    public List<Staff> getAllProviders(){
        Query query = sessionFactory.getCurrentSession().createQuery(
                "from Provider"
        );
        return query.list();
    }

    public List<Staff> getProviderById(int id){
        Query query = sessionFactory.getCurrentSession().createQuery("from Provider where id=:id");
        query.setString("id", "%"+id+"%");
        return query.list();
    }

    public int addProvider(Provider provider){
        Query query = sessionFactory.getCurrentSession().createQuery(
                "insert into Provider(:providerName, :providerAddress, :providerPhone, :providerEmail, :providerFax, :providerContact)"
        );
        query.setString("providerName", "%" + provider.getName() + "%");
        query.setString("providerAddress", "%" + provider.getAddress() + "%");
        query.setString("providerPhone", "%" + provider.getPhone() + "%");
        query.setString("providerEmail", "%" + provider.getEmail() + "%");
        query.setString("providerFax", "%" + provider.getFax() + "%");
        query.setString("providerContact", "%" + provider.getContactPerson() + "%");
        return query.executeUpdate();
    }

    public int updateProvider(Provider provider){
        Query query = sessionFactory.getCurrentSession().createQuery(
                "update Provider set name=:providerName, address=:providerAddress, phone=:providerPhone, email=:providerEmail, fax=:providerFax, contactPerson=:providerContact"
        );
        query.setString("providerName", "%" + provider.getName() + "%");
        query.setString("providerAddress", "%" + provider.getAddress() + "%");
        query.setString("providerPhone", "%" + provider.getPhone() + "%");
        query.setString("providerEmail", "%" + provider.getEmail() + "%");
        query.setString("providerFax", "%" + provider.getFax() + "%");
        query.setString("providerContact", "%" + provider.getContactPerson() + "%");
        return query.executeUpdate();
    }

    public int deleteProvider(int id){
        Query query = sessionFactory.getCurrentSession().createQuery(
                "delete Provider c where c.id=:id"
        );
        query.setString("id", "%"+id+"%");
        return query.executeUpdate();
    }
}
