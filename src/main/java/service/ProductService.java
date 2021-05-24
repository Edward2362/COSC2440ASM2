package service;

import model.Product;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;


import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class ProductService {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Product> getAllProducts() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Product");
        return query.list();
    }

    public List<Product> getProductById(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Product p where p.id like :id");
        query.setString("id", "%" + id + "%");
        return query.list();
    }

    public int addProduct(Product product) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "insert into Product(:productName, :productModel, :productBrand, :productCompany, :productDescription, :productCategory)"
        );
        query.setString("productName", "%" + product.getName() + "%");
        query.setString("productModel", "%" + product.getModel() + "%");
        query.setString("productBrand", "%" + product.getBrand() + "%");
        query.setString("productCompany", "%" + product.getCompany() + "%");
        query.setString("productDescription", "%" + product.getDescription() + "%");
        query.setString("productCategory", "%" + product.getCategoryId() + "%");
        return query.executeUpdate();
    }

    public int updateProduct(Product product) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "update Product set name=:productName, model=:productModel, brand=:productBrand, company=:productCompany, description=:productDescription, category=:productCategory"
        );
        query.setString("productName", "%" + product.getName() + "%");
        query.setString("productModel", "%" + product.getModel() + "%");
        query.setString("productBrand", "%" + product.getBrand() + "%");
        query.setString("productCompany", "%" + product.getCompany() + "%");
        query.setString("productDescription", "%" + product.getDescription() + "%");
        query.setString("productCategory", "%" + product.getCategoryId() + "%");
        return query.executeUpdate();
    }

    public int deleteProduct(int id){
        Query query = sessionFactory.getCurrentSession().createQuery(
                "delete Product p where p.id=:id"
        );
        query.setString("id", "%"+id+"%");
        return query.executeUpdate();
    }
}
