package com.example.cosc2440asm2.service;

import com.example.cosc2440asm2.model.ReceivingDetail;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ReceivingDetailService {
    @Autowired
    private SessionFactory sessionFactory;

    public List<ReceivingDetail> getAllReceivingDetails(){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ReceivingDetail.class);
        return criteria.list();
    }
}
