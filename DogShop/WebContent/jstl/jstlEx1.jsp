<%@ page contentType = "text/html; charset=euc-kr" %>
<%@ taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>JSTL core 예제 - set, out, remove</title>
</head>
<body>

browser변수값 설정
<c:set var="browser" value="${header['User-Agent']}"/><br>
<!-- 변수에 값을 할당할 때 사용하는 태그 -->
<c:out value="${browser}"/><p>
<!-- 변수에 값을 츨력할 때 사용하는 태그 -->
browser변수값 제거 후
<c:remove var="browser"/>
<!-- 변수에 값을 제거할 때 사용하는 태그 -->
<c:out value="${browser}"/>
</body>
</html>
