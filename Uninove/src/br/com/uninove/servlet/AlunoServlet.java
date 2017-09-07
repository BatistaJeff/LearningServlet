package br.com.uninove.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.uninove.dao.AlunoDao;
import br.com.uninove.dao.ConnectionFactory;
import br.com.uninove.model.AlunoModel;


@WebServlet(urlPatterns = "/cadastro")
public class AlunoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 867163186903517717L;
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AlunoModel alunoModel = new AlunoModel();
		alunoModel.setEmail(request.getParameter("email"));
		alunoModel.setLogin(request.getParameter("login"));
		alunoModel.setNome(request.getParameter("nome"));
		alunoModel.setRa(request.getParameter("ra"));
		alunoModel.setSenha(request.getParameter("senha"));
		
		try {
			AlunoDao alunoDao = new AlunoDao(ConnectionFactory.getConnection());
			alunoDao.insert(alunoModel);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		PrintWriter writer = response.getWriter();
		
		writer.print("<!DOCTYPE html>"
				+ "<htm>"
				+ "<body>"
				+ "<head>"
				+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.css\">"
				+ "<script src=\"js/bootstrap.js\"></script>"
				+ "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">"
				+ "<title>UNINOVE</title>"
				+ "<link rel=\"icon\" href=\"img/favicon.ico\">"
				+ "</head>"
				+ "<h1 align=\"center\">Cadastro feito com sucesso</h1>"
				+ "<a href=\"aluno.jsp\">Ir para cadastro</a>"
				+ "</body>"
				+ "</html>");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id = Integer.parseInt(request.getParameter("id").replace(" ", ""));
		AlunoModel alunoModel = new AlunoModel();
		alunoModel.setId(id);
		alunoModel.setEmail(request.getParameter("email"));
		alunoModel.setLogin(request.getParameter("login"));
		alunoModel.setNome(request.getParameter("nome"));
		alunoModel.setRa(request.getParameter("ra"));
		alunoModel.setSenha(request.getParameter("senha"));
		
		try {
			AlunoDao alunoDao;
			alunoDao = new AlunoDao(ConnectionFactory.getConnection());
			alunoDao.update(alunoModel);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		PrintWriter writer = response.getWriter();
		
		writer.print("<!DOCTYPE html>"
				+ "<htm>"
				+ "<body>"
				+ "<head>"
				+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.css\">"
				+ "<script src=\"js/bootstrap.js\"></script>"
				+ "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">"
				+ "<title>UNINOVE</title>"
				+ "<link rel=\"icon\" href=\"img/favicon.ico\">"
				+ "</head>"
				+ "<h1 align=\"center\">Atualização feito com sucesso</h1>"
				+ "<a href=\"aluno.jsp\">Ir para cadastro</a>"
				+ "</body>"
				+ "</html>");
	}
	
}
