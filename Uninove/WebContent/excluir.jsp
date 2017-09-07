<%@page import="br.com.uninove.servlet.AlunoServlet"%>
<%@page import="com.mysql.jdbc.jdbc2.optional.SuspendableXAConnection"%>
<%@page import="br.com.uninove.dao.ConnectionFactory"%>
<%@page import="java.util.*"%>
<%@page import="br.com.uninove.model.AlunoModel"%>
<%@page import="br.com.uninove.dao.AlunoDao"%>
<%@page import="java.io.PrintWriter"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<%
	Integer id = Integer.parseInt(request.getParameter("id").replace(" ", ""));

	AlunoDao alunoDao = new AlunoDao(ConnectionFactory.getConnection());

	if(id != null){
		alunoDao.delete(id);
	}
%>
	
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<script src="js/bootstrap.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" href="img/favicon.ico">
<title>UNINOVE</title>
</head>
<body>

	<h1 align="center">Usuario excluido com sucesso</h1>

	<a href="aluno.jsp" class="align:center">Ir para cadastro</a>
</body>
</html>