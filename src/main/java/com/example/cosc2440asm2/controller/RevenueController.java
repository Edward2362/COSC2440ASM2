package com.example.cosc2440asm2.controller;

import com.example.cosc2440asm2.service.RevenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;

public class RevenueController {
    @Autowired
    public RevenueService revenueService;

    @RequestMapping(value = "/revenue/customer/{id}", method = RequestMethod.GET)
    public List getRevenueByCustomer(@PathVariable(name = "id") int id) {
        return revenueService.getRevenueByCustomerId(id);
    }

    @RequestMapping(value = "/revenue/staff/{id}", method = RequestMethod.GET)
    public List getRevenueByStaff(@PathVariable(name = "id") int id) {
        return revenueService.getRevenueByStaffId(id);
    }
}
