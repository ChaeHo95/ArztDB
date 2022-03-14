package com.example.ArztDB.member;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberRepository {

    List<MemberVo> getMember();
    void memberInsert(MemberVo memberVo);
}
