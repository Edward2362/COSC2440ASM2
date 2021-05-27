package com.example.cosc2440asm2.controller;

import com.example.cosc2440asm2.service.InventoryReceiveNoteService;
import com.example.cosc2440asm2.model.InventoryReceiveNote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InventoryReceiveNoteController {
    @Autowired
    public InventoryReceiveNoteService inventoryReceiveNoteService;

    @RequestMapping(value = "/receivenotes", method = RequestMethod.GET)
    public List<InventoryReceiveNote> getAllInventoryReceiveNotes(){
        return  inventoryReceiveNoteService.getAllReceiveNotes();
    }

    @RequestMapping(value = "/receivenote", method = RequestMethod.GET)
    public int getInventoryReceiveNoteById(@RequestParam(name = "id") int id){
        return inventoryReceiveNoteService.getInventoryReceiveNoteById(id);
    }

    @RequestMapping(value = "/receivenotes", method = RequestMethod.POST)
    public int addInventoryReceiveNote(@RequestBody InventoryReceiveNote inventoryReceiveNote){
        return inventoryReceiveNoteService.addInventoryReceiveNote(inventoryReceiveNote);
    }

    @RequestMapping(value = "/receivenote", method = RequestMethod.PUT)
    public int updateInventoryReceiveNote(@RequestBody InventoryReceiveNote inventoryReceiveNote,@RequestParam(name = "id") int id ){
        return inventoryReceiveNoteService.updateInventoryReceiveNote(id,inventoryReceiveNote);
    }

    @RequestMapping(value = "/receivenote", method = RequestMethod.DELETE)
    public int deleteInventoryReceiveNote(@RequestParam(name = "id") int id ){
        return inventoryReceiveNoteService.deleteInventoryReceiveNote(id);
    }

//    @RequestMapping("*")
//    public String fallbackMethod() {
//        return "No matching endpoint found.\n";
//    }
}
