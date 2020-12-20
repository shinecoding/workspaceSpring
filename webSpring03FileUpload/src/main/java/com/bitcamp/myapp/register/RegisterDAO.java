package com.bitcamp.myapp.register;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bitcamp.myapp.Constants;

public class RegisterDAO {
	public JdbcTemplate template = null;
	public RegisterDAO() {
		template = Constants.template;
	}
	
	public RegisterVO login(RegisterVO vo) {
		System.out.println(template);
		String sql = "select count(userid) cnt from register where userid=? and userpwd=?";
		RegisterVO vo1 = template.queryForObject(sql, new BeanPropertyRowMapper<RegisterVO>(RegisterVO.class), vo.getUserid(), vo.getUserpwd());
		
		if(vo1.getCnt() <=0) {
			return null;
			
		}else {
			String sql2 = "select userid, username from register where userid=? and userpwd=?";
			return template.queryForObject(sql2, new BeanPropertyRowMapper<RegisterVO>(RegisterVO.class), vo.getUserid(), vo.getUserpwd());
		}
	}
}
