package controller;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.ProductService;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    public ProductService productService;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<Product> getProductById(@RequestParam(name = "id") int id) {
        return productService.getProductById(id);
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public int addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @RequestMapping(value = "/products", method = RequestMethod.PUT)
    public int updateProduct(@RequestBody Product product, @RequestParam(name = "id") int id) {
        return productService.updateProduct(id, product);
    }

    @RequestMapping(value = "/products", method = RequestMethod.DELETE)
    public int deleteProduct(@RequestParam(name = "id") int id) {
        return productService.deleteProduct(id);
    }

    @RequestMapping("*")
    public String fallbackMethod() {
        return "No matching endpoint found.\n";
    }
}
