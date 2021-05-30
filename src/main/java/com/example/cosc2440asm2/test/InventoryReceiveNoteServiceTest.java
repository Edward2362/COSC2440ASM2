package com.example.cosc2440asm2.test;

import com.example.cosc2440asm2.model.InventoryReceiveNote;
import com.example.cosc2440asm2.model.Order;
import com.example.cosc2440asm2.model.OrderDetail;
import com.example.cosc2440asm2.model.ReceivingDetail;
import com.example.cosc2440asm2.service.InventoryReceiveNoteService;
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
public class InventoryReceiveNoteServiceTest {
    @Autowired
    InventoryReceiveNoteService inventoryReceiveNoteService;

    @DisplayName("Test InventoryReceiveNote create")
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testAddInventoryReceiveNote(){
        ReceivingDetail receivingDetail = new ReceivingDetail();
        List<ReceivingDetail> testList = new ArrayList<>();
        testList.add(receivingDetail);

        int newReceivingNoteId =inventoryReceiveNoteService.addInventoryReceiveNote(new InventoryReceiveNote(testList));

        assertEquals(inventoryReceiveNoteService.getAllReceiveNotes().get(0).getId(), newReceivingNoteId);
    }

    @DisplayName("Test InventoryReceiveNote getAll")
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testGetAllReceivingNote(){
        ReceivingDetail receivingDetail = new ReceivingDetail();
        List<ReceivingDetail> testList = new ArrayList<>();
        testList.add(receivingDetail);

        inventoryReceiveNoteService.addInventoryReceiveNote(new InventoryReceiveNote(testList));
        inventoryReceiveNoteService.addInventoryReceiveNote(new InventoryReceiveNote(testList));

        assertEquals(inventoryReceiveNoteService.getAllReceiveNotes().size(),2);
    }

    @DisplayName("Test InventoryReceiveNote getById")
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testGetReceivingNoteById(){
        ReceivingDetail receivingDetail = new ReceivingDetail();
        List<ReceivingDetail> testList = new ArrayList<>();
        testList.add(receivingDetail);

        InventoryReceiveNote inventoryReceiveNote1 = new InventoryReceiveNote(testList);
        InventoryReceiveNote inventoryReceiveNote2 = new InventoryReceiveNote(testList);
        int receivingNote1 = inventoryReceiveNoteService.addInventoryReceiveNote(inventoryReceiveNote1);
        int receivingNote2 = inventoryReceiveNoteService.addInventoryReceiveNote(inventoryReceiveNote2);

        assertEquals(inventoryReceiveNoteService.getInventoryReceiveNoteById(receivingNote1).getId(),receivingNote1);
    }

    @DisplayName("Test InventoryReceiveNote update")
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testUpdateReceivingNote(){
        ReceivingDetail receivingDetail1 = new ReceivingDetail();
        List<ReceivingDetail> testList = new ArrayList<>();
        testList.add(receivingDetail1);

        ReceivingDetail receivingDetail2 = new ReceivingDetail();
        List<ReceivingDetail> newTestList = new ArrayList<>();
        newTestList.add(receivingDetail2);

        InventoryReceiveNote newInventoryReceiveNote = new InventoryReceiveNote(testList);
        InventoryReceiveNote updateNote = new InventoryReceiveNote(newTestList);

        int newReceivingNoteId = inventoryReceiveNoteService.addInventoryReceiveNote(newInventoryReceiveNote);

        System.out.println("newReceivingNoteId" + newReceivingNoteId);

        inventoryReceiveNoteService.updateInventoryReceiveNote(newReceivingNoteId,updateNote);

        assertEquals(inventoryReceiveNoteService.getInventoryReceiveNoteById(newReceivingNoteId).getId(), newReceivingNoteId);
    }

    @DisplayName("Test ReceivingNote delete")
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testDeleteReceivingNote(){
        ReceivingDetail receivingDetail1 = new ReceivingDetail();
        List<ReceivingDetail> testList = new ArrayList<>();
        testList.add(receivingDetail1);

        int newNotId = inventoryReceiveNoteService.addInventoryReceiveNote(new InventoryReceiveNote(testList));
        inventoryReceiveNoteService.deleteInventoryReceiveNote(newNotId);
        assertEquals(inventoryReceiveNoteService.getAllReceiveNotes().size(),0);
    }

    @DisplayName("Test filter ReceivingNote by Date")
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testFilterReceivingNoteByDate() throws  ParseException {
        ReceivingDetail receivingDetail1 = new ReceivingDetail();
        List<ReceivingDetail> testList = new ArrayList<>();
        testList.add(receivingDetail1);
        String strDate = "2020-06-23";
        String strStartDate = "2020-06-01";
        String strEndDate = "2020-06-30";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse(strDate);
        Date sDate = df.parse(strStartDate);
        Date eDate = df.parse(strEndDate);
        int inventoryReceiveNoteId = inventoryReceiveNoteService.addInventoryReceiveNote(new InventoryReceiveNote(date, testList));
        assertEquals(inventoryReceiveNoteService.filterByDate(sDate, eDate).get(0).getId(), inventoryReceiveNoteId);
    }
}
