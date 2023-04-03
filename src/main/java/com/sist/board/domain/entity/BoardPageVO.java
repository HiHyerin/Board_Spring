package com.sist.board.domain.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardPageVO {
    private int curpage, totalpage, startPage, endPage;
}
