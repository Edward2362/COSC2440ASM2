package com.example.cosc2440asm2.service;

import com.example.cosc2440asm2.model.Product;
import com.example.cosc2440asm2.model.Category;
import com.example.cosc2440asm2.model.SaleInvoice;
import com.example.cosc2440asm2.model.Staff;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryService {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Category> getAllCategories() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Category");
        return query.list();
    }

    public List<Category> getCategoryById(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Category where id=:id");
        query.setParameter("id", id);
        return query.list();
    }

    public int addCategory(Category category) {
        sessionFactory.getCurrentSession().save(category);
        return category.getId();
//        Query query = sessionFactory.getCurrentSession().createQuery(
//                "insert into Category(:categoryId, :categoryName)"
//        );
//        query.setParameter("categoryId", category.getId());
//        query.setParameter("categoryName", category.getName());
//        return query.executeUpdate();
    }

    public int updateCategory(int id, Category category) {

        System.out.println("in UPDATE SERVICE, " + category.toString());

        Query query = sessionFactory.getCurrentSession().createQuery(
                "update Category set name=:categoryName where id=:id"
        );
        query.setParameter("id", id);
        query.setParameter("categoryName", category.getName());
        return query.executeUpdate();
    }

    public int deleteCategory(int id) {
        Category existedCategory = (Category) sessionFactory.getCurrentSession().get(Category.class, id);
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Product.class);
        for (Object object: criteria.list()){
            Product product = (Product) object;
            if (product.getCategoryId() != null) {
                if (product.getCategoryId().getId() == id) {
                    product.setCategoryId(null);
                    sessionFactory.getCurrentSession().update(product);
                }
            }
        }
        sessionFactory.getCurrentSession().delete(existedCategory);
        return existedCategory.getId();
    }
}
