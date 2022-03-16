package com.example.ArztDB.repository;

import com.example.ArztDB.vo.MemberVo;
import com.example.ArztDB.vo.SessionVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository {

    List<MemberVo> getAllMember();

    MemberVo memberInsert(MemberVo memberVo);

    SessionVo memberLogin(MemberVo memberVo);

    MemberVo getMember(MemberVo memberVo);

    Boolean userState(String str);
}
