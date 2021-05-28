package com.example.cosc2440asm2.controller;

import com.example.cosc2440asm2.service.RevenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;

public class RevenueController {
    @Autowired
    public RevenueService revenueService;

    @RequestMapping(value = "/revenue/customer/", method = RequestMethod.GET)
    public List getRevenueByCustomer(@RequestParam(name = "id") int id) {
        return revenueService.getRevenueByCustomerId(id);
    }

    @RequestMapping(value = "/revenue/staff/", method = RequestMethod.GET)
    public List getRevenueByStaff(@RequestParam(name = "id") int id) {
        return revenueService.getRevenueByStaffId(id);
    }
}
