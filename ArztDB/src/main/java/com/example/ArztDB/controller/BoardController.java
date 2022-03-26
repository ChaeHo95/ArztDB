package com.example.ArztDB.controller;


import com.example.ArztDB.service.BoardService;
import com.example.ArztDB.vo.BoardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping(value = "board")
public class BoardController {

    @Autowired
    BoardService boardService;

    //계시글 생성
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public BoardVo boardInsert(@RequestBody BoardVo boardVo){
        System.out.println(boardVo.toString());
        return boardService.boardInsert(boardVo);
    }

    //전체 리스트
    @RequestMapping(value ="/show" , method = RequestMethod.GET )
    public List<BoardVo> allboardlist(){
        return boardService.boardlist();
    }

    //계시글 삭제
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public BoardVo boardDelete(@RequestBody BoardVo boardVo){
        return boardService.boardDelete(boardVo);
    }


    //계스글 수정
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public BoardVo boardUpdate(@RequestBody BoardVo boardVo){
        return boardService.boardUpdate(boardVo);
    }

    @RequestMapping(value ="/detail" , method = RequestMethod.POST )
    public BoardVo detail(@RequestBody BoardVo boardVo){
        return boardService.detail(boardVo);
    }


}
