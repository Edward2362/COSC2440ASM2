package com.example.cosc2440asm2.controller;

import com.example.cosc2440asm2.model.Customer;
import com.example.cosc2440asm2.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    public CustomerService customerService;

    @RequestMapping(value = "/customers", method= RequestMethod.GET)
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }


    @RequestMapping(value = "/customers/{id}", method= RequestMethod.GET)
    public List<Customer> getCustomerById(@PathVariable(name="id") int id){
        return customerService.getCustomerById(id);
    }

    @RequestMapping(value = "/customers/{name}", method= RequestMethod.GET)
    public List<Customer> getCustomerByName(@PathVariable(name="name") String name){
        return customerService.getCustomerByName(name);
    }

    @RequestMapping(value = "/customers/{phone}", method= RequestMethod.GET)
    public List<Customer> getCustomerByPhone(@PathVariable(name="phone") String phone){
        return customerService.getCustomerByPhone(phone);
    }

    @RequestMapping(value = "/customers/{email}", method= RequestMethod.GET)
    public List<Customer> getCustomerByEmail(@PathVariable(name="email") String email){
        return customerService.getCustomerByEmail(email);
    }

    @RequestMapping(value="/customers", method =RequestMethod.POST)
    public int addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    @RequestMapping(value="/customers/{id}", method=RequestMethod.PUT)
    public int updateCustomer(@PathVariable(name="id") int id, @RequestBody Customer customer){
        return customerService.updateCustomer(id, customer);
    }

    @RequestMapping(value="/customers/{id}", method=RequestMethod.DELETE)
    public int deleteCustomer(@PathVariable(name="id") int id){
        return customerService.deleteCustomer(id);
    }

    @RequestMapping("*")
    public String fallbackMethod() {
        return "No matching endpoint found.\n";
    }
}
