package com.example.cosc2440asm2.controller;

import com.example.cosc2440asm2.model.Product;
import com.example.cosc2440asm2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    public ProductService productService;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }


    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public List<Product> getProductById(@PathVariable(name = "id") int id) {
        return productService.getProductById(id);
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public int addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.PUT)
    public int updateProduct(@RequestBody Product product, @PathVariable(name = "id") int id) {
        return productService.updateProduct(id, product);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
    public int deleteProduct(@PathVariable(name = "id") int id) {
        return productService.deleteProduct(id);
    }
}
