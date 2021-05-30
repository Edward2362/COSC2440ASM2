package com.example.cosc2440asm2.test;

import com.example.cosc2440asm2.model.Category;
import com.example.cosc2440asm2.model.Product;
import com.example.cosc2440asm2.service.CategoryService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.example.cosc2440asm2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class ProductServiceTest {
    @Autowired
    public ProductService productService;
    @Autowired
    public CategoryService categoryService;


    @DisplayName("Test Product get all")
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)

    public void testGetAllProduct() {
        Category testCategory = new Category("Test Category");
        int testCategoryId = categoryService.addCategory(testCategory);

        Product product1 = new Product("product 1", testCategory);
        Product product2 = new Product("product 2", testCategory);

        int productId1 = productService.addProduct(product1);
        int productId2 = productService.addProduct(product2);

        assertEquals(productService.getAllProducts().size(), 2);
    }

    @DisplayName("Test Product get by id")
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testGetProductById() {
        Category testCategory = new Category("Test Category");
        int testCategoryId = categoryService.addCategory(testCategory);

        Product product1 = new Product("product 1", testCategory);
        Product product2 = new Product("product 2", testCategory);

        int productId1 = productService.addProduct(product1);
        int productId2 = productService.addProduct(product2);

        assertEquals(productService.getProductById(productId1).get(0).getName(), product1.getName());
    }

    @DisplayName("Test Product create")
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testCreateProduct() {
        Category testCategory = new Category("Test Category");
        int testCategoryId = categoryService.addCategory(testCategory);

        Product product = new Product("new Product 1", testCategory);
        int newProductId = productService.addProduct(product);
        assertEquals(productService.getProductById(newProductId).get(0).getName(), product.getName());
    }

    @DisplayName("Test Product update")
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testUpdateProduct() {
        Category testCategory = new Category("Test Category");
        int testCategoryId = categoryService.addCategory(testCategory);

        Product testProduct1 = new Product("product 1", testCategory);
        Product testProduct2 = new Product("product 2", testCategory);
        int productId1 = productService.addProduct(testProduct1);
//        int productId2 = productService.addProduct(testProduct2);

        productService.updateProduct(productId1, testProduct2);

        assertEquals(productService.getProductById(productId1).get(0).getName(), testProduct2.getName());
    }

    @DisplayName("Test Product delete")
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testDeleteProduct() {
        Category testCategory = new Category("Test Category");
        int testCategoryId = categoryService.addCategory(testCategory);

        Product testProduct1 = new Product("product 1", testCategory);
        Product testProduct2 = new Product("product 2", testCategory);
        int productId1 = productService.addProduct(testProduct1);
        int productId2 = productService.addProduct(testProduct2);

        productService.deleteProduct(productId1);
        assertEquals(productService.getAllProducts().size(), 1);
    }

}
