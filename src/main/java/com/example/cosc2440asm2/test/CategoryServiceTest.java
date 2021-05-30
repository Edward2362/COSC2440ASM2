package com.example.cosc2440asm2.test;

import com.example.cosc2440asm2.model.Category;
import com.example.cosc2440asm2.service.CategoryService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class CategoryServiceTest {
    @Autowired
    public CategoryService categoryService;

    @DisplayName("Test Category create")
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testAddCategory() {
        int newCategoryId = categoryService.addCategory(new Category("category5"));
        assertEquals(categoryService.getAllCategories().get(0).getName(), "category5");
    }

    @DisplayName("Test Category get all")
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testGetAllCategory() {
        categoryService.addCategory(new Category("category5"));
        categoryService.addCategory(new Category("category9"));
        assertEquals(categoryService.getAllCategories().size(), 2);
    }

    @DisplayName("Test Category get by id")
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testGetByIdCategory() {
        Category testCategory1 = new Category("test category 1");
        Category testCategory2 = new Category("test category 2");
        int categoryId1 = categoryService.addCategory(testCategory1);
        int categoryId2 = categoryService.addCategory(testCategory2);

        assertEquals(categoryService.getCategoryById(categoryId1).get(0).getName(), "test category 1");
    }


    @DisplayName("Test Category update")
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testUpdateCategory() {
        Category newCategory = new Category("category1");
        Category updateCategory = new Category("category3");
        int newCategoryId = categoryService.addCategory(newCategory);

        System.out.println("newCategoryId: " + newCategoryId);

        System.out.println("UPDATE test newCategoryId = " + newCategory.toString());

        categoryService.updateCategory(newCategoryId, updateCategory);

        for (Category category : categoryService.getAllCategories()) {
            System.out.println(category.toString());
        }

        assertEquals(categoryService.getCategoryById(newCategoryId).get(0).getName(), "category3");
    }


    @DisplayName("Test Category delete")
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testDeleteCategory() {
        int newCategoryId = categoryService.addCategory(new Category("category1"));
        categoryService.deleteCategory(newCategoryId);
        assertEquals(categoryService.getAllCategories().size(), 0);
    }
}
