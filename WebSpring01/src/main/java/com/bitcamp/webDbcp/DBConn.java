package com.bitcamp.webDbcp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConn {
	protected Connection conn= null;
	protected PreparedStatement pstmt = null;
	protected ResultSet rs = null;
	protected String sql = null;
	
	public DBConn() {};
	//DB연결
	public void dbConn() {
		try {
			//JNDI "이름"을 가지고 "객체"를 얻을 수 있는 서비스
			Context ctx = new InitialContext(); //JNDI 서비스를 제공하는 객체를 생성
			Context envCtx = (Context)ctx.lookup("java:comp/env"); //톰캣에서 리소스를 관리하는 가상의 주소 //
			//lookup 메서드의 매개변수를 "이름"으로 참고하여 해당하는 자원의 "객체"를 반환

			DataSource ds = (DataSource)envCtx.lookup("jdbc/myoracle"); //context.xml에 등록한 자원의 이름

			conn = ds.getConnection();
			//커넥션 풀에 대기 중인 커넥션 객체를 빌려오는 작업

		}catch(Exception e) {
			System.out.println("DB연결에러 발생-----");
			e.printStackTrace();
		}
	}
	//DB닫기
	public void dbClose() {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}catch(Exception e) {
			
		}
	}
	
}
