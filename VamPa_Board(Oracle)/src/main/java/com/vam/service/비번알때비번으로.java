package com.vam.service;

import org.springframework.stereotype.Service;

@Service("비번알때비번으로")
public class 비번알때비번으로 implements 비번변경{

	@Override
	public void change(String id) {
		System.out.println("비번알고있을때 실행하는 change. 입력받은 id : "+id);
		System.out.println("id로 유저객체 얻어오는 로직");
		System.out.println("비번 입력받는 로직");
		System.out.println("새비번으로 바꾸는 로직");
		
	}

	@Override
	public String getName() {
		return "비번알때";
	}

}
