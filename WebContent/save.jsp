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
		    商品名称:<input type="text" name="name"/><br />
		    商品价格:<input type="text" name="price" /><br />
		    商品备注:<input type="text" name="remark"/><br />
		 <button type="submit">提交</button>
		 <input type="hidden" name="type" value="save"/>
	</form>
</body>
</html>