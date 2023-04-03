package com.sist.board.domain.entity;

import com.fasterxml.jackson.databind.DatabindException;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "board")
@Getter
@Setter
public class BoardEntity {
    @Id
    private int no;
    private int hit;
    private String name, subject, content, pwd, regdate;


}
