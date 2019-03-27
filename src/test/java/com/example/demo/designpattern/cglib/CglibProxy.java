package com.example.demo.designpattern.cglib;

import java.lang.reflect.Method;
import java.util.Date;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor{
	private Object target;
	
	public CglibProxy(Object target) {
		this.target = target;
	}

	@Override
	public Object intercept(Object o, Method method, Object[] objects,
			MethodProxy methodProxy) throws Throwable {
		System.out.print("操作开始时间：" + new Date().toString() + "\n");
        Object result = method.invoke(target, objects);
        System.out.print("操作结束：" + new Date().toString() + "\n");
        return result;
	}

	public static Object getProxy(Object target) {
        Enhancer enhancer = new Enhancer();
        // 设置需要代理的对象，使enhancer对象继承target类
        enhancer.setSuperclass(target.getClass());
        // 设置代理人
        enhancer.setCallback(new CglibProxy(target));
        return enhancer.create();
    }
}
