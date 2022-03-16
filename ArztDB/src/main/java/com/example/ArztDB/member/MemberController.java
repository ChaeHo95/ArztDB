package com.example.ArztDB.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping(value = "member")
public class MemberController {
    @Autowired
    MemberService memberService;

    @RequestMapping("test")
    public ModelAndView register() {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("member/Register");

        return mv;
    }
    @RequestMapping(value ="/reg" , method = RequestMethod.POST )
    public void memberRegister(@RequestBody MemberVo memberVo) {
        System.out.println(memberVo);
        memberService.memberInsert(memberVo);
    }

    @RequestMapping(value ="/show" , method = RequestMethod.GET )
    public List<MemberVo> userShow() {
        return memberService.getAllMember();
    }

    @RequestMapping(value ="/login" , method = RequestMethod.POST)
    public boolean memberLogin(@RequestBody MemberVo memberVo) {
        return memberService.memberLogin(memberVo);
    }
}
