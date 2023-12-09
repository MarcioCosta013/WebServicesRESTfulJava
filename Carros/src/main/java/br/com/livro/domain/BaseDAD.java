package br.com.livro.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAD {
	public BaseDAD() {
		try {
			//Necessario para utilizar o driver JDBC do MySql
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			//Erro de driver JDBC (adicione o driver .jar do MySql em /WEB-INF/lib)
			
			e.printStackTrace();
		}
	}
	
	protected Connection getConnection() throws SQLException {
		//URL de conexão com o banco de dados
		String url = "jdbc:mysql://localhost/livro";
		
		//Conecta utilizando a URL, usuario e senha.
		Connection conn = DriverManager.getConnection(url, "livro", "livro123");
		return conn;
	}
	
	public static void main(String[] args) throws SQLException {
		BaseDAD db = new BaseDAD();
		
		//testa a conexao.
		Connection conn = db.getConnection();
		System.out.println(conn);
	}
}
