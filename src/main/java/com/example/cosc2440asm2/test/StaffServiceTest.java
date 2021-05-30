package com.example.cosc2440asm2.test;


import com.example.cosc2440asm2.model.Category;
import com.example.cosc2440asm2.model.Staff;
import com.example.cosc2440asm2.service.StaffService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@Transactional
public class StaffServiceTest {
    @Autowired
    public StaffService staffService;

    @DisplayName("Test Staff create")
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testAddStaff() {
        Staff staff = new Staff("new Staff 1");
        int newStaffId = staffService.addStaff(staff);
        assertEquals(staffService.getStaffById(newStaffId).get(0).getName(), staff.getName());
    }

    @DisplayName("Test Staff getAll")
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testGetAllStaff(){
        staffService.addStaff(new Staff("staff 1"));
        staffService.addStaff(new Staff("staff 2"));
        assertEquals(staffService.getAllStaffs().size(), 2);
    }

    @DisplayName("Test Staff get by id")
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testGetStaffByid(){
        Staff testStaff1 = new Staff("staff 1");
        Staff testStaff2 = new Staff("staff 2");
        int staffId1 = staffService.addStaff(testStaff1);
        int staffId2 = staffService.addStaff(testStaff2);

        assertEquals(staffService.getStaffById(staffId1).get(0).getName(), "staff 1");
    }

    @DisplayName("Test Staff update")
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testUpdateStaff(){
        Staff testStaff1 = new Staff("staff 1");
        Staff testStaff2 = new Staff("staff 2");
        int staffId1 = staffService.addStaff(testStaff1);
//        int staffId2 = staffService.addStaff(testStaff2);

        staffService.updateStaff(staffId1, testStaff2);

        assertEquals(staffService.getStaffById(staffId1).get(0).getName(), testStaff2.getName());
    }

    @DisplayName("Test Staff delete")
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testDeleteStaff(){
        Staff testStaff1 = new Staff("staff 1");
        Staff testStaff2 = new Staff("staff 2");
        int staffId1 = staffService.addStaff(testStaff1);
        int staffId2 = staffService.addStaff(testStaff2);

        staffService.deleteStaff(staffId1);
        assertEquals(staffService.getAllStaffs().size(), 1);
    }
}
