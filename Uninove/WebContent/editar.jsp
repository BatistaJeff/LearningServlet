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
	
	AlunoModel alunoModel = null;
	
	if(id != null){
		alunoModel = alunoDao.buscaAluno(id);
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
	<div class="container">
	<h2 align="center">Atualizar aluno</h2>
		<form action="cadastro" method="GET">
			<div class="form-group">
				<label for="nome">Id:</label> <input type="text" class="form-control" id="id" placeholder="Insira o nome do aluno" name="id" value="<%= alunoModel.getId()%>">
			</div>
			<div class="form-group">
				<label for="nome">Nome:</label> <input type="text" class="form-control" id="nome" placeholder="Insira o nome do aluno" name="nome" value="<%= alunoModel.getNome()%> ">
			</div>
			<div class="form-group">
				<label for="email">Email:</label> <input type="email" class="form-control" id="email" placeholder="Insira o email do aluno" name="email" value="<%= alunoModel.getEmail() %>">
			</div>
			<div class="form-group">
				<label for="email">RA:</label> <input type="text" class="form-control" id="ra" placeholder="Insira o RA do aluno" name="ra"  value="<%= alunoModel.getRa() %>">
			</div>
			<div class="form-group">
				<label for="pwd">Login:</label> <input type="text" class="form-control" id="login" placeholder="Insira o Login do aluno" name="login" value="<%= alunoModel.getLogin() %>" >
			</div>			
			<div class="form-group">
				<label for="pwd">Senha:</label> <input type="password" class="form-control" id="pwd" placeholder="Insira a senha para o aluno" name="senha" value="<%= alunoModel.getSenha() %>">
			</div>
			<button type="submit" class="btn btn-default">Salvar</button>
		</form>
	</div>

</body>
</html>