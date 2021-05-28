package com.example.cosc2440asm2.controller;

import com.example.cosc2440asm2.model.ReceivingDetail;
import com.example.cosc2440asm2.service.ReceivingDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReceivingDetailController {
    @Autowired
    public ReceivingDetailService receivingDetailService;

    @RequestMapping(value = "/receiveDetails", method = RequestMethod.GET)
    public List<ReceivingDetail> getAllRecevingDetails(){
        return  receivingDetailService.getAllReceivingDetails();
    }

    @RequestMapping(value = "/receiveDetail/{id}", method = RequestMethod.GET)
    public ReceivingDetail getReceivingDetailById(@PathVariable(name = "id") int id){
        return receivingDetailService.getReceivingDetailById(id);
    }

//    @RequestMapping(value = "/receivedetails", method = RequestMethod.POST)
//    public int addReceivingDetail(@RequestBody ReceivingDetail receivingDetail){
//        return receivingDetailService.addReceivingDetails(receivingDetail);
//    }

    @RequestMapping(value = "/receiveDetail/{id}", method = RequestMethod.PUT)
    public int updateReceivingDetail(@RequestBody ReceivingDetail receivingDetail, @PathVariable(name = "id") int id ){
        return receivingDetailService.updateReceivingDetail(id, receivingDetail);
    }

    @RequestMapping(value = "/receiveDetail/{id}", method = RequestMethod.DELETE)
    public int deleteReceivingDetail(@PathVariable(name = "id") int id ){
        return receivingDetailService.deleteReceivingDetails(id);
    }
//
//    @RequestMapping("*")
//    public String fallbackMethod() {
//        return "No matching endpoint found.\n";
//    }
}
