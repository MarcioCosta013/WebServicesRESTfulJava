package br.com.livro.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.livro.domain.Carro;
import br.com.livro.domain.CarroService;
import br.com.livro.domain.ListaCarros;
import br.com.livro.util.JAXBUtil;
import br.com.livro.util.ServletUtil;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@WebServlet("/carros/*")
public class CarrosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CarroService carroService = new CarroService();
	
	/*@Override                                                 //-------> para XML <-------------
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Carro> carros = carroService.getCarros();
		ListaCarros lista = new ListaCarros();
		lista.setCarros(carros);
		
		//gera o XML
		String xml = JAXBUtil.toXML(lista);
		
		//Escreve o XML na response do servlet com application/xml
		ServletUtil.writeXML(resp, xml);
	}*/
	
	/*@Override                                                //-------> para JSON <-------------
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Carro> carros = carroService.getCarros();
		ListaCarros lista = new ListaCarros();
		lista.setCarros(carros);
		
		//gera o JSON
		String json = JAXBUtil.toJSON(lista);
		
		//Escreve o JSON na response do servlet com application/json
		ServletUtil.writeJSON(resp, json);
	}*/
	
	@Override                                                 //-------> com o Gloogle Gson <-------------
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Carro> carros = carroService.getCarros();
		ListaCarros lista = new ListaCarros();
		lista.setCarros(carros);
		
		//gera o JSON
		Gson gson= new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(lista);
		
		//Escreve o JSON na response do servlet com application/json
		ServletUtil.writeJSON(resp, json);
	}
	
	/* 
	 * No Gson para fazer o contrario (de Json para Objeto) (no lado do cliente por exemplo é só fazer o seguinte:
	 * 
	 * Gson gson = new Gson();
	 * List<Carro> lista= (List<Carro>) gson.from/json(json, ListaCarros.class);
	 */
}
