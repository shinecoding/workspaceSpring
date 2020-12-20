package com.bitcamp.test.board;

import java.util.List;

public interface BoardDaoImp {
	//전체레코드 선택
	public List<BoardVO> boardAllRecord();
	//레코드 추가 - 글쓰기
	public int boardInsert(BoardVO vo);
	//레코드 1개 선택
	public BoardVO boardSelect(int no);
	//조회수
	public int hitCount(int no);
	//글 수정
	public int boardUpdate(BoardVO vo);
	//글 삭제
	public int boardDelete(int no, String userid);
}
