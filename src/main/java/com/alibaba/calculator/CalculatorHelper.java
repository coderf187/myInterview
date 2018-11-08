package com.alibaba.calculator;

import com.alibaba.calculator.operator.Operation;
import com.alibaba.calculator.operator.SimpleOperationFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static com.alibaba.calculator.OperatorConstants.*;

/**
 * @Author: fengjian
 * @Description:计算结果
 * @Date: Create in 10:54 AM 2018/11/8
 * @Version: 1.0.0
 */
public class CalculatorHelper {

    /**
     * 优先级
     */
    private static final int HIGHEST_PRIORITY = 0;
    private static final int FIRST_PRIORITY = 1;
    private static final int SECOND_PRIORITY = 2;

    /**
     * 提供给外部的计算方法
     *
     * @param expression 后缀表达式
     * @return 计算结果
     */
    public int calculation(String expression) {
        List<String> operandList = getPostfix(expression);
        Stack<Integer> calculationStack = new Stack<>();
        Integer operandRight;
        Integer operandLeft;
        for (String item : operandList) {
            if (isOperator(item)) {
                operandRight = calculationStack.pop();
                operandLeft = calculationStack.pop();

                Operation operation = SimpleOperationFactory.getOperation(item);
                operation.setFirstNum(operandLeft);
                operation.setSecondNum(operandRight);
                calculationStack.push(operation.calculator());
            } else {
                calculationStack.push(Integer.parseInt(item));
            }
        }

        return calculationStack.pop();
    }

    /**
     * 判断字符为运算符(+,-,*,/)
     *
     * @param c 输入字符
     * @return
     */
    private boolean isOperator(char c) {

        return ADD.equals(String.valueOf(c)) || SUBTRACT.equals(String.valueOf(c)) ||
                MULTIPLICATION.equals(String.valueOf(c)) || DIVISION.equals(String.valueOf(c));
    }

    /**
     * 判断字符为运算符(+,-,*,/)
     *
     * @param c 输入字符
     * @return
     */
    private boolean isOperator(String c) {

        return ADD.equals(c) || SUBTRACT.equals(c) ||
                MULTIPLICATION.equals(c) || DIVISION.equals(c);
    }

    /**
     * 返回的是运算符的优先级
     *
     * @param operator
     * @return
     */
    private int priority(Character operator) {
        if (ADD.equals(String.valueOf(operator)) || SUBTRACT.equals(String.valueOf(operator))) {
            return FIRST_PRIORITY;
        } else if (MULTIPLICATION.equals(String.valueOf(operator)) || DIVISION.equals(String.valueOf(operator))) {
            return SECOND_PRIORITY;
        } else {
            return HIGHEST_PRIORITY;
        }
    }

    /**
     * 通过表达式获得后缀表达式
     *
     * @param expression
     * @return
     */
    private List<String> getPostfix(String expression) {

        //操作符栈
        Stack<Character> operatorStack = new Stack<>();

        //存放后缀表达式
        List<String> suffixExpressionList = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            char oneChar = expression.charAt(i);
            //遇到操作数：直接输出（添加到后缀表达式中）
            if (Character.isDigit(oneChar)) {
                int num = oneChar - '0';
                while (i + 1 < expression.length() && Character.isDigit(expression.charAt(i + 1))) {
                    num = num * 10 + expression.charAt(i + 1) - '0';
                    i++;
                }
                suffixExpressionList.add(String.valueOf(num));
            }

            if (LEFT_PARENTHESIS.equals(String.valueOf(oneChar))) {
                //遇到左括号：将其入栈
                operatorStack.push(oneChar);
            } else if (RIGHT_PARENTHESIS.equals(String.valueOf(oneChar))) {
                //遇到右括号：执行出栈操作，并将出栈的元素输出，直到弹出栈的是左括号，左括号不输出。
                while (!LEFT_PARENTHESIS.equals(String.valueOf(operatorStack.peek()))) {
                    suffixExpressionList.add(String.valueOf(operatorStack.pop()));
                }
                //然后弹出左括号
                operatorStack.pop();
            } else if (isOperator(oneChar)) {
                //遇到运算符,栈为空时，直接入栈
                if (operatorStack.isEmpty()) {
                    operatorStack.push(oneChar);
                } else {
                    // 如果读入的操作符为非")"且优先级比栈顶元素的优先级高或一样
                    if (priority(operatorStack.peek()) < priority(oneChar)) {
                        operatorStack.push(oneChar);
                    } else if (priority(operatorStack.peek()) >= priority(oneChar)) {
                        suffixExpressionList.add(String.valueOf(operatorStack.pop()));
                        operatorStack.push(oneChar);
                    }
                }
            }
        }

        //最终将栈中的元素依次出栈。
        while (!operatorStack.isEmpty()) {
            suffixExpressionList.add(String.valueOf(operatorStack.pop()));
        }
        return suffixExpressionList;
    }

}
