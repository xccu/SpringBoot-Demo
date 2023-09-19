package com.spring.aop;

import org.springframework.stereotype.Component;

@Component("arithmeticCalculator")
public class ArithmeticCalculatorIml implements ArithmeticCalculator {

    @Override
    public int add(int i, int j) {
        int result = i + j;
        System.out.println("add->result:" + result);
        return result;
    }

    @Override
    public int div(int i, int j) {
        int result = i / j;
        System.out.println("div->result:" + result);
        return result;
    }

}
