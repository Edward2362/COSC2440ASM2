package controller;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.ProductService;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    public ProductService productService;

    @RequestMapping(path="/products", method = RequestMethod.GET)
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @RequestMapping(path="/products/{id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable("id") int id){
        return productService.getProduct(id);
    }

    @RequestMapping(path="/products", method = RequestMethod.POST)
    public int createProduct(Product product){
        return productService.addProduct(product);
    }
}
