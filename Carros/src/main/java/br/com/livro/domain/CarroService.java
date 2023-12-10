package br.com.livro.domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarroService {
	private CarroDAO db = new CarroDAO();
	
	//Lista todos os carros do banco de Dados
	public List<Carro> getCarros() {
		try {
			List<Carro> carros = db.getCarros();
			return carros;
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<Carro>();
		}
	}
	
	//Busca um carro pelo id
	
}
