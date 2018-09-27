
<%@page import="java.util.ArrayList"%>
<%@page import="vo.Dog"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.*"%>
<%@page import="javax.servlet.http.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		List<Dog> dogList = (List<Dog>) request.getAttribute("dogList");
		//request : 내장객체 : jsp 자체에서 제공되는 내장객체
		int num = 1;
	%>
	<h1 align="center">강아지 목록</h1>
	<P></P>
	<table align="center">
		<%
			if (dogList != null) {
		%>
		<tr>
			<%
			for (int i = 0; i < dogList.size(); i++) {
					Dog dog = dogList.get(i);
		%>

			<td><a href="dogView.dog?id=<%=dog.getId()%>"><img
					src="<%=dog.getImage() + ".jpg"%>" height="100" width="100"
					border="0"></a><br> 상품명 : <%=dog.getKind()%><br>가격 : <%=dog.getPrice()%>원
			</td>
			<%-- <%
				if ((i + 1) % 4 == 0) {
			%>
		</tr>
		<tr>
			<%
				}
			%> --%>

			<%
				}
			%>
		</tr>
		<%
				}
			%>

	</table>
	<br>
	<br>
	<h1 align="center">오늘 본 개 상품</h1>
	<table align="center" width="600">
		<tr>
			<%
				ArrayList<String> images = (ArrayList<String>) request.getAttribute("images");
				if (images != null & images.size() > 0) {
					for (int i = 0; i < images.size(); i++) {
			%>
			<td align="center"><img src="<%=images.get(i) + ".jpg"%>"></td>
			<%
				}

				}
			%>
		</tr>
	</table>
</body>
</html>