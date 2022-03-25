package com.example.ArztDB.vo;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CategoryVo {

    @JsonProperty
    private String category1;

    @JsonProperty
    private String category2;

    @JsonProperty
    private String category3;
}
