package com.example.cosc2440asm2.test;

import com.example.cosc2440asm2.model.Product;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.example.cosc2440asm2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductServiceTest {
    @Autowired
    public ProductService productService;


}
