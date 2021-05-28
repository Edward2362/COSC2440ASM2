package com.example.cosc2440asm2.controller;

import com.example.cosc2440asm2.model.SaleDetail;
import com.example.cosc2440asm2.model.SaleInvoice;
import com.example.cosc2440asm2.service.SaleInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@RestController
public class SaleInvoiceController {
    @Autowired
    public SaleInvoiceService saleInvoiceService;

    @RequestMapping(value = "/saleInvoices", method = RequestMethod.GET)
    public List<SaleInvoice> getAllSaleInvoices() {
        return saleInvoiceService.getAllSalesInvoices();
    }

    @RequestMapping(value = "/saleInvoices", method = RequestMethod.POST)
    public int addSaleInvoice(@RequestBody SaleInvoice saleInvoice) {
        return saleInvoiceService.addSaleInvoice(saleInvoice);
    }

    @RequestMapping(value = "/saleInvoice/{id}", method = RequestMethod.PUT)
    public int updateSaleInvoice(@RequestBody SaleInvoice saleInvoice, @PathVariable(name = "id") int id) {
        return saleInvoiceService.updateSaleInvoice(id, saleInvoice);
    }

    @RequestMapping(value = "/saleInvoice/{id}", method = RequestMethod.DELETE)
    public int deleteSaleInvoice(@PathVariable(name = "id") int id) {
        return saleInvoiceService.deleteSaleInvoice(id);
    }

    @RequestMapping(value = "/saleInvoice/{id}", method = RequestMethod.GET)
    public SaleInvoice getSaleInvoiceById(@PathVariable(name = "id") int id) {
        return saleInvoiceService.getSaleInvoiceById(id);
    }

    @RequestMapping(value = "/saleInvoiceDate", method = RequestMethod.GET)
    public List<SaleInvoice> filterByDate(@RequestParam(name = "sDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date sDate, @RequestParam(name = "eDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date eDate){
        return saleInvoiceService.filterByDate(sDate, eDate);
    }

    @RequestMapping(value = "/saleInvoiceDateAndCustomer", method = RequestMethod.GET)
    public List<SaleInvoice> filterByDateAndByCustomer(@RequestParam(name = "sDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date sDate,
                                                       @RequestParam(name = "eDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date eDate,
                                                       @RequestParam(name = "customerId") int id){
        return saleInvoiceService.filterByDateAndByCustomer(sDate, eDate, id);
    }

    @RequestMapping(value = "/saleInvoiceDateAndStaff", method = RequestMethod.GET)
    public List<SaleInvoice> filterByDateAndByStaff(@RequestParam(name = "sDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date sDate,
                                                       @RequestParam(name = "eDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date eDate,
                                                       @RequestParam(name = "staffId") int id){
        return saleInvoiceService.filterByDateAndByStaff(sDate, eDate, id);
    }
}
