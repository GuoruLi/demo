package com.example.demo.designpattern.cglib;

import java.lang.reflect.Proxy;

public class TestMain {
	public static void main(String[] args) {

		 // 生成 Cglib 代理类
		 IOperation addOpProxy = (IOperation) CglibProxy.getProxy(new AddOperation()); // 调用相关方法
		 addOpProxy.operate(1, 1);

		/*IOperation addOperation = new AddOperation();
		IOperation proxy = (IOperation) Proxy.newProxyInstance(addOperation
				.getClass().getClassLoader(), addOperation.getClass()
				.getInterfaces(), new DynamicProxy(addOperation));
		System.out.print(proxy.operate(1, 1));*/
	}
}