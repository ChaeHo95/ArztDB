package com.example.ArztDB.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService implements MemberRepository {

    @Autowired
    MemberRepository memberRepository;

    @Override
    public List<MemberVo> getMember() {
        return memberRepository.getMember();
    }

    @Override
    public void memberInsert(MemberVo memberVo) {
        memberRepository.memberInsert(memberVo);
    }
}
