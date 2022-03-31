package com.example.ArztDB.controller;

import com.example.ArztDB.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
//import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping(value = "product")
public class ProductController {

    @Autowired
    ProductService productService;

//    @RequestMapping(value ="/test" , method = RequestMethod.GET )
//    public void getApi(){
//        productService.getApiProduct();
//    }
    @RequestMapping(value = "/category1", method = RequestMethod.GET)
    public List<String> getCategory1(){
        return productService.getAllProductCategory1();
    }
}
