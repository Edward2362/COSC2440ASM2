package com.example.cosc2440asm2.test;

import com.example.cosc2440asm2.model.Category;
import com.example.cosc2440asm2.model.DeliveryDetail;
import com.example.cosc2440asm2.model.InventoryDeliveryNote;
import com.example.cosc2440asm2.service.InventoryDeliveryNoteService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class InventoryDeliveryNoteServiceTest {
    @Autowired
    public InventoryDeliveryNoteService inventoryDeliveryNoteService;

    @DisplayName("Test DeliveryNote create")
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testAddCategory() {
        DeliveryDetail newDeliveryDetail = new DeliveryDetail();
        List<DeliveryDetail> testList = new ArrayList<>();
        testList.add(newDeliveryDetail);

        int newDeliveryNoteId = inventoryDeliveryNoteService.addInventoryDeliveryNote(new InventoryDeliveryNote(testList));

        assertEquals(inventoryDeliveryNoteService.getAllDeliveryNote().get(0).getId(), newDeliveryNoteId);
    }

    @DisplayName("Test DeliveryNote get all")
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testGetAllCategory() {
        DeliveryDetail newDeliveryDetail = new DeliveryDetail();
        List<DeliveryDetail> testList = new ArrayList<>();
        testList.add(newDeliveryDetail);

        inventoryDeliveryNoteService.addInventoryDeliveryNote(new InventoryDeliveryNote(testList));
        inventoryDeliveryNoteService.addInventoryDeliveryNote(new InventoryDeliveryNote(testList));

        assertEquals(inventoryDeliveryNoteService.getAllDeliveryNote().size(), 2);
    }

    @DisplayName("Test DeliveryNote get by id")
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testGetByIdCategory() {
        DeliveryDetail newDeliveryDetail = new DeliveryDetail();
        List<DeliveryDetail> testList = new ArrayList<>();
        testList.add(newDeliveryDetail);

        InventoryDeliveryNote testDeliveryNote1 = new InventoryDeliveryNote(testList);
        InventoryDeliveryNote testDeliveryNote2 = new InventoryDeliveryNote(testList);
        int deliveryNoteId1 = inventoryDeliveryNoteService.addInventoryDeliveryNote(testDeliveryNote1);
        int deliveryNoteId2 = inventoryDeliveryNoteService.addInventoryDeliveryNote(testDeliveryNote2);

        assertEquals(inventoryDeliveryNoteService.getInventoryDeliveryNoteById(deliveryNoteId1).get(0).getId(), deliveryNoteId1);
    }

    @DisplayName("Test DeliveryNote update")
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testUpdateCategory() {
        DeliveryDetail newDeliveryDetail = new DeliveryDetail();
        List<DeliveryDetail> testList = new ArrayList<>();
        testList.add(newDeliveryDetail);
        DeliveryDetail newDeliveryDetail2 = new DeliveryDetail();
        List<DeliveryDetail> newTestList = new ArrayList<>();
        newTestList.add(newDeliveryDetail2);

        InventoryDeliveryNote newNote = new InventoryDeliveryNote(testList);
        InventoryDeliveryNote updateNote = new InventoryDeliveryNote(newTestList);

        int newDeliveryNoteId = inventoryDeliveryNoteService.addInventoryDeliveryNote(newNote);

        System.out.println("newDeliveryNoteId: " + newDeliveryNoteId);

        inventoryDeliveryNoteService.updateInventoryDeliveryNote(newDeliveryNoteId, updateNote);


        assertEquals(inventoryDeliveryNoteService.getInventoryDeliveryNoteById(newDeliveryNoteId).get(0).getDeliveryDetailList(), newTestList);
    }

    @DisplayName("Test DeliveryNote delete")
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testDeleteCategory() {
        DeliveryDetail newDeliveryDetail = new DeliveryDetail();
        List<DeliveryDetail> testList = new ArrayList<>();
        testList.add(newDeliveryDetail);

        int newCategoryId = inventoryDeliveryNoteService.addInventoryDeliveryNote(new InventoryDeliveryNote(testList));
        inventoryDeliveryNoteService.deleteInventoryDeliveryNote(newCategoryId);
        assertEquals(inventoryDeliveryNoteService.getAllDeliveryNote().size(), 0);
    }

    @DisplayName("Test filter DeliveryNote by Date")
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testFilterDeliveryNoteByDate() throws ParseException {
        DeliveryDetail newDeliveryDetail = new DeliveryDetail();
        List<DeliveryDetail> testList = new ArrayList<>();
        testList.add(newDeliveryDetail);
        String strDate = "2020-06-23";
        String strStartDate = "2020-06-01";
        String strEndDate = "2020-06-30";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse(strDate);
        Date sDate = df.parse(strStartDate);
        Date eDate = df.parse(strEndDate);
        int noteId = inventoryDeliveryNoteService.addInventoryDeliveryNote(new InventoryDeliveryNote(date, testList));

        assertEquals(inventoryDeliveryNoteService.filterByDate(sDate, eDate).get(0).getId(), noteId);
    }
}
