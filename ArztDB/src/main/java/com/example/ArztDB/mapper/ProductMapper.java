package com.example.ArztDB.mapper;

import com.example.ArztDB.vo.CategoryVo;
import com.example.ArztDB.vo.ProductVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    //    ProductVo getProduct(ProductVo productVo);

    void productInsert(ProductVo productVo);
    List<String> getAllProductCategory1();
    List<String> getAllProductCategory2(CategoryVo categoryVo);
    List<String> getAllProductCategory3(CategoryVo categoryVo);
    List<ProductVo> getProducts(CategoryVo categoryVo);
    ProductVo getProduct(ProductVo productVo);
}
