package com.example.ArztDB.service;

import com.example.ArztDB.vo.ProductVo;
import com.fasterxml.jackson.core.JsonParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import com.example.ArztDB.mapper.ProductMapper;
import com.example.ArztDB.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ProductService implements ProductRepository {

    @Autowired
    ProductMapper productMapper;

//    @Override
//    public void getApiProduct() {
//        RestTemplate rest = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("X-Naver-Client-Id", "Seu2doFVGJJVta6tZHKc");
//        headers.add("X-Naver-Client-Secret", "tcoqLirbGK");
//        String body = "";
//        String test = "건강/의료용품";
//
//        HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
//        for (int i = 1; i < 500; i = i + 100) {
//            try {
//                ResponseEntity<String> responseEntity = rest.exchange("https://openapi.naver.com/v1/search/shop.json?query=" + test + "&display=100&start=" + i, HttpMethod.GET, requestEntity, String.class);
//                String response = responseEntity.getBody();
//                Object obj = response;
//                JSONParser jsonParser = new JSONParser();
//                JSONObject jsonObject = (JSONObject) jsonParser.parse((String) obj);
//                JSONArray jsonArray = (JSONArray) jsonObject.get("items");
//
//                if (jsonArray.size() > 0) {
//                    for (int j = 0; j < jsonArray.size(); j++) {
//                        ProductVo productVo = new ProductVo();
//                        JSONObject jsonObj = (JSONObject) jsonArray.get(j);
//                        productVo.setProductId((String) jsonObj.get("productId"));
//                        if(productMapper.getProduct(productVo) != null){
//                            continue;
//                        }
//                        productVo.setBrand((String) jsonObj.get("brand"));
//                        productVo.setCategory1((String) jsonObj.get("category1"));
//                        productVo.setCategory2((String) jsonObj.get("category2"));
//                        productVo.setCategory3((String) jsonObj.get("category3"));
//                        productVo.setImage((String) jsonObj.get("image"));
//                        productVo.setLprice((String) jsonObj.get("lprice"));
//                        productVo.setTitle((String) jsonObj.get("title"));
//                        productVo.setMallName((String) jsonObj.get("mallName"));
//                        productMapper.productInsert(productVo);
//                    }
//                }
//            }catch (ParseException e){
//                e.printStackTrace();
//            }
//        }
//    }
}
