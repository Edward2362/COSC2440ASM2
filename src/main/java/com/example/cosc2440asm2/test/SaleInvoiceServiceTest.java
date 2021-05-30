package com.example.cosc2440asm2.test;

import com.example.cosc2440asm2.model.*;
import com.example.cosc2440asm2.service.CustomerService;
import com.example.cosc2440asm2.service.SaleDetailService;
import com.example.cosc2440asm2.service.SaleInvoiceService;
import com.example.cosc2440asm2.service.StaffService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class SaleInvoiceServiceTest {
    @Autowired
    public SaleInvoiceService saleInvoiceService;

    @Autowired
    public CustomerService customerService;

    @Autowired
    public StaffService staffService;

    @DisplayName("Test SaleInvoice create")
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testAddSaleInvoice() {
        SaleDetail newSaleDetail = new SaleDetail();
        List<SaleDetail> testList = new ArrayList<>();
        testList.add(newSaleDetail);

        int newSaleInvoiceId = saleInvoiceService.addSaleInvoice(new SaleInvoice(testList));

        assertEquals(saleInvoiceService.getAllSalesInvoices().get(0).getId(), newSaleInvoiceId);
    }

    @DisplayName("Test SaleInvoice get all")
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testGetAllSaleInvoice() {
        SaleDetail newSaleDetail = new SaleDetail();
        List<SaleDetail> testList = new ArrayList<>();
        testList.add(newSaleDetail);

        saleInvoiceService.addSaleInvoice(new SaleInvoice(testList));
        saleInvoiceService.addSaleInvoice(new SaleInvoice(testList));

        assertEquals(saleInvoiceService.getAllSalesInvoices().size(), 2);
    }

    @DisplayName("Test SaleInvoice get by id")
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testGetByIdSaleInvoice() {
        SaleDetail newSaleDetail = new SaleDetail();
        List<SaleDetail> testList = new ArrayList<>();
        testList.add(newSaleDetail);

        SaleInvoice testSaleInvoice1 = new SaleInvoice(testList);
        SaleInvoice testSaleInvoice2 = new SaleInvoice(testList);
        int saleId1 = saleInvoiceService.addSaleInvoice(testSaleInvoice1);
        int saleId2 = saleInvoiceService.addSaleInvoice(testSaleInvoice2);

        assertEquals(saleInvoiceService.getSaleInvoiceById(saleId1).getId(), saleId1);
    }

    @DisplayName("Test SaleInvoice update")
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testUpdateSaleInvoice() {
        SaleDetail newSaleDetail1 = new SaleDetail();
        List<SaleDetail> testList = new ArrayList<>();
        testList.add(newSaleDetail1);
        SaleDetail newSaleDetail2 = new SaleDetail();
        List<SaleDetail> newTestList = new ArrayList<>();
        newTestList.add(newSaleDetail2);

        SaleInvoice newNote = new SaleInvoice(testList);
        SaleInvoice updateNote = new SaleInvoice(newTestList);

        int newSaleInvoiceId = saleInvoiceService.addSaleInvoice(newNote);

        System.out.println("newDeliveryNoteId: " + newSaleInvoiceId);

        saleInvoiceService.updateSaleInvoice(newSaleInvoiceId, updateNote);


        assertEquals(saleInvoiceService.getSaleInvoiceById(newSaleInvoiceId).getSaleDetailList(), newTestList);
    }

    @DisplayName("Test SaleInvoice delete")
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testDeleteSaleInvoice() {
        SaleDetail newSaleDetail = new SaleDetail();
        List<SaleDetail> testList = new ArrayList<>();
        testList.add(newSaleDetail);

        int newSaleId = saleInvoiceService.addSaleInvoice(new SaleInvoice(testList));
        saleInvoiceService.deleteSaleInvoice(newSaleId);
        assertEquals(saleInvoiceService.getAllSalesInvoices().size(), 0);
    }

    @DisplayName("Test filter SaleInvoice by Date")
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testFilterSaleInvoiceByDate() throws ParseException {
        SaleDetail newSaleDetail = new SaleDetail();
        List<SaleDetail> testList = new ArrayList<>();
        testList.add(newSaleDetail);
        String strDate = "2020-06-23";
        String strStartDate = "2020-06-01";
        String strEndDate = "2020-06-30";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse(strDate);
        Date sDate = df.parse(strStartDate);
        Date eDate = df.parse(strEndDate);
        int saleId = saleInvoiceService.addSaleInvoice(new SaleInvoice(date, testList));

        assertEquals(saleInvoiceService.filterByDate(sDate, eDate).get(0).getId(), saleId);
    }

    @DisplayName("Test filter SaleInvoice by Date and Customer")
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testFilterSaleInvoiceByDateAndCustomer() throws ParseException {
        SaleDetail newSaleDetail = new SaleDetail();
        List<SaleDetail> testList = new ArrayList<>();
        testList.add(newSaleDetail);
        String strDate = "2020-06-23";
        String strStartDate = "2020-06-01";
        String strEndDate = "2020-06-30";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse(strDate);
        Date sDate = df.parse(strStartDate);
        Date eDate = df.parse(strEndDate);
        Customer customer = new Customer();
        Staff staff = new Staff();
        customerService.addCustomer(customer);
        staffService.addStaff(staff);

        int saleId = saleInvoiceService.addSaleInvoice(new SaleInvoice(date, staff, customer, testList));

        assertEquals(saleInvoiceService.filterByDateAndByCustomer(sDate, eDate, customer.getId()).get(0).getId(), saleId);
    }

    @DisplayName("Test filter SaleInvoice by Date and Staff")
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testFilterSaleInvoiceByDateAndStaff() throws ParseException {
        SaleDetail newSaleDetail = new SaleDetail();
        List<SaleDetail> testList = new ArrayList<>();
        testList.add(newSaleDetail);
        String strDate = "2020-06-23";
        String strStartDate = "2020-06-01";
        String strEndDate = "2020-06-30";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse(strDate);
        Date sDate = df.parse(strStartDate);
        Date eDate = df.parse(strEndDate);
        Customer customer = new Customer();
        Staff staff = new Staff();
        customerService.addCustomer(customer);
        staffService.addStaff(staff);

        int saleId = saleInvoiceService.addSaleInvoice(new SaleInvoice(date, staff, customer, testList));

        assertEquals(saleInvoiceService.filterByDateAndByStaff(sDate, eDate, staff.getId()).get(0).getId(), saleId);
    }
}
