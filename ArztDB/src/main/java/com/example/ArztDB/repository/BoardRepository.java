package com.example.ArztDB.repository;


import java.util.List;
import com.example.ArztDB.vo.BoardVo;
import org.springframework.stereotype.Repository;


@Repository
public interface BoardRepository {

    List<BoardVo> boardlist();

    BoardVo boardInsert(BoardVo boardVo);

    BoardVo boardDelete(BoardVo boardVo);

    BoardVo boardUpdate(BoardVo boardVo);

    BoardVo detail(BoardVo boardVo);
}