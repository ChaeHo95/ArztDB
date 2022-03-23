package com.example.ArztDB.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class SessionVo {

    @JsonProperty
    private Integer id;
    @JsonProperty
    private String user_session;
    @JsonProperty
    private String user_login;
    @JsonProperty
    private String use_session;
}
