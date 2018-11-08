package com.alibaba.calculator.operator;

/**
 * @Author: fengjian
 * @Description:计算抽象类
 * @Date: Create in 17:54 AM 2018/11/8
 * @Version: 1.0.0
 */
public abstract class Operation {

    private Integer firstNum;
    private Integer secondNum;

    public abstract Integer calculator();

    public Integer getFirstNum() {
        return firstNum;
    }

    public Integer getSecondNum() {
        return secondNum;
    }

    public void setFirstNum(Integer firstNum) {
        this.firstNum = firstNum;
    }

    public void setSecondNum(Integer secondNum) {
        this.secondNum = secondNum;
    }
}