<%@ page contentType = "text/html; charset=euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<html>
<head><title>JSTL sql 예제 - update, param</title></head>
<body>

<sql:update dataSource="jdbc/jsptest">
    update board set passwd=? where num= ?
	<sql:param value="${'2222'}"/>
	<sql:param value="${1}"/> 	
</sql:update>

<sql:query var="rs"  dataSource="jdbc/jsptest">
    select * from board 
</sql:query>

<table border="1">
  <tr><%--필드명  출력--%>
    <c:forEach var="columnName" items="${rs.columnNames}">
      <th><c:out value="${columnName}"/></th>
    </c:forEach>
  </tr>
  <c:forEach var="row" items="${rs.rowsByIndex}"><%-- 레코드의 수 만큼 반복한다. --%>
  <tr>
    <c:forEach var="column" items="${row}" varStatus="i"><%-- 레코드의 필드수 만큼 반복한다. --%>
   <td>
       <c:if test="${column!=null}"> <%--해당 필드값이 null이 아니면--%>
		    <c:out value="${column}"/>
	   </c:if> <%--해당 필드값이 null이면--%>
	   <c:if test="${column==null}">
		    &nbsp;
	   </c:if>
    </td>
    </c:forEach>
  </tr>
   </c:forEach>
</table>

</body>
</html>