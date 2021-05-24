package service;

import model.Category;
import model.Product;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class CategoryService {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Category> getAllCategories() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Category");
        return query.list();
    }

    public List<Product> getCategoryById(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Category c where c.id like :id");
        query.setString("id", "%" + id + "%");
        return query.list();
    }

    public int addCategory(Category category) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "insert into Category(:categoryId, :categoryName)"
        );
        for (Product product : category.getProducts()) {
            product.setCategory(category);
        }
        query.setString("categoryId", "%" + category.getId() + "%");
        query.setString("categoryName", "%" + category.getName() + "%");
        return query.executeUpdate();
    }

    public int updateCategory(Category category) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "insert into Category(:categoryId, :categoryName)"
        );
        query.setString("categoryId", "%" + category.getId() + "%");
        query.setString("categoryName", "%" + category.getName() + "%");
        return query.executeUpdate();
    }

    public int deleteCategory(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "delete Category where id=:id"
        );
        query.setString("id", "%" + id + "%");
        return query.executeUpdate();
    }
}
