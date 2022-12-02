<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>모든회원정보</h3>
학번 / 이름/ 나이/ 학년/ 비고<br>
	<c:forEach items="${allmember}" var="dto">
		 ${dto.hakbun } / 이름 : ${dto.name } / 나이 : ${dto.age }/ 학년 : ${dto.grade}/ 비고 : ${dto.etc }
		<br>
	</c:forEach>
</body>
</html>