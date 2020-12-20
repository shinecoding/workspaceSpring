package com.bitcamp.webDbcp.board;

import java.util.List;

public interface BoardDaoInterface {
	//전체 리스트 구하기
	public List<BoardVO> getAllRecord();
	
	//글쓰기
	public int writeBoard(BoardVO vo);
	
	//글 수정하기
	public int editBoard(BoardVO vo);
	
	//글 삭제하기
	public int deleteBoard(int no, String userid);
	
	//글 하나 선택(내용보기할 때, 수정할 때)
	//public BoardVO selectBoard(int no);
	public void selectBoard(BoardVO vo);
	//조회수 증가
	public void hitCount(int no);
}
