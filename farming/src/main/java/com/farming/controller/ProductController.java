package com.farming.controller;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.farming.models.Product;
import com.farming.models.User;
import com.farming.repository.FarmerRepository;
import com.farming.repository.ProductRepository;
import com.farming.service.ProductService;
import com.farming.service.UserService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import java.util.List;

@Transactional
@RestController
public class ProductController {
	@Autowired
	public ProductRepository productRepository;
    @Autowired
    private ProductService productService;
    
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    
//    farmer-dashboard page
    @GetMapping("/products")
    public String getFdashboard() {
        // Logic to return the registration page HTML
       return "dashboard-farmer"; // Assuming "register.html" is the name of your HTML file
    }  

    @Autowired
    private FarmerRepository farmerRepository;

//    @PostMapping("/products")
//    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
//        // Retrieve the farmer's ID based on the provided email
//        Long farmerId = farmerRepository.getFarmerIdByEmail(product.getFarmerEmail());
//
//        if (farmerId == null) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//        }
//
//        // Set the farmer ID for the product
//        product.setFarmerId(farmerId);
//
//        // Save the product
//        Product savedProduct = productService.saveProduct(product);
//
//        return ResponseEntity.ok(savedProduct);
//}
//    @PostMapping("/products")
    @RequestMapping(value = "/products", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveProduct(@ModelAttribute Product product) {
        // Here you can save the product to a database or perform any other logic
        System.out.println("Received product data: " + product);

        // Return a response indicating success
        ProductService.saveProduct(product);
        return ResponseEntity.ok().body("Product added successfully");
    }
}