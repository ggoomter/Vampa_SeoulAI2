package com.vam.service;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vam.model.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardServiceTests {
	
	private static final Logger log = LoggerFactory.getLogger(BoardServiceTests.class);
	
    @Autowired
    private BoardService service;
    
    @Qualifier("비번알때비번으로")
    @Autowired
    private 비번변경 비번변경인터페이스;
    
    
    //색깔 테스트
    //디커플링.   커플링을 감소.   의존관계 줄이기.
    //빈이 하나뿐이면 expected single matching bean 에러가 발생하지만 beanFactory를 사용한다면
    @Test
    public void testChangePW() {
    	//1. given   : change함수를 쓸수잇는 객체는 준비되어있어야 한다.
    	//현재는 junit이기때문에 단위테스트이기 때문에 외부에서 주입받을수없어서 new로 생성해주는데
    	//실제프로젝트에서는 외부에서 주입받아야 한다.
    	비번변경인터페이스 = new 비번알때비번으로();
    				// new 비번모를때인증으로();
    	
    	//2. when 내가 테스트하려고 하는건 change라는 함수
    	System.out.println("테스트실행");
    	비번변경인터페이스.change("홍길동");
    	//누가 올지 구체적으로 알고있지 않아도 된다. 그냥 인자로 들어온 인스턴스를 활용할 뿐이다.
    	
    	//3. then
    }
	/*
	 * JDBC connection객체 connect함수같은것도. oralce연결하든지, mysql로 하든지 나는 몰라도된다. connect함수를
	 * 호출할뿐이다. 어떤놈이 만들어질지는 설정파일로 정보를 전달했고, 그 정보대로 스프링이 인스턴스를 만든다. 스프링이 만든 인스턴스를 나는
	 * 전달받아서 쓸 뿐이다. 어떻게 만들어졌는지에 대한 구체적으로 몰라도된다.
	 */
    
    @Test
    public void testEnroll() {
        
        BoardVO vo = new BoardVO();
        
        vo.setTitle("service test");
        vo.setContent("service test");
        vo.setWriter("service test");
        
        service.enroll(vo);	
        //BoardService인터페이스의 enroll함수를 호출하면
        //매핑되어있는 BoardMapper.xml의 id가 enroll인 쿼리가 실행된다.
    }
    
    /* 게시글 목록 테스트 */
    @Test
    public void testGetList() {
        service.getList().forEach(board -> log.info("" + board));        
    }
    
    /*게시글 상세 조회*/
    @Test
    public void testGETPage() {
        int bno = 24;
        log.info("" + service.getPage(bno));
    }
 
}