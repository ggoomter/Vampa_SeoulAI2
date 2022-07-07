package com.vam.service;

import org.springframework.stereotype.Service;

@Service("비번모를때인증으로")
public class 비번모를때인증으로 implements 비번변경{

	@Override
	public void change(String id) {
		System.out.println("비번모를때 실행하는 change. 입력받은 id : "+id);
		System.out.println("id로 유저객체 얻어오는 로직");
		System.out.println("인증 받는 로직.");//여기부분 추가
		System.out.println("비번 입력받는 로직");
		System.out.println("새비번으로 바꾸는 로직");
		
	}

	@Override
	public String getName() {
		return "비번모를때";
	}
	
}
