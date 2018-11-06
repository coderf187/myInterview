package com.alibaba.stack;

import com.alibaba.stack.AntMinStack;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * @Author: fengjian
 * @Description: 测试min函数
 * @Date: Create in 11:20 AM 2018/11/6
 * @Version: 1.0.0
 */
public class AntMinStackTest {

    private AntMinStack antMinStack = new AntMinStack();

    @Before
    public void before(){
        antMinStack.push(3);
        antMinStack.push(2);
        antMinStack.push(7);
        antMinStack.push(5);
        antMinStack.push(1);
    }

    @After
    public void after(){
        antMinStack = null;
    }

    @Test
    public void min() {
        assertEquals(1,antMinStack.min());
        antMinStack.pop();
        assertEquals(2,antMinStack.min());
        antMinStack.pop();
        antMinStack.pop();
        antMinStack.pop();
        assertEquals(3,antMinStack.min());
    }
}