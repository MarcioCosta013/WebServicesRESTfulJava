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


@WebServlet("/carros/*")
public class CarrosServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CarroService carroService = new CarroService();
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Carro> carros = carroService.getCarros();
		String carroString = carros.toString();
		resp.getWriter().write(carroString);
	}
}
