package com.sist.board.controller;

import com.sist.board.service.CalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcController {
    @Autowired
    private CalcService calcService;

    @GetMapping("calc/result_react")
    public String calcResult(String x){
        return calcService.calcResult(x);
    }
}
