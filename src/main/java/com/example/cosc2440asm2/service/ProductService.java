package com.example.cosc2440asm2.service;

import com.example.cosc2440asm2.model.Product;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;

@Service
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
        query.setParameter("id", id);
        return query.list();
    }

    public int addProduct(Product product) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "insert into Product(:productName, :productModel, :productBrand, :productCompany, :productDescription, :productCategory)"
        );
        query.setParameter("productName", product.getName());
        query.setParameter("productModel", product.getModel());
        query.setParameter("productBrand", product.getBrand());
        query.setParameter("productCompany", product.getCompany());
        query.setParameter("productDescription", product.getDescription());
        query.setParameter("productCategory", product.getCategoryId());
        return query.executeUpdate();
    }

    public int updateProduct(int id, Product product) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "update Product set name=:productName, model=:productModel, brand=:productBrand, company=:productCompany, description=:productDescription, category=:productCategory where id=:id"
        );
        query.setParameter("id", id);
        query.setParameter("productName", product.getName());
        query.setParameter("productModel", product.getModel());
        query.setParameter("productBrand", product.getBrand());
        query.setParameter("productCompany", product.getCompany());
        query.setParameter("productDescription", product.getDescription());
        query.setParameter("productCategory", product.getCategoryId());
        return query.executeUpdate();
    }

    public int deleteProduct(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "delete Product p where p.id=:id"
        );
        query.setParameter("id", id);
        return query.executeUpdate();
    }
}
