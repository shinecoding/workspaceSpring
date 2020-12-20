<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div>
<h1>로그인</h1>
<form method="post" action="/myapp/loginOk">
	아이디: <input type="text" id="userid" name="userid"/><br/>
	비밀번호: <input type="password" id="userpwd" name="userpwd"/><br/>
	<input type="submit" value="Login" />
</form>
</div>