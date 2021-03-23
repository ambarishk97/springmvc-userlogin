<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ page contentType="text/html; charset=UTF-8" %>
<%--import spring supplied JSP tag lib --%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Welcome</title>
</head>
<body>
	<% response.setContentType( "text/html; charset=utf-8" ); %>

	
			 <p>Welcome ${firstname}</p>
		
		
		
		<table style="background-color: cyan; margin: auto; border-collapse: collapse;border: 1px solid black;width: 45% ">
	<caption>USERS</caption>
	<c:forEach var="v" items="${users}">
		<tr>
		
			<td style="border: 1px solid black">${v.username}</td>
			<td style="border: 1px solid black">${v.firstname}</td>
			<td style="border: 1px solid black">${v.lastname}</td>
			<td style="border: 1px solid black">${v.phone}</td>
		</tr>
		</c:forEach>
		</table>
		
			
		</tr>
	</table>
	
	
<table style="background-color: cyan; margin: auto; border-collapse: collapse;border: 1px solid black;width: 45% ">
	<caption>USERS LIST EXTRACTED USING .XML FILE</caption>
	<c:forEach var="v" items="${userlist}">
		<tr>
		
			<td style="border: 1px solid black">${v.username}</td>
			<td style="border: 1px solid black">${v.firstname}</td>
			<td style="border: 1px solid black">${v.lastname}</td>
			<td style="border: 1px solid black">${v.phone}</td>
		</tr>
		</c:forEach>
		</table>
		
			<td><a href="home.jsp">Home</a></td>
		</tr>
	</table>
	<p><b>Label 1 using properties file: </b>${label1}</p>
		<p>Hindi Label using properties file: ${label2}</p>
			<p>Name in hindi using properties file: ${label3}</p>
	
</body>
</html>