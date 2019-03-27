package com.example.demo.designpattern.rmi.client;

import java.rmi.Naming;

public class MyRemoteClient {
	public static void main(String[] args){
		try {
			MyRemote service = (MyRemote) Naming.lookup("rmi://127.0.0.1/RemoteHello");
			System.out.print(service.sayHello());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
