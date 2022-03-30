package com.example.ArztDB.mapper;

import com.example.ArztDB.vo.BoardVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper{

    List<BoardVo> boardList();

    BoardVo boardDetail(BoardVo boardVo);;

    void boardInsert(BoardVo boardVo);

    BoardVo boardDelete(BoardVo boardVo);

    void boardUpdate(BoardVo boardVo);
}
