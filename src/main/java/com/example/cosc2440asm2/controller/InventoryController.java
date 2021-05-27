package com.example.cosc2440asm2.controller;


import com.example.cosc2440asm2.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class InventoryController {
    @Autowired
    public InventoryService inventoryService;

    @RequestMapping(value="/inventory", method=RequestMethod.GET)
    public void getInventoryByDate(@RequestBody String startDate, @RequestBody String endDate){
        inventoryService.getInventoryByDate(startDate, endDate);
    }
}
