package com.example.ArztDB.controller;

import com.example.ArztDB.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@RequestMapping(value = "product")
public class ProductController {

    @Autowired
    ProductService productService;

//    @RequestMapping(value ="/test" , method = RequestMethod.GET )
//    public void getApi(){
//        productService.getApiProduct();
//    }
}
