package com.example.demo.designpattern.proxy;

import java.util.Date;

/**
 * Created by Guoru on 2019/3/6.
 */
public class AddOperationProxy implements IOperation {
    private IOperation operation;

    public void setOperation(IOperation operation) {
        this.operation = operation;
    }

    @Override
    public int operate(int x, int y) {
        System.out.print("操作开始时间：" + new Date().toString() + "\n");
        int result = operation.operate(x, y);
        System.out.print("操作结束：" + new Date().toString() + "\n");
        return result;
    }
}
