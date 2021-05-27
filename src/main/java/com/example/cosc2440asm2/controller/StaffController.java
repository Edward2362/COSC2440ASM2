package com.example.cosc2440asm2.controller;

import com.example.cosc2440asm2.model.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.cosc2440asm2.service.StaffService;

import java.util.List;

@RestController
public class StaffController {
    @Autowired
    public StaffService staffService;

    @RequestMapping(value = "/staffs", method = RequestMethod.GET)
    public List<Staff> getAllStaff() {
        return staffService.getAllStaffs();
    }

    @RequestMapping(value = "/staff", method = RequestMethod.GET)
    public List<Staff> getStaffById(@RequestParam(name = "id") int id) {
        return staffService.getStaffById(id);
    }

    @RequestMapping(value = "/staffs", method = RequestMethod.POST)
    public int addStaff(@RequestBody Staff staff) {
        return staffService.addStaff(staff);
    }

    @RequestMapping(value = "/staff", method = RequestMethod.PUT)
    public int updateStaff(@RequestBody Staff staff, @RequestParam(name = "id") int id) {
        return staffService.updateStaff(id, staff);
    }

    @RequestMapping(value = "/staff", method = RequestMethod.DELETE)
    public int deleteStaff(@RequestParam(name = "id") int id) {
        return staffService.deleteStaff(id);
    }

    @RequestMapping("*")
    public String fallbackMethod() {
        return "No matching endpoint found.\n";
    }
}
