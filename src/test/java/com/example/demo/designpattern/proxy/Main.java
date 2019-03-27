package com.example.demo.designpattern.proxy;

import java.lang.reflect.Proxy;
import java.util.concurrent.CountDownLatch;

public class Main {

    public static void main(String[] args) {
       /* //静态
        IOperation addOperation = new AddOperation();
        AddOperationProxy addProxy = new AddOperationProxy();
        addProxy.setOperation(addOperation);
        System.out.print(addProxy.operate(1, 1));//通过代理类调用加法*/
        //动态
        IOperation addOperation = new AddOperation();
        IOperation proxy = (IOperation) Proxy.newProxyInstance(addOperation.getClass().getClassLoader(), addOperation.getClass().getInterfaces(), new DynamicProxy(addOperation));
        System.out.print(proxy.operate(1, 1));
    }
}
