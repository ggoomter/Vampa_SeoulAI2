package com.vam.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vam.model.BoardVO;
import com.vam.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
    private BoardService bservice;
	
	@GetMapping("/list")
	public String boardListGET(Model model) {
		log.info("게시판 목록 페이지 진입");
		model.addAttribute("list", bservice.getList());
		return "/board/list";
		/* /WEB-INF/views/board/list.jsp */
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
	
    /* 게시판 등록처리 */
    @PostMapping("/enroll")
    public String boardEnrollPOST(BoardVO board, RedirectAttributes rttr) {
        
        log.info("BoardVO : " + board);
        bservice.enroll(board);
        rttr.addFlashAttribute("result", "enrol success");
        return "redirect:/board/list";
        
    }
    
    /* 게시글 상세조회 */
    /* GET요청은 페이지이동이 거듭되는동안 이전페이지들의 요청정보를 기억하고 있어야 한다.
     * URL에 파라미터가 누적되어 전달되는데 이런 기법을 URL Rewrite처리라고 한다.*/
    @GetMapping("/get")
    public void boardGetPageGET(int bno, Model model) {
    	System.out.println("컨트롤러의 boardGetPageGET에서 파악하고있는 bno : "+bno);
    	System.out.println("컨트롤러의 boardGetPageGET에서 파악하고있는 model : "+model);
        model.addAttribute("pageInfo", bservice.getPage(bno));
        
    }
}
