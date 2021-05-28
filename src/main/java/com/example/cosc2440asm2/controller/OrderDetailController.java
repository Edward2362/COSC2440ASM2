package com.example.cosc2440asm2.controller;

import com.example.cosc2440asm2.model.OrderDetail;
import com.example.cosc2440asm2.model.SaleDetail;
import com.example.cosc2440asm2.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderDetailController {
    @Autowired
    public OrderDetailService orderDetailService;

    @RequestMapping(value = "/orderDetails", method = RequestMethod.GET)
    public List<OrderDetail> getAllOrderDetails() {
        return orderDetailService.getAllOrderDetails();
    }

//    @RequestMapping(value = "/saleDetails", method = RequestMethod.POST)
//    public int addSaleDetail(@RequestBody SaleDetail saleDetail) {
//        return saleDetailService.addSaleDetail(saleDetail);
//    }

    @RequestMapping(value = "/orderDetail/{id}", method = RequestMethod.PUT)
    public int updateOrderDetail(@RequestBody OrderDetail orderDetail, @PathVariable(name = "id") int id) {
        return orderDetailService.updateOrderDetail(id, orderDetail);
    }

    @RequestMapping(value = "/orderDetail/{id}", method = RequestMethod.DELETE)
    public int deleteOrderDetail(@PathVariable(name = "id") int id) {
        return orderDetailService.deleteOrderDetail(id);
    }

    @RequestMapping(value = "/orderDetail/{id}", method = RequestMethod.GET)
    public List<OrderDetail> getOrderDetailById(@PathVariable(name = "id") int id) {
        return orderDetailService.getOrderDetailById(id);
    }
}
