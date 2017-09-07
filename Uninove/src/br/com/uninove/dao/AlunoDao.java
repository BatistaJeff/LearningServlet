package br.com.uninove.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.uninove.model.AlunoModel;

public class AlunoDao {

	private Connection connection;
	private ArrayList<AlunoModel> alunos;

	public AlunoDao(Connection connection) throws SQLException {
		this.connection = connection;
	}
	
	public void insert(AlunoModel alunoModel) throws SQLException {
	
		String SQL = "INSERT INTO ALUNO(NOME, RA, EMAIL, SENHA, LOGIN) VALUES (?,?,?,?,?)";
		
		PreparedStatement preparedStatement = connection.prepareStatement(SQL);
		preparedStatement.setString(1, alunoModel.getNome());
		preparedStatement.setString(2, alunoModel.getRa());
		preparedStatement.setString(3, alunoModel.getEmail());
		preparedStatement.setString(4, alunoModel.getSenha());
		preparedStatement.setString(5, alunoModel.getLogin());
		
		preparedStatement.execute();
		preparedStatement.close();
		connection.close();
	}
	
	public void update(AlunoModel alunoModel) throws SQLException {
		
		String SQL = "UPDATE ALUNO SET NOME=?, RA=?, EMAIL=?, SENHA=?, LOGIN=? WHERE ID=?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(SQL);
		preparedStatement.setString(1, alunoModel.getNome());
		preparedStatement.setString(2, alunoModel.getRa());
		preparedStatement.setString(3, alunoModel.getEmail());
		preparedStatement.setString(4, alunoModel.getSenha());
		preparedStatement.setString(5, alunoModel.getLogin());
		preparedStatement.setInt(6, alunoModel.getId());
		
		preparedStatement.execute();
		preparedStatement.close();
		connection.close();
	}
	
	public void delete(Integer id) throws SQLException {
		
		String SQL = "DELETE FROM ALUNO WHERE ID = ?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(SQL);
		preparedStatement.setInt(1, id);
		
		preparedStatement.execute();
		preparedStatement.close();
		connection.close();
	}
	
	public AlunoModel buscaAluno(Integer id) throws SQLException {
		
		AlunoModel alunoModel = null;
		String SQL = "SELECT * FROM ALUNO WHERE ID = ?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(SQL);
		preparedStatement.setInt(1, id);
		
		ResultSet resultSet = (ResultSet) preparedStatement.executeQuery();
		
		if(resultSet.next()) {
			
			alunoModel = new AlunoModel();
			
			alunoModel.setId(resultSet.getInt("ID"));
			alunoModel.setNome(resultSet.getString("NOME"));
			alunoModel.setRa(resultSet.getString("RA"));
			alunoModel.setEmail(resultSet.getString("EMAIL"));
			alunoModel.setSenha(resultSet.getString("SENHA"));
			alunoModel.setLogin(resultSet.getString("LOGIN"));
		}
		
		return alunoModel;
	}
	
	public List<AlunoModel> listaAlunos() throws SQLException {
		
		this.alunos = new ArrayList<AlunoModel>();
		
		String SQL = "SELECT * FROM ALUNO";
		
		PreparedStatement preparedStatement = connection.prepareStatement(SQL);
		ResultSet resultSet = (ResultSet) preparedStatement.executeQuery();
		
		while(resultSet.next()) {
			AlunoModel alunoModel = new AlunoModel();
			
			alunoModel.setId(resultSet.getInt("ID"));
			alunoModel.setNome(resultSet.getString("NOME"));
			alunoModel.setRa(resultSet.getString("RA"));
			alunoModel.setEmail(resultSet.getString("EMAIL"));
			alunoModel.setSenha(resultSet.getString("SENHA"));
			alunoModel.setLogin(resultSet.getString("LOGIN"));
			
			this.alunos.add(alunoModel);
		}
		
		preparedStatement.close();
		resultSet.close();
		connection.close();
		
		return this.alunos;
	}
	
}
