package com.alibaba.stack;

import java.util.Stack;

/**
 * @Author: fengjian
 * @Description: 设计含最小函数min()、取出元素函数pop()、放入元素函数push()的栈AntMinStack，实现其中指定的方法。
 * push(data) -- 将元素data推入栈中。
 * pop() -- 删除栈顶的元素。
 * min() -- 检索栈中的最小元素。
 * @Date: Create in 11:15 AM 2018/11/6
 * @Version: 1.0.0
 */
public class AntMinStack {

    /**
     * 存储数据栈
     */
    private Stack<Integer> stack = new Stack<>();

    /**
     * 存放最小数栈
     */
    private Stack<Integer> minStack = new Stack<>();

    /**
     * push 放入元素
     *
     * @param data
     */
    public void push(int data) {
        stack.push(data);
        if (minStack.size() == 0 || data < minStack.peek()) {
            minStack.push(data);
        } else {
            minStack.push(minStack.peek());
        }
    }

    /**
     * pop 推出元素
     *
     * @return
     */
    public int pop() {
        minStack.pop();
        return stack.pop();
    }

    /**
     * min 最小函数，调用该函数，可直接返回当前AntMinStack的栈的最小值
     *
     * @return
     */
    public int min() {
        return minStack.peek();
    }

}
