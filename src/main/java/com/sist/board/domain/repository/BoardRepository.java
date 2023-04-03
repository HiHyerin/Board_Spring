package com.sist.board.domain.repository;

import com.sist.board.domain.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import com.sist.board.domain.entity.*;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {
    @Query(value = "select * from board order by no desc limit :start, 10",  nativeQuery = true)
    public List<BoardEntity> boardListData(@Param("start") Integer start);

    @Query(value = "select ceil(count(*)/10.0) from board", nativeQuery = true)
    public int boardTotalPage();


    // detail
    public BoardEntity findByNo(@Param("no") Integer no);



}
