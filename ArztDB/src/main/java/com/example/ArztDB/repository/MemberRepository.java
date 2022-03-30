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

    void memberLogout(SessionVo sessionVo);

    MemberVo getMember(SessionVo sessionVo);

    SessionVo userState(SessionVo sessionVo);

    MemberVo memberUpdate(MemberVo memberVo);

    boolean memberDelete(MemberVo memberVo);
}
