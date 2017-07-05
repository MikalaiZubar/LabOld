package com.epam.zubar.service;

public class AddService {
	
	private int a;
	private int b;
	
	public AddService(int a, int b){
		this.a = a;
		this.b = b;
	}
	
	public int add(){
		return a*b;
	}
}
