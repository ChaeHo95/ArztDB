package com.example.ArztDB.member;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberRepository {

    List<MemberVo> getAllMember();
    void memberInsert(MemberVo memberVo);
    boolean memberLogin(MemberVo memberVo);
    MemberVo getMember(MemberVo memberVo);
}
