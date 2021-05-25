package controller;

import model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.OrderService;

import java.util.List;

public class OrderController {
    @Autowired
    public OrderService orderService;

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public List<Order> getAllOrder() {
        return orderService.getAllOrders();
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public List<Order> getOrderById(@RequestParam(name = "id") int id) {
        return orderService.getOrderById(id);
    }

    @RequestMapping(value = "/orders", method = RequestMethod.POST)
    public int addOrder(@RequestBody Order order) {
        return orderService.addOrder(order);
    }

    @RequestMapping(value = "/orders", method = RequestMethod.PUT)
    public int updateOrder(@RequestParam(name = "id") int id, @RequestBody Order order) {
        return orderService.updateOrder(id, order);
    }

    @RequestMapping(value = "/orders", method = RequestMethod.DELETE)
    public int deleteOrder(@RequestParam(name="id") int id){
        return orderService.deleteOrder(id);
    }
}
