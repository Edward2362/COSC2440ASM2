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

    @RequestMapping(value = "/staffs/{id}", method = RequestMethod.GET)
    public List<Staff> getStaffById(@PathVariable(name = "id") int id) {
        return staffService.getStaffById(id);
    }

    @RequestMapping(value = "/staffs", method = RequestMethod.POST)
    public int addStaff(@RequestBody Staff staff) {
        return staffService.addStaff(staff);
    }


    @RequestMapping(value = "/staffs/{id}", method = RequestMethod.PUT)
    public int updateStaff(@RequestBody Staff staff, @PathVariable(name = "id") int id) {
        return staffService.updateStaff(id, staff);
    }

    @RequestMapping(value = "/staffs/{id}", method = RequestMethod.DELETE)
    public int deleteStaff(@PathVariable(name = "id") int id) {
        return staffService.deleteStaff(id);
    }

}
