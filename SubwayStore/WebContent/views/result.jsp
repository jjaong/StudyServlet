<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!-- page 지시어 -->
<%
	
	String sandwich = (String)request.getAttribute("sandwich");
	String[] toppings = (String[])request.getAttribute("toppings");
	String[] cookies = (String[])request.getAttribute("cookies");
	String payment = (String)request.getAttribute("payment");
	int price = (int)request.getAttribute("price");


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문내역</title>
</head>
<body>
	<h1>주문내역</h1>
	샌드위치:<%= sandwich %><br>
	
	토핑 :
	<% if(toppings == null){ %>
		선택안함
	<% } else{ %>
		<%= String.join(",", toppings) %>
	<%} %>
	
	쿠키 : 
	<% if(cookies == null) { %>
		선택안함
	<% } else{ %>
		<%= String.join(",", cookies) %>
	<% } %>
	
	결제 방식 : <%= payment %> <br><br>
	
	위와 같이 주문하시겠습니까? <br>
	
	총 가격 : <%=price %>원



</body>
</html>