package com.example.ArztDB.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService implements MemberRepository {

    @Autowired
    MemberRepository memberRepository;

    @Override
    public List<MemberVo> getAllMember() {
        return memberRepository.getAllMember();
    }

    @Override
    public void memberInsert(MemberVo memberVo) {
        memberRepository.memberInsert(memberVo);
    }

    @Override
    public boolean memberLogin(MemberVo memberVo) {
        MemberVo member= memberRepository.getMember(memberVo);
        if(member == null){
            return false;
        }else {
            if(!member.getUser_pwd().equals(memberVo.getUser_pwd())){
                return false;
            }else {
                return true;
            }
        }
    }
    @Override
    public MemberVo getMember(MemberVo memberVo) {
        return memberRepository.getMember(memberVo);
    }
}
