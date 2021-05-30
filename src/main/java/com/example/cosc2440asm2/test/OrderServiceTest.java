package com.example.cosc2440asm2.test;

import com.example.cosc2440asm2.model.Category;
import com.example.cosc2440asm2.model.Order;
import com.example.cosc2440asm2.model.OrderDetail;
import com.example.cosc2440asm2.service.OrderDetailService;
import com.example.cosc2440asm2.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import javax.persistence.ManyToOne;
import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class OrderServiceTest {
    @Autowired
    public OrderService orderService;

    @DisplayName("Test Order create")
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testAddOrder(){
        OrderDetail newOrderDetail = new OrderDetail();
        List<OrderDetail> testList = new ArrayList<>();
        testList.add(newOrderDetail);

        int newOrderId = orderService.addOrder(new Order(testList));
        assertEquals(orderService.getAllOrders().get(0).getId(), newOrderId);
    }

    @DisplayName("Test Order get all")
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testGetAllOrder(){
        OrderDetail newOrderDetail = new OrderDetail();
        List<OrderDetail> testList = new ArrayList<>();
        testList.add(newOrderDetail);

        orderService.addOrder(new Order(testList));
        orderService.addOrder(new Order(testList));

        assertEquals(orderService.getAllOrders().size(),2);
    }

    @DisplayName("Test Order get by id")
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testGetOrderByI(){
        OrderDetail newOrderDetail = new OrderDetail();
        List<OrderDetail> testList = new ArrayList<>();
        testList.add(newOrderDetail);

        Order testOrder1 = new Order(testList);
        Order testOrder2 = new Order(testList);
        int orderDetailId1 = orderService.addOrder(testOrder1);
        int orderDetailId2 = orderService.addOrder(testOrder2);

        assertEquals(orderService.getOrderById(orderDetailId1).get(0).getId(),orderDetailId1);

    }

    @DisplayName("Test Order update")
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testUpdateOrder() {
        OrderDetail newOrderDetail1 = new OrderDetail();
        List<OrderDetail> testList = new ArrayList<>();
        testList.add(newOrderDetail1);

        OrderDetail newOrderDetail2 = new OrderDetail();
        List<OrderDetail> newTestList = new ArrayList<>();
        newTestList.add(newOrderDetail2);

        Order newOrder = new Order(testList);
        Order updateOrder = new Order(newTestList);

        int newOrderId = orderService.addOrder(newOrder);

        System.out.println("newOrderId" + newOrderId);

        orderService.updateOrder(newOrderId, updateOrder);
    }
    @DisplayName("Test Order delete")
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testDeleteOrder(){
        OrderDetail newOrderDetail = new OrderDetail();
        List<OrderDetail> testList = new ArrayList<>();
        testList.add(newOrderDetail);

        int newOrderId = orderService.addOrder(new Order(testList));
        orderService.deleteOrder(newOrderId);
        assertEquals(orderService.getAllOrders().size(),0);
    }
}
