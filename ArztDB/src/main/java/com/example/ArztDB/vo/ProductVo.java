package com.example.ArztDB.vo;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@ToString
@Getter
@Setter
public class ProductVo {
    @JsonProperty
    private String brand;

    @JsonProperty
    private String category1;

    @JsonProperty
    private String category2;

    @JsonProperty
    private String category3;

    @JsonProperty
    private String image;

    @JsonProperty
    private String lprice;

    @JsonProperty
    private String mallName;

    @JsonProperty
    private String productId;

    @JsonProperty
    private String title;

    @JsonProperty
    private Date data;

}
