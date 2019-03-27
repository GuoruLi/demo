package com.example.demo.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by Guoru on 2019/3/6.
 */
public class DynamicProxy implements InvocationHandler {
    private IOperation operation;

    public DynamicProxy(IOperation operation){
        this.operation = operation;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.print("操作开始时间：" + new Date().toString() + "\n");
        Object result = method.invoke(operation, args);
        System.out.print("操作结束：" + new Date().toString() + "\n");
        return result;
    }
}
