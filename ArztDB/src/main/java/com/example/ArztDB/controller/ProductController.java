package com.example.ArztDB.controller;

import com.example.ArztDB.service.ProductService;
import com.example.ArztDB.vo.CategoryVo;
import com.example.ArztDB.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/category2", method = RequestMethod.POST)
    public List<String> getCategory2(@RequestBody CategoryVo categoryVo){
        return productService.getAllProductCategory2(categoryVo);
    }
    @RequestMapping(value = "/category3", method = RequestMethod.POST)
    public List<String> getCategory3(@RequestBody CategoryVo categoryVo){
        return productService.getAllProductCategory3(categoryVo);
    }
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public List<ProductVo> getCategoryProdoct(@RequestBody CategoryVo categoryVo){
      return  productService.getCategoryProdoct(categoryVo);
    }
    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public ProductVo getProduct(@RequestBody ProductVo productVo){
        return productService.getProduct(productVo);
    }

}
