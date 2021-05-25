package controller;

import model.Customer;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.CustomerService;
import service.ProductService;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    public CustomerService customerService;

    @RequestMapping(value = "/customers", method= RequestMethod.GET)
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @RequestMapping(value = "/customers", method= RequestMethod.GET)
    public List<Customer> getCustomerById(@RequestParam(name="id") int id){
        return customerService.getCustomerById(id);
    }

    @RequestMapping(value = "/customers", method= RequestMethod.GET)
    public List<Customer> getCustomerByName(@RequestParam(name="name") String name){
        return customerService.getCustomerByName(name);
    }

    @RequestMapping(value = "/customers", method= RequestMethod.GET)
    public List<Customer> getCustomerByPhone(@RequestParam(name="phone") String phone){
        return customerService.getCustomerByPhone(phone);
    }

    @RequestMapping(value = "/customers", method= RequestMethod.GET)
    public List<Customer> getCustomerByEmail(@RequestParam(name="email") String email){
        return customerService.getCustomerByEmail(email);
    }

    @RequestMapping(value="/customers", method =RequestMethod.POST)
    public int addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    @RequestMapping(value="/customers", method=RequestMethod.PUT)
    public int updateCustomer(@RequestParam(name="id") int id, @RequestBody Customer customer){
        return customerService.updateCustomer(id, customer);
    }

    @RequestMapping(value="/customers", method=RequestMethod.DELETE)
    public int deleteCustomer(@RequestParam(name="id") int id){
        return customerService.deleteCustomer(id);
    }

    @RequestMapping("*")
    public String fallbackMethod() {
        return "No matching endpoint found.\n";
    }
}
