package service;

import model.InventoryDeliveryNote;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class InventoryDeliveryNoteService {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){this.sessionFactory=sessionFactory;}

    public List<InventoryDeliveryNote> getAllDeliveryNotes(){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(InventoryDeliveryNote.class);
        return criteria.list();
    }
}
