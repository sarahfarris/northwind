package com.pluralsight.northwind.controller;


import com.pluralsight.northwind.dao.ProductDao;
import com.pluralsight.northwind.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductDao productDao;

    @Autowired
    public ProductController(ProductDao productDao) {
        this.productDao = productDao;
    }

    //get endpoints
    @GetMapping("product")
    public List<Product> getAllProducts(){
        return productDao.getAllProducts();
    }

    @GetMapping("product/{id}")
    public Product getProductByID(@PathVariable int productId){
        return productDao.getProductByID(productId);
    }

    @GetMapping("products/name/{name}")
    public Product getProductByName(@PathVariable String productName) {
        return productDao.getProductByName(productName);
    }

    @PostMapping("product")
    public Product addNewProduct(@RequestBody Product product) {
        return productDao.addNewProduct(product);
    }
}