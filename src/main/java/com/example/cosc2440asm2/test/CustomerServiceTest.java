package com.example.cosc2440asm2.test;


import com.example.cosc2440asm2.model.Category;
import com.example.cosc2440asm2.model.Customer;
import com.example.cosc2440asm2.service.CustomerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@Transactional
public class CustomerServiceTest {
    @Autowired
    public CustomerService customerService;

    @DisplayName("Test Customer create")
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testAddCustomer() {
        Customer customer = new Customer("new Customer 1");
        int newCustomerId = customerService.addCustomer(customer);
        assertEquals(customerService.getCustomerById(newCustomerId).get(0).getName(), customer.getName());
    }

    @DisplayName("Test Customer getAll")
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testGetAllCustomer(){
        customerService.addCustomer(new Customer("customer 1"));
        customerService.addCustomer(new Customer("customer 2"));
        assertEquals(customerService.getAllCustomers().size(), 2);
    }

    @DisplayName("Test Customer get by id")
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testGetCustomerByid(){
        Customer testCustomer1 = new Customer("customer 1");
        Customer testCustomer2 = new Customer("customer 2");
        int customerId1 = customerService.addCustomer(testCustomer1);
        int customerId2 = customerService.addCustomer(testCustomer2);

        assertEquals(customerService.getCustomerById(customerId1).get(0).getName(), "customer 1");
    }

    @DisplayName("Test Customer update")
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testUpdateCustomer(){
        Customer testCustomer1 = new Customer("customer 1");
        Customer testCustomer2 = new Customer("customer 2");
        int customerId1 = customerService.addCustomer(testCustomer1);
//        int customerId2 = customerService.addCustomer(testCustomer2);

        customerService.updateCustomer(customerId1, testCustomer2);

        assertEquals(customerService.getCustomerById(customerId1).get(0).getName(), testCustomer2.getName());
    }

    @DisplayName("Test Customer delete")
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testDeleteCustomer(){
        Customer testCustomer1 = new Customer("customer 1");
        Customer testCustomer2 = new Customer("customer 2");
        int customerId1 = customerService.addCustomer(testCustomer1);
        int customerId2 = customerService.addCustomer(testCustomer2);

        customerService.deleteCustomer(customerId1);
        assertEquals(customerService.getAllCustomers().size(), 1);
    }
}
