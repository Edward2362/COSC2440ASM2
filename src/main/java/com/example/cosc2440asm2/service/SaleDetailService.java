package com.example.cosc2440asm2.service;

import com.example.cosc2440asm2.model.SaleDetail;
import com.example.cosc2440asm2.model.SaleInvoice;
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

    public void setSessionFactory(SessionFactory sessionFactory){this.sessionFactory=sessionFactory;}

    public int addSaleDetail(SaleDetail saleDetail) {
        sessionFactory.getCurrentSession().save(saleDetail);
        return saleDetail.getId();
    }

    public int deleteSaleDetail(int saleDetailId) {
        SaleDetail existedSaleDetail = (SaleDetail) sessionFactory.getCurrentSession().get(SaleDetail.class, saleDetailId);
        existedSaleDetail.getSaleInvoiceID().getSaleDetailList().remove(existedSaleDetail);
        sessionFactory.getCurrentSession().delete(existedSaleDetail);
        return existedSaleDetail.getId();
    }

    public int updateSaleDetail(int saleDetailId, SaleDetail saleDetail) {
        SaleDetail existedSaleDetail = (SaleDetail) sessionFactory.getCurrentSession().get(SaleDetail.class, saleDetailId);
        existedSaleDetail.setPrice(saleDetail.getPrice());
        existedSaleDetail.setQuantity(saleDetail.getQuantity());
        existedSaleDetail.setProductID(saleDetail.getProductID());
        existedSaleDetail.setTotalValue(saleDetail.getTotalValue());
        sessionFactory.getCurrentSession().update(existedSaleDetail);
        return existedSaleDetail.getId();
    }

    public SaleDetail getSaleDetailId(int saleDetailId) {
        return (SaleDetail) sessionFactory.getCurrentSession().get(SaleDetail.class, saleDetailId);
    }

    public List<SaleDetail> getAllSaleDetails(){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SaleDetail.class);
        return criteria.list();
    }
}
