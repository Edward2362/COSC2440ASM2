package com.example.cosc2440asm2.controller;

import com.example.cosc2440asm2.model.SaleInvoice;
import com.example.cosc2440asm2.service.InventoryReceiveNoteService;
import com.example.cosc2440asm2.model.InventoryReceiveNote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class InventoryReceiveNoteController {
    @Autowired
    public InventoryReceiveNoteService inventoryReceiveNoteService;

    @RequestMapping(value = "/receiveNotes", method = RequestMethod.GET)
    public List<InventoryReceiveNote> getAllInventoryReceiveNotes(){
        return  inventoryReceiveNoteService.getAllReceiveNotes();
    }

    @RequestMapping(value = "/receiveNote", method = RequestMethod.GET)
    public InventoryReceiveNote getInventoryReceiveNoteById(@RequestParam(name = "id") int id){
        return inventoryReceiveNoteService.getInventoryReceiveNoteById(id);
    }

    @RequestMapping(value = "/receiveNotes", method = RequestMethod.POST)
    public int addInventoryReceiveNote(@RequestBody InventoryReceiveNote inventoryReceiveNote){
        return inventoryReceiveNoteService.addInventoryReceiveNote(inventoryReceiveNote);
    }

    @RequestMapping(value = "/receiveNote", method = RequestMethod.PUT)
    public int updateInventoryReceiveNote(@RequestBody InventoryReceiveNote inventoryReceiveNote,@RequestParam(name = "id") int id ){
        return inventoryReceiveNoteService.updateInventoryReceiveNote(id,inventoryReceiveNote);
    }

    @RequestMapping(value = "/receiveNote", method = RequestMethod.DELETE)
    public int deleteInventoryReceiveNote(@RequestParam(name = "id") int id ){
        return inventoryReceiveNoteService.deleteInventoryReceiveNote(id);
    }

    @RequestMapping(value = "/receiveNoteDate", method = RequestMethod.GET)
    public List<InventoryReceiveNote> filterByDate(@RequestParam(name = "sDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date sDate, @RequestParam(name = "eDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date eDate){
        return inventoryReceiveNoteService.filterByDate(sDate, eDate);
    }

//    @RequestMapping("*")
//    public String fallbackMethod() {
//        return "No matching endpoint found.\n";
//    }
}
