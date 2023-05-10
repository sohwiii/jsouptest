<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<a href="/jsouphome">다시 검색</a>
</form>
<p>${titles}</p>
<%-- <p>${percent}</p> --%>
<img src="${src}">
<c:forEach items="${srcList}" var="src">
<p>${src}</p>
<%-- <img src="${src}"> --%>
</c:forEach>
</body>
</html>