package com.example.cosc2440asm2.controller;

import com.example.cosc2440asm2.model.Order;
import com.example.cosc2440asm2.model.SaleInvoice;
import com.example.cosc2440asm2.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    public OrderService orderService;

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @RequestMapping(value = "/orders", method = RequestMethod.POST)
    public int addOrder(@RequestBody Order order) {
        return orderService.addOrder(order);
    }

    @RequestMapping(value = "/order/{id}", method = RequestMethod.PUT)
    public int updateOrder(@RequestBody Order order, @PathVariable(name = "id") int id) {
        return orderService.updateOrder(id, order);
    }

    @RequestMapping(value = "/order/{id}", method = RequestMethod.DELETE)
    public int deleteOrder(@PathVariable(name = "id") int id) {
        return orderService.deleteOrder(id);
    }

    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    public List<Order> getOrderById(@PathVariable(name = "id") int id) {
        return orderService.getOrderById(id);
    }
}
