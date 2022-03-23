package com.example.ArztDB.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository {
//    void getApiProduct();
    List<String> getAllProductCategory1();
}
