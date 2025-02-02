<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${ logStatus == null || logStatus == 'N'}">
	<script>
		alert("로그인 후 자료실 글 등록이 가능합니다.");
		location.href="/myapp/login";
	</script>
</c:if>

<div>
	<h1>자료실 글 올리기 - 방법 1</h1>
	<form method="post" action="/myapp/fileUpload1Ok" enctype="multipart/form-data">
		제목 : <input type="text" name="title" style="width:80%"/><br/>
		글 내용 : <textarea name="content" style="width:80%; height:200px;"></textarea><br/>
		첨부파일1 : <input type="file" name="filename1" /><br/>
		첨부파일2 : <input type="file" name="filename2" /><br/>
		<input type="submit" value="업로드 하기" />
	</form>
</div>