package com.alibaba.calculator.operator;

import com.alibaba.calculator.OperatorConstants;

/**
 * @Author: fengjian
 * @Description:简单抽象工厂
 * @Date: Create in 17:54 AM 2018/11/8
 * @Version: 1.0.0
 */
public class SimpleOperationFactory {

    public static Operation getOperation(String operationType) {

        if (OperatorConstants.ADD.equals(operationType)) {
            return new AddOperation();
        } else if (OperatorConstants.SUBTRACT.equals(operationType)) {
            return new SubOperation();
        } else if (OperatorConstants.MULTIPLICATION.equals(operationType)) {
            return new MulOperation();
        } else if (OperatorConstants.DIVISION.equals(operationType)) {
            return new DivOperation();
        } else {
            throw new IllegalArgumentException("操作符不正确!");
        }
    }
}