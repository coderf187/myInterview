package com.alibaba.calculator.operator;

/**
 * @Author: fengjian
 * @Description:计算加法 - 不考虑超过Integer越界问题
 * @Date: Create in 17:54 AM 2018/11/8
 * @Version: 1.0.0
 */
public class AddOperation extends Operation {

    @Override
    public Integer calculator() {
        return getFirstNum() + getSecondNum();
    }
}