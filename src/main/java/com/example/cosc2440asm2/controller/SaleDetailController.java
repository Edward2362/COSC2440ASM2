package com.example.cosc2440asm2.controller;

import com.example.cosc2440asm2.model.SaleDetail;
import com.example.cosc2440asm2.service.SaleDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SaleDetailController {
    @Autowired
    public SaleDetailService saleDetailService;

    @RequestMapping(value = "/saleDetails", method = RequestMethod.GET)
    public List<SaleDetail> getAllSaleDetails() {
        return saleDetailService.getAllSaleDetails();
    }

//    @RequestMapping(value = "/saleDetails", method = RequestMethod.POST)
//    public int addSaleDetail(@RequestBody SaleDetail saleDetail) {
//        return saleDetailService.addSaleDetail(saleDetail);
//    }

    @RequestMapping(value = "/saleDetail", method = RequestMethod.PUT)
    public int updateSaleDetail(@RequestBody SaleDetail saleDetail, @RequestParam(name = "id") int id) {
        return saleDetailService.updateSaleDetail(id, saleDetail);
    }

    @RequestMapping(value = "/saleDetail", method = RequestMethod.DELETE)
    public int deleteSaleDetail(@RequestParam(name = "id") int id) {
        return saleDetailService.deleteSaleDetail(id);
    }

    @RequestMapping(value = "/saleDetail", method = RequestMethod.GET)
    public SaleDetail getSaleDetailById(@RequestParam(name = "id") int id) {
        return saleDetailService.getSaleDetailId(id);
    }
}
