<%@page import="java.util.List"%>
<%@ page import="domain.Profile" %>
<%@ page import="domain.Repair" %>
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
			Profile profile = (Profile) session.getAttribute("profile") ;
			List<Repair> repairList = (List<Repair>) session.getAttribute("repairs");
		%>
		<h2><%=profile.getName()%> <%=profile.getSurname()%></h2>

		<ol>
			<%for(Repair repair: repairList){ %>
			<li><%=repair.getNameOfDeviceInRepair() %> <%=repair.getPrice()%></li>
			<%}%>
		</ol>
		<a href="finalize">Save</a>
	</body>
</html>
