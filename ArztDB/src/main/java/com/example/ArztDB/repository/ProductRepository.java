package com.example.ArztDB.repository;

import com.example.ArztDB.vo.CartVo;
import com.example.ArztDB.vo.CategoryVo;
import com.example.ArztDB.vo.ProductVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository {
//    void getApiProduct();
    List<String> getAllProductCategory1();
    List<String> getAllProductCategory2(CategoryVo categoryVo);
    List<String> getAllProductCategory3(CategoryVo categoryVo);
    List<ProductVo> getCategoryProdoct(CategoryVo categoryVo);
    ProductVo getProduct(ProductVo productVo);
    List<ProductVo> getCartProduct(CartVo cartVo);
    List<ProductVo> getAllProducts();
}
