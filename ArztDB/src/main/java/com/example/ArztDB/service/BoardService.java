package com.example.ArztDB.service;

import com.example.ArztDB.mapper.BoardMapper;
import com.example.ArztDB.repository.BoardRepository;

import com.example.ArztDB.vo.BoardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService implements BoardRepository {

    @Autowired
    BoardMapper mapper;

    @Override
    public List boardlist(){
        List<BoardVo> boardVos =  mapper.boardList();
        List pageBoard = new ArrayList<>();
        int pages = (int)(boardVos.size()%10 == 0 ? boardVos.size()/10 : Math.floor(boardVos.size()/10) + 1);
        for(int i=0; i<pages; i++){
            List<BoardVo> boards= new ArrayList<>();
            int num = boardVos.size() - (( ((boardVos.size()/10 - (i+1)) *10) + boardVos.size()%10)) < boardVos.size() ? boardVos.size() - (( ((boardVos.size()/10 - (i+1)) *10) + boardVos.size()%10)):boardVos.size();

            for (int j=i*10; j< num; j++){
                boards.add(boardVos.get(j));
            }
            pageBoard.add(boards);
        }

        return pageBoard;
    }

    @Override
    public BoardVo boardInsert(BoardVo boardVo){
        System.out.println(boardVo.toString());
        mapper.boardInsert(boardVo);

        return boardVo;
    }
    @Override
    public  BoardVo boardDelete(BoardVo boardVo){
        return mapper.boardDelete(boardVo);
    }

    @Override
    public  boolean boardUpdate(BoardVo boardVo){
        mapper.boardUpdate(boardVo);

        BoardVo oldBoard = mapper.boardDetail(boardVo);
        if(oldBoard.getContent().equals(boardVo.getContent()) && oldBoard.getSubject().equals(boardVo.getSubject())){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public BoardVo detail(BoardVo boardVo){

        return mapper.boardDetail(boardVo);
    }
}


