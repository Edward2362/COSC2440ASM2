package com.example.cosc2440asm2.controller;

import com.example.cosc2440asm2.model.SaleDetail;
import com.example.cosc2440asm2.model.SaleInvoice;
import com.example.cosc2440asm2.service.SaleInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
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

    @RequestMapping(value = "/saleInvoice", method = RequestMethod.PUT)
    public int updateSaleInvoice(@RequestBody SaleInvoice saleInvoice, @RequestParam(name = "id") int id) {
        return saleInvoiceService.updateSaleInvoice(id, saleInvoice);
    }

    @RequestMapping(value = "/saleInvoice", method = RequestMethod.DELETE)
    public int deleteSaleInvoice(@RequestParam(name = "id") int id) {
        return saleInvoiceService.deleteSaleInvoice(id);
    }

    @RequestMapping(value = "/saleInvoice", method = RequestMethod.GET)
    public SaleInvoice getSaleInvoiceById(@RequestParam(name = "id") int id) {
        return saleInvoiceService.getSaleInvoiceById(id);
    }
}
