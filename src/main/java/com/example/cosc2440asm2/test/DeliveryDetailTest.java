package com.example.cosc2440asm2.test;

import com.example.cosc2440asm2.model.DeliveryDetail;
import com.example.cosc2440asm2.model.InventoryDeliveryNote;
import com.example.cosc2440asm2.model.SaleDetail;
import com.example.cosc2440asm2.model.SaleInvoice;
import com.example.cosc2440asm2.service.DeliveryDetailService;
import com.example.cosc2440asm2.service.InventoryDeliveryNoteService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class DeliveryDetailTest {
    @Autowired
    DeliveryDetailService deliveryDetailService;

    @Autowired
    InventoryDeliveryNoteService inventoryDeliveryNoteService;

    @DisplayName("Test DeliveryDetail get all")
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testGetAllDeliveryDetail() {
        DeliveryDetail newSaleDetail1 = new DeliveryDetail();
        DeliveryDetail newSaleDetail2 = new DeliveryDetail();
        List<DeliveryDetail> testList = new ArrayList<>();
        testList.add(newSaleDetail1);
        testList.add(newSaleDetail2);

        inventoryDeliveryNoteService.addInventoryDeliveryNote(new InventoryDeliveryNote(testList));

        assertEquals(deliveryDetailService.getAllDeliveryDetails().size(), 2);
    }
}
