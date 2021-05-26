package com.example.cosc2440asm2.service;

import com.example.cosc2440asm2.model.SaleDetail;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SaleDetailService {
    @Autowired
    private SessionFactory sessionFactory;

    public List<SaleDetail> getAllSaleDetails(){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SaleDetail.class);
        return criteria.list();
    }
}
