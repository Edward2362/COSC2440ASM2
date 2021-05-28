package com.example.cosc2440asm2.controller;

import com.example.cosc2440asm2.model.InventoryDeliveryNote;
import com.example.cosc2440asm2.service.InventoryDeliveryNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

public class InventoryDeliveryNoteController {
    @Autowired
    public InventoryDeliveryNoteService inventoryDeliveryNoteService;

    @RequestMapping(value = "/deliveryNotes", method = RequestMethod.GET)
    public List<InventoryDeliveryNote> getAllInventoryDeliveryNotes(){
        return  inventoryDeliveryNoteService.getAllDeliveryNote();
    }

    @RequestMapping(value = "/deliveryNote", method = RequestMethod.GET)
    public List<InventoryDeliveryNote> getInventoryDeliveryNoteById(@RequestParam(name = "id") int id){
        return inventoryDeliveryNoteService.getInventoryDeliveryNoteById(id);
    }

    @RequestMapping(value = "/deliveryNotes", method = RequestMethod.POST)
    public int addInventoryReceiveNote(@RequestBody InventoryDeliveryNote inventoryDeliveryNote){
        return inventoryDeliveryNoteService.addInventoryDeliveryNote(inventoryDeliveryNote);
    }

    @RequestMapping(value = "/deliveryNote/{id}", method = RequestMethod.PUT)
    public int updateInventoryReceiveNote(@RequestBody InventoryDeliveryNote inventoryDeliveryNote,@PathVariable(name = "id") int id ){
        return inventoryDeliveryNoteService.updateInventoryDeliveryNote(id,inventoryDeliveryNote);
    }

    @RequestMapping(value = "/deliveryNote/{id}", method = RequestMethod.DELETE)
    public int deleteInventoryReceiveNote(@PathVariable(name = "id") int id ){
        return inventoryDeliveryNoteService.deleteInventoryDeliveryNote(id);
    }

    @RequestMapping(value = "/deliveryNoteDate/{sDate}/{eDate}", method = RequestMethod.GET)
    public List<InventoryDeliveryNote> filterByDate(@PathVariable(name = "sDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date sDate, @PathVariable(name = "eDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date eDate){
        return inventoryDeliveryNoteService.filterByDate(sDate, eDate);
    }
}
