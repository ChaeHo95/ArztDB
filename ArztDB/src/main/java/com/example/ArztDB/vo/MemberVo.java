package com.example.ArztDB.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberVo {

    @JsonProperty
    private Integer id;

    @JsonProperty
    private String user_id;

    @JsonProperty
    private String user_pwd;

    @JsonProperty
    private String user_name;

    @JsonProperty
    private String user_sex;

    @JsonProperty
    private String user_phone;

    @JsonProperty
    private String user_mail;

    @JsonProperty
    private String user_adress;

    @JsonProperty
    private String user_op;
}
