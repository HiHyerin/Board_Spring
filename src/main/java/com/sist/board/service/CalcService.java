package com.sist.board.service;

import org.springframework.stereotype.Service;

@Service
public class CalcService {
    public String calcResult(String x){


        String result = x;
        System.out.println("CalcService:"+result);


        return result;
    }
}
