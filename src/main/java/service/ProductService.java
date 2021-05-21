package service;

import model.Category;
import model.Product;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ProductService {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Product> getAllProducts(){
        return sessionFactory.getCurrentSession().createQuery("from Product").list();
    }

    public Product getProduct(int id){
        List<Product> allProductsList = getAllProducts();
        for (Product product:allProductsList){
            if (product.getId() == id){
                return product;
            }
        }
        return null;
    }

    public int addProduct(Product product){
        sessionFactory.getCurrentSession().save(product);
        return product.getId();
    }

}
