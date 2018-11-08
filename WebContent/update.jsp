<%@ page language="java" 
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/myweb/ProductServlet" method="post">
		    商品名称:<input type="text" name="name" value="${product.name }"/><br />
		    商品价格:<input type="text" name="price" value="${product.price }"/><br />
		    商品备注:<input type="text" name="remark" value="${product.remark }"/><br />
		 <button type="submit">确认更新</button>
		 <input type="hidden" name="id" value="${product.id }"/>
		 <input type="hidden" name="type" value="update"/>
	</form>
</body>
</html>