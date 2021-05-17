package service;

import model.InventoryReceiveNote;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class InventoryReceiveNoteService {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){this.sessionFactory= sessionFactory;}

    public List<InventoryReceiveNote> getAllReceiveNotes(){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(InventoryReceiveNote.class);
        return criteria.list();
    }

}
