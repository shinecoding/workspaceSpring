package com.bitcamp.webDbcp.board;

import java.util.ArrayList;
import java.util.List;

import com.bitcamp.webDbcp.DBConn;

public class BoardDAO extends DBConn implements BoardDaoInterface {

	@Override
	public List<BoardVO> getAllRecord() {
		List<BoardVO> list = new ArrayList<BoardVO>();
		try {
			dbConn();
			sql = "select no, subject, userid, hit, to_char(writedate, 'MM-DD HH:MI') writedate"
					+ " from freeboard order by no desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setNo(rs.getInt(1));
				vo.setSubject(rs.getString(2));
				vo.setUserid(rs.getString(3));
				vo.setHit(rs.getInt(4));
				vo.setWritedate(rs.getString(5));
				list.add(vo);
			}
			
		}catch(Exception e) {
			System.out.println("게시판 레코드 선택 에러 발생-->" + e.getMessage());
		}finally {
			dbClose();
		}
		return list;
	}

	@Override
	public int writeBoard(BoardVO vo) {
		int cnt = 0;
		try {
			dbConn();
			sql = "insert into freeboard(no, subject, userid, content, ip) "
					+ " values(a_sq.nextval, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getSubject());
			pstmt.setString(2, vo.getUserid());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getIp());
			cnt = pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("글쓰기 에러 발생-->"+e.getMessage());
		}finally {
			dbClose();
		}return cnt;
	}

	@Override
	public int editBoard(BoardVO vo) {
		int cnt = 0;
		try {
			dbConn();
			sql = "update freeboard set subject=?, content=? where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getSubject());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getNo());
			
			cnt = pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("게시판 글 수정 에러 발생-->" + e.getMessage());
		}finally {
			dbClose();
		}return cnt;
	}

	@Override
	public int deleteBoard(int no, String userid) {
		int cnt = 0;
		try {
			dbConn();
			sql = "delete from freeboard where no = ? and userid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setString(2, userid);
			cnt = pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("글 삭제 에러 발생-->" +e.getMessage());
		}finally {
			dbClose();
		}
		return cnt;
	}

	@Override //레코드 1개 선택
	public void selectBoard(BoardVO vo) {
		try {
			dbConn();
			sql = "select no, subject, content, hit, to_char(writedate, 'MM-DD HH:MI') writedate, userid "
					+ "from freeboard where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getNo());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setNo(rs.getInt(1));
				vo.setSubject(rs.getString(2));
				vo.setContent(rs.getString(3));
				vo.setHit(rs.getInt(4));
				vo.setWritedate(rs.getString(5));
				vo.setUserid(rs.getString(6));
				
			}
			
		}catch(Exception e) {
			System.out.println("레코드 선택 에러 발생-->" + e.getMessage());
		}finally {
			dbClose();
		}

	}

	@Override
	public void hitCount(int no) {
		try {
			dbConn();
			sql = "update freeboard set hit=hit+1 where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("조회수 증가 에러 발생-->" + e.getMessage());
		}finally {
			dbClose();
		}

	}

}
