<%@ page language="java" 
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="/myweb/ProductServlet" method="get">
		    商品名称:<input type="text" name="keyword"/><br />
		 <button type="submit">给我搜</button>
		 <input type="hidden" name="type" value="query" />
	</form>
	<table border="1" width="700">
	<tr>
	<th>姓名</th>
	<th>价格</th>
	<th>备注</th>
	<th>操作</th>
	</tr>
	<c:forEach var="product" items="${productList}">
	<tr>
	<td>${product.name }</td>
	<td>${product.price }</td>
	<td>${product.remark }</td>
	<td>
	<a href="/myweb/ProductServlet?type=getById&id=${product.id}">更新</a>
	<a href="/myweb/ProductServlet?type=delete&id=${product.id}">删除</a>
	
	</td>
	</tr>
	</c:forEach>
	</table>
	
	
	
	

</body>
</html>