package com.example.ArztDB.mapper;

import com.example.ArztDB.vo.MemberVo;
import com.example.ArztDB.vo.SessionVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface XmlMapper {
    List<MemberVo> getAllMember();
    MemberVo getMember(SessionVo sessionVo);
    void memberInsert(MemberVo memberVo);
    MemberVo getId(MemberVo memberVo);
    MemberVo getPhone(MemberVo memberVo);
    MemberVo getMail(MemberVo memberVo);
    void login(SessionVo sessionVo);
    List<SessionVo> getAllSession();
    void memberUpdate(MemberVo memberVo);
    void memberDelete(MemberVo memberVo);
    MemberVo getSession(SessionVo sessionVo);
    void logout(SessionVo sessionVo);
}
