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

    public ReceivingDetail getReceivingDetailById(int receivingDetailId) {
        return (ReceivingDetail) sessionFactory.getCurrentSession().get(ReceivingDetail.class, receivingDetailId);
    }

//    public int addReceivingDetails(ReceivingDetail receivingDetail) {
//        sessionFactory.getCurrentSession().save(receivingDetail);
//        return receivingDetail.getId();
//    }

    public int  deleteReceivingDetails(int receivingDetailId){
        ReceivingDetail existedReceivingDetail = (ReceivingDetail) sessionFactory.getCurrentSession().get(ReceivingDetail.class, receivingDetailId );
        existedReceivingDetail.getInventoryReceiveNoteID().getReceivingDetailList().remove(existedReceivingDetail);
        sessionFactory.getCurrentSession().delete(existedReceivingDetail);
        return existedReceivingDetail.getId();
    }

    public int updateReceivingDetail(int receivingDetailId, ReceivingDetail receivingDetail){
        ReceivingDetail existedReceivingDetail = (ReceivingDetail) sessionFactory.getCurrentSession().get(ReceivingDetail.class, receivingDetailId);
        existedReceivingDetail.setProductID(receivingDetail.getProductID());
        existedReceivingDetail.setQuantity(receivingDetail.getQuantity());
        sessionFactory.getCurrentSession().update(existedReceivingDetail);
        return existedReceivingDetail.getId();
    }
}
