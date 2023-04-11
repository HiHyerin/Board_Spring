package com.sist.board.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class CalcService {
    public String calcResult(String x){
        String result = evaluateExpression(x);
        System.out.println(result);
        return result;
    }

    public String evaluateExpression(String input) {
        String[] tokens = input.split("(?=[\\+\\-\\*/])|(?<=[\\+\\-\\*/])");

        double total = 0;
        char operator = '+';
        for (String token : tokens) {
            if (token.matches("[\\+\\-\\*/]")) {
                operator = token.charAt(0);
            } else {
                double operand = Double.parseDouble(token);
                switch (operator) {
                    case '+':
                        total += operand;
                        break;
                    case '-':
                        total -= operand;
                        break;
                    case '*':
                        total *= operand;
                        break;
                    case '/':
                        total /= operand;
                        break;
                }
            }
        }

        return String.valueOf(Math.round(total*1000.0)/1000.0);
    }
}
