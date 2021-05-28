package com.example.cosc2440asm2.controller;

import com.example.cosc2440asm2.model.DeliveryDetail;
import com.example.cosc2440asm2.model.ReceivingDetail;
import com.example.cosc2440asm2.service.DeliveryDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeliveryDetailController {
    @Autowired
    public DeliveryDetailService deliveryDetailService;

    @RequestMapping(value = "/deliveryDetails", method = RequestMethod.GET)
    public List<DeliveryDetail> getAllDeliveryDetails(){
        return  deliveryDetailService.getAllDeliveryDetails();
    }

    @RequestMapping(value = "/deliveryDetail/{id}", method = RequestMethod.GET)
    public DeliveryDetail getDeliveryDetailById(@PathVariable(name = "id") int id){
        return deliveryDetailService.getDeliveryDetailById(id);
    }

//    @RequestMapping(value = "/receivedetails", method = RequestMethod.POST)
//    public int addReceivingDetail(@RequestBody ReceivingDetail receivingDetail){
//        return receivingDetailService.addReceivingDetails(receivingDetail);
//    }

    @RequestMapping(value = "/deliveryDetail/{id}", method = RequestMethod.PUT)
    public int updateDeliveryDetail(@RequestBody DeliveryDetail deliveryDetail, @PathVariable(name = "id") int id ){
        return deliveryDetailService.updateDeliveryDetail(id, deliveryDetail);
    }

    @RequestMapping(value = "/deliveryDetail/{id}", method = RequestMethod.DELETE)
    public int deleteDeliveryDetail(@PathVariable(name = "id") int id ){
        return deliveryDetailService.deleteDeliveryDetails(id);
    }
}
