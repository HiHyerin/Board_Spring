package com.sist.board.controller;

import com.sist.board.domain.entity.BoardEntity;
import com.sist.board.domain.entity.BoardPageVO;
import com.sist.board.domain.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;

@RestController
public class BoardController {
    @Autowired
    private BoardRepository bRepo;

    @GetMapping("board/list_react")
    public List<BoardEntity> boardListData(String page){
        if (page == null)
            page = "1";
        int curpage = Integer.parseInt(page);
        int rowSize = 10; // 한 페이지에 나올 게시글 개수
        int start = (curpage * rowSize)-rowSize;
        List<BoardEntity> list = bRepo.boardListData(start);

        for(BoardEntity vo:list) {
            String s = vo.getRegdate();
            String[] ss = s.split(" ");
            vo.setRegdate(ss[0]);
        }


//        for(BoardEntity vo:list){
//            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//            String s = format.format(vo.getRegdate());
//        }
        System.out.println("hi");
        return list;
    }

    @GetMapping("board/page_react")
    public BoardPageVO boardPageData(String page){
        if (page == null)
            page = "1";
        int curpage = Integer.parseInt(page);
        int totalpage = bRepo.boardTotalPage();

        final int BLOCK = 10;
        int startPage = ((curpage-1)/BLOCK*BLOCK)+1;
        int endPage = ((curpage-1)/BLOCK*BLOCK)+BLOCK;

        if(endPage>totalpage)
            endPage = totalpage;

        BoardPageVO vo = new BoardPageVO();
        vo.setCurpage(curpage);
        vo.setStartPage(startPage);
        vo.setEndPage(endPage);
        vo.setTotalpage(totalpage);

        return vo;
    }

    @GetMapping("board/detail_react")
    public BoardEntity boardDetailData(int no){
        BoardEntity vo = bRepo.findByNo(no);
        //조회수 증가
        vo.setHit(vo.getHit()+1);
        bRepo.save(vo);
        ///////////
        return vo;
    }

    @PostMapping("board/insert_react")
    public BoardEntity boardInsert(@RequestBody BoardEntity boardEntity){
        bRepo.save(boardEntity);

        return boardEntity;
    }
}
