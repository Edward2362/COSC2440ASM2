package com.example.cosc2440asm2.service;


import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.loader.custom.sql.SQLQueryParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLData;
import java.util.List;

@Service
@Transactional
public class RevenueService {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List getRevenueByCustomerId(int id) {
        SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(
                "select c.name, sum(sale.price * sale.quantity) as revenue\n" +
                        "\tfrom customer c \n" +
                        "\tinner join saleinvoice si on si.customer_id = c.id\n" +
                        "\tinner join saledetail sd on sd.sale_invoice_id = si.id\n" +
                        "\twhere c.id = :id"
        );
        query.setString("id", "%" + String.valueOf(id) + "%");

        return query.list();
    }

    public List getRevenueByStaffId(int id) {
        SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(
                "select s.name, sum(sale.price * sale.quantity) as revenue\n" +
                        "\tfrom staff s\n" +
                        "\tinner join saleinvoice si on si.staffid = s.id\n" +
                        "\tinner join saledetail sd on sd.sale_invoice_id = si.id\n" +
                        "\twhere s.id = :id"
        );
        query.setString("id", "%" + String.valueOf(id) + "%");
        return query.list();
    }
}
