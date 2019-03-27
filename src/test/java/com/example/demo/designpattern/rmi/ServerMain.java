package com.example.demo.designpattern.rmi;

import java.rmi.Naming;

public class ServerMain {
	public static void main(String[] args){
		MyRemote service;
		String SERVICENAME = "RemoteHello";
		try {
			service = new MyRemoteImpl();
			Naming.rebind(SERVICENAME, service);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
