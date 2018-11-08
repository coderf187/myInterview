package com.alibaba.calculator.operator;

/**
 * @Author: fengjian
 * @Description:计算除法 - 不考虑精度问题
 * @Date: Create in 17:54 AM 2018/11/8
 * @Version: 1.0.0
 */
public class DivOperation extends Operation {

    @Override
    public Integer calculator() {
        if (getSecondNum().equals(0)) {
            throw new IllegalArgumentException("被除数不能为0");
        }
        return getFirstNum() / getSecondNum();
    }
}