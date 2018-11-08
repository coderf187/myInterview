package com.alibaba.calculator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: fengjian
 * @Description:
 * @Date: Create in 5:41 PM 2018/11/8
 * @Version: 1.0.0
 */
public class CalculatorHelperTest {

    @Test
    public void calculation() {
        CalculatorHelper helper = new CalculatorHelper();
        assertEquals(20,helper.calculation("3*0+3+8+9*1"));
        assertEquals(9,helper.calculation("3+(3-0)*2"));
        assertNotEquals(8,helper.calculation("3+(3-0)*2"));
    }
}