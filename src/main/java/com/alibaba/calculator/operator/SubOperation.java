package com.alibaba.calculator.operator;

/**
 * @Author: fengjian
 * @Description:计算减法 - 不考虑负数相减越界问题
 * @Date: Create in 17:54 AM 2018/11/8
 * @Version: 1.0.0
 */
public class SubOperation extends Operation {

    @Override
    public Integer calculator() {
        return getFirstNum() - getSecondNum();
    }
}