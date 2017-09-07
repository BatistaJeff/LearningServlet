<%@page import="com.mysql.jdbc.jdbc2.optional.SuspendableXAConnection"%>
<%@page import="br.com.uninove.dao.ConnectionFactory"%>
<%@page import="java.util.*"%>
<%@page import="br.com.uninove.model.AlunoModel"%>
<%@page import="br.com.uninove.dao.AlunoDao"%>
<%@page import="java.io.PrintWriter"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<script src="js/bootstrap.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" href="img/favicon.ico">
<title>UNINOVE</title>
</head>
<body >
	<div class="container">
	<h2 align="center">Cadastro de alunos</h2>
		<form action="cadastro" method="POST">
			<div class="form-group">
				<label for="nome">Nome:</label> <input type="text" class="form-control" id="nome" placeholder="Insira o nome do aluno" name="nome">
			</div>
			<div class="form-group">
				<label for="email">Email:</label> <input type="email" class="form-control" id="email" placeholder="Insira o email do aluno" name="email">
			</div>
			<div class="form-group">
				<label for="email">RA:</label> <input type="text" class="form-control" id="ra" placeholder="Insira o RA do aluno" name="ra">
			</div>
			<div class="form-group">
				<label for="pwd">Login:</label> <input type="text" class="form-control" id="login" placeholder="Insira o Login do aluno" name="login">
			</div>			
			<div class="form-group">
				<label for="pwd">Senha:</label> <input type="password" class="form-control" id="pwd" placeholder="Insira a senha para o aluno" name="senha">
			</div>
			<button type="submit" class="btn btn-default">Salvar</button>
		</form>
	</div>

	<br>
	<h2 align="center">Lista de alunos</h2>
		<form action="delete" method="GET">
			<table style="width:100%" class="table table-inverse">
					<th>ID</th>
					<th>Nome</th>
					<th>Login</th>
					<th>E-mail</th>
					<th>Ra</th>
					<th>Apagar</th>
					<th>Editar</th>
				</tr>
				<%
					AlunoDao dao = new AlunoDao(ConnectionFactory.getConnection());
					List<AlunoModel> alunos = dao.listaAlunos();
	
					for (AlunoModel aluno : alunos) {
				%>
	
				<tr>
					<td>
						<%=aluno.getId()%>
					</td>
					<td>
						<%=aluno.getNome()%>
					</td>
					<td>
						<%=aluno.getLogin()%>
					</td>
					<td>
						<%=aluno.getEmail()%>
					</td>
					<td>
						<%=aluno.getRa()%>
					</td>
					<td>
						<a href="excluir.jsp?id=<%=aluno.getId()%>">X</a>
					</td>
					<td>
						<a href="editar.jsp?id=<%=aluno.getId()%>">X</a>
					</td>
				</tr>
				<%
					}
				%>
	
			</table>
		</form>
</body>
</html>