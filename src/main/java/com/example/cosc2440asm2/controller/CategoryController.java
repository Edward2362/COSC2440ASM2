package com.example.cosc2440asm2.controller;

import com.example.cosc2440asm2.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.cosc2440asm2.service.CategoryService;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    public CategoryService categoryService;

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public List<Category> getCategoryById(@RequestParam(name = "id") int id) {
        return categoryService.getCategoryById(id);
    }

    @RequestMapping(value = "/categories", method = RequestMethod.POST)
    public int addCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    @RequestMapping(value = "/categories", method = RequestMethod.PUT)
    public int updateCategory(@RequestBody Category category, @RequestParam(name = "id") int id) {
        return categoryService.updateCategory(id, category);
    }

    @RequestMapping(value = "/categories", method = RequestMethod.DELETE)
    public int deleteCategory(@RequestParam(name = "id") int id) {
        return categoryService.deleteCategory(id);
    }

}
