package com.vam.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	@GetMapping("/list")
	public String boardListGET() {
		log.info("게시판 목록 페이지 진입");
		return "list";
		/* /WEB-INF/views/list.jsp */
	}
	
	@GetMapping("/enroll")
	public void boardEnrollGET() {
		log.info("게시판 등록 페이지 진입");
	}
	
	@GetMapping("/custom")
	public String boardCustomGET() {
		log.info("커스덤 페이지 진입");
		return "board/custom";	//void
	}
}
