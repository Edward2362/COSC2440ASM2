package com.example.cosc2440asm2.service;


import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Date;
import java.util.List;

public class InventoryService {
    @Autowired
    private SessionFactory sessionFactory;

    @RequestMapping(value = "/inventory", method= RequestMethod.GET)
    public void getInventoryByDate(String startDate, String endDate){
        SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(
                "select p.name d.quantity r.quantity, (r.quantity-d.quantity) as balance\n" +
                        "\tfrom product p \n" +
                        "\tinner join deliverydetail d on p.id = d.product_id \n" +
                        "\tinner join receivingdetail r on d.id = r.product_id \n" +
                        "\tinner join inventorydeliverynote idn on idn.id = d.delivery_note_id\n" +
                        "\tinner join inventoryrecevenote irn on irn.id = r.receiving_note_id\n" +
                        "\twhere idn.date >= :startDate and idn.date < :endDate and irn.date >= :startDate and irn.date < :endDate\n"
        );
        query.setString("startDate", "%"+startDate+"%");
        query.setString("endDate", "%"+endDate+"%");
        query.list();
    }
}
