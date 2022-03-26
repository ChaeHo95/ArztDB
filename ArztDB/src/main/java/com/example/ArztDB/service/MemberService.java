package com.example.ArztDB.service;

import com.example.ArztDB.mapper.XmlMapper;
import com.example.ArztDB.vo.MemberVo;
import com.example.ArztDB.repository.MemberRepository;
import com.example.ArztDB.vo.SessionVo;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;

@Service
public class MemberService implements MemberRepository {
    Random rd = new Random();

    @Autowired
    XmlMapper mapper;

    @Override
    public List<MemberVo> getAllMember() {
        return mapper.getAllMember();
    }

    @Override
    public MemberVo memberInsert(MemberVo memberVo) {
        System.out.println("2");
        String user_id = mapper.getId(memberVo) == null ? null: memberVo.getUser_id();
        String user_phone = mapper.getPhone(memberVo) == null ? null: memberVo.getUser_phone();;
        String user_mail = mapper.getMail(memberVo) == null ? null: memberVo.getUser_mail();
        if(user_id == null && user_phone == null && user_mail == null) {
            memberVo.setUser_op("3");
            mapper.memberInsert(memberVo);
            memberVo.setUser_id(user_id);
            memberVo.setUser_phone(user_phone);
            memberVo.setUser_mail(user_mail);
            return memberVo;
        }else {
            memberVo.setUser_id(user_id);
            memberVo.setUser_phone(user_phone);
            memberVo.setUser_mail(user_mail);
            return memberVo;
        }
    }

    @Override
    public SessionVo memberLogin(MemberVo memberVo) {
        SessionVo sessionVo = new SessionVo();
        MemberVo member = mapper.getId(memberVo);

        List<SessionVo> sessionVos = mapper.getAllSession();
        for(int  i=0; i<sessionVos.size(); i++){
            if(sessionVos.get(i).getId() == member.getId()){
                sessionVo.setUser_login("overlap");
                return sessionVo;
            }
        }
        String str;
        String specialSymbol = "";
        for(int i=33; i<126; i++){
            specialSymbol = specialSymbol + String.valueOf((char)i);
        }
        specialSymbol = specialSymbol.replaceAll("[0-9a-zA-Z]","");

        if(member == null){
            sessionVo.setUser_login("false");
            return sessionVo;
        }else {
            if(member.getUser_pwd().equals(memberVo.getUser_pwd())){
                while (true) {
                    str = RandomStringUtils.randomAlphanumeric(20);
                    for (int i=0; i<sessionVos.size();i++){
                        if (str.equals(sessionVos.get(i).getUser_session())){
                            continue;
                        }
                    }
                    sessionVo.setUser_session(str);
                    break;
                }
                sessionVo.setUser_login("true");
                sessionVo.setId(member.getId());
                mapper.login(sessionVo);
                sessionVo.setId(null);

                StringBuffer buf = new StringBuffer(str);

                for(int i=0; i<10; i++){
                    int symbolsNum = rd.nextInt(specialSymbol.length());
                    int strIndex = rd.nextInt(buf.length());
                    buf.insert(strIndex,specialSymbol.charAt(symbolsNum));
                }

                sessionVo.setUser_session(buf.toString());

                return sessionVo;
            }else {
                sessionVo.setUser_login("false");
                return sessionVo;
            }
        }
    }

    @Override
    public void memberLogout(SessionVo session) {
        mapper.logout(getSession(session));
    }

    @Override
    public MemberVo getMember(SessionVo sessionVo) {
        return mapper.getMember(getSession(sessionVo));
    }

    @Override
    public Boolean userState(SessionVo sessionVo) {
        if(mapper.getSession(getSession(sessionVo)) == null){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public MemberVo memberUpdate(MemberVo memberVo) {
        String user_phone = mapper.getPhone(memberVo) == null ? null: memberVo.getUser_phone();;
        String user_mail = mapper.getMail(memberVo) == null ? null: memberVo.getUser_mail();
        if(user_phone == null && user_mail == null) {
            mapper.memberUpdate(memberVo);
            memberVo.setUser_phone(user_phone);
            memberVo.setUser_mail(user_mail);
            return memberVo;
        }else if(mapper.getId(mapper.getPhone(memberVo)).getUser_id().equals(memberVo.getUser_id()) && mapper.getId(mapper.getMail(memberVo)).getUser_id().equals(memberVo.getUser_id())) {
            mapper.memberUpdate(memberVo);
            memberVo.setUser_phone(null);
            memberVo.setUser_mail(null);
            return memberVo;
        }else {
            memberVo.setUser_phone(user_phone);
            memberVo.setUser_mail(user_mail);
            return memberVo;
        }
    }

    @Override
    public boolean memberDelete(SessionVo sessionVo) {
        MemberVo memberVo = mapper.getMember(getSession(sessionVo));
        mapper.memberDelete(memberVo);
        mapper.logout(getSession(sessionVo));
        if(mapper.getSession(getSession(sessionVo)) == null){
            return true;
        }else {
            return false;
        }
    }

    public SessionVo getSession(SessionVo sessionVo){

        String str = sessionVo.getUser_session();
        String match = "[^0-9a-zA-Z]";
        sessionVo.setUser_session(str.replaceAll(match,""));

        return sessionVo;
    }

}
