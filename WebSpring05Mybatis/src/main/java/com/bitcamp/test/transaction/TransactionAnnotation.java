package com.bitcamp.test.transaction;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.test.board.BoardDaoImp;
import com.bitcamp.test.board.BoardVO;

@Controller
public class TransactionAnnotation {
	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	DataSourceTransactionManager transactionManager;
	
	@RequestMapping("/tran")
	public ModelAndView tranTest() {
		//TransactionStatus 객체를 구하여야 한다.
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(DefaultTransactionDefinition.PROPAGATION_REQUIRED);
		
		TransactionStatus status = transactionManager.getTransaction(def);
		
		BoardDaoImp dao = sqlSession.getMapper(BoardDaoImp.class);
		try {
			BoardVO vo = new BoardVO();
			vo.setSubject("트랜잭션 테스트");
			vo.setContent("트랜잭션 테스트 글내용");
			vo.setUserid("hongil");
			vo.setIp("111.222.333.444");
			
			dao.boardInsert(vo);
			
			BoardVO vo2 = new BoardVO();
			vo2.setSubject("트랜잭션 테스트22");
			vo2.setContent("트랜잭션 테스트 글내용222");
			vo2.setUserid("hongil");
			vo2.setIp("111.222.333.555");
			
			dao.boardInsert(vo2);  //여기서 에러나면 위 dao.boardInsert(vo)도 취소
			
			
			transactionManager.commit(status);
		}catch(Exception e) {
			transactionManager.rollback(status);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:boardList");
		return mav;
		
	}
}
