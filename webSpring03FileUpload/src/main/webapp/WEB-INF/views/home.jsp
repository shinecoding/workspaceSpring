<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<div>
<h1>
	파일 업로드
</h1>
<P>
<pre>
	1. web.xml, jsp지시부 한글 인코딩<br/>
	2. pom.xml <br/>
	3. ojdbc6.jar <br/>
	4. servlet-context.xml <br/>
	5. Constants 클래스 생성 <br/>
	6. HomeController에 template 객체 생성<br/>
	
	
	파일업로드 프레임워크
	1. commons-fileupload, commons-io 를 pom.xml에 Dependency한다.
	2. root-context.xml에 MultipartResolver객체를 생성하고
	3. web.xml에 있는 DispatcherServlet에 root-context.xml 위치를 추가한다.
</pre>
</P>
</div>


