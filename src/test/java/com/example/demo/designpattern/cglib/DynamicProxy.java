package com.example.demo.designpattern.cglib;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by Guoru on 2019/3/6.定义一个处理器
 */
public class DynamicProxy implements InvocationHandler {
    private Object target;

    public DynamicProxy(Object target){
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.print("操作开始时间：" + new Date().toString() + "\n");
        Object result = method.invoke(target, args);
        System.out.print("操作结束：" + new Date().toString() + "\n");
        return result;
    }
}
