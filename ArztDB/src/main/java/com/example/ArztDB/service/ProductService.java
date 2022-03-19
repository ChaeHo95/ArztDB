package com.example.ArztDB.service;

import com.example.ArztDB.repository.ProductRepository;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductService implements ProductRepository {

    @Override
    public String getApiProduct() {
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id", "Seu2doFVGJJVta6tZHKc");
        headers.add("X-Naver-Client-Secret", "tcoqLirbGK");
        String body = "";
        String test = "여성패션";
        HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
        List<String> testList = new ArrayList<String>();
        for(int i=1; i<1000; i=i+100) {
            ResponseEntity<String> responseEntity = rest.exchange("https://openapi.naver.com/v1/search/shop.json?query=" + test + "&display=100&start=" + i, HttpMethod.GET, requestEntity, String.class);
            String response = responseEntity.getBody();
            testList.add(response);
        }
        return testList.toString();

    }

}
