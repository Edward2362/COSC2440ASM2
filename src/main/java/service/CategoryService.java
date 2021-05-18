package service;

import model.Category;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class CategoryService {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Category> getAllCategories(){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Category.class);
        return criteria.list();
    }
}
