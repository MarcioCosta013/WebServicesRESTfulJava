package test;

import java.util.List;

import br.com.livro.domain.Carro;
import br.com.livro.domain.CarroService;
import junit.framework.TestCase;

public class CarroTest extends TestCase {
	
	private CarroService carroService = new CarroService();
	
	public void testListaCarros() {
		List<Carro> carros = carroService.getCarros();
		assertNotNull(carros);
		
		//Valida se entrou algo
		assertTrue(carros.size() > 0);
		
		//Valida se encontrou o Tucker
		Carro tucker = carroService.findByName("Tucker 1948").get(0);
		assertEquals("Tucker 1948", tucker.getNome());
		
		//Valida se encontrou a Ferrari
		Carro ferrari = carroService.findByName("Ferrari FF").get(0);
		assertEquals("Ferrari FF", ferrari.getNome());
		
		//Valida se encontrou o Bugatti
		Carro bugatti = carroService.findByName("Bugatti Veyron").get(0);
		assertEquals("Bugatti Veyron", bugatti.getNome());
	}
	
	/*public void testSalvarDeletarCarro() {
		Carro c = new Carro();
		c.setNome("Teste");
		c.setDesc("Teste desc");
		c.setUrlFoto("url foto aqui");
		c.setUrlVideo("url video aqui");
		c.setLatitude("lat");
		c.setLongitude("lng");
		c.setTipo("tipo");
		
		assertNull(c.getId()); //testando se o id é nulo mesmo...
		
		carroService.save(c);
		
		assertNotNull(c.getId());
		
		//id do carro salvo
		Long id = c.getId();
		
		
		//Busca no banco de dados para confirmar que o carro foi salvo
		c = carroService.getCarro(id);
		assertEquals("Teste", c.getNome());
		assertEquals("Teste desc", c.getDesc());
		assertEquals("url foto aqui", c.getUrlFoto());
		assertEquals("url video aqui", c.getUrlVideo());
		assertEquals("lat", c.getLatitude());
		assertEquals("lng", c.getLongitude());
		assertEquals("tipo", c.getTipo());
		
		//Atualiza o carro
		c.setNome("Teste UPDATE");
		carroService.save(c);
		
		//Busca o carro novamente (vai estar atualizado)
		c = carroService.getCarro(id);
		assertEquals("Teste UPDATE", c.getNome());
		
		//Deleta o carro
		carroService.delete(id);
		
		//Busca o carro novamente
		c = carroService.getCarro(id);
		
		//Desta vez o carro não existe mais.
		assertNotNull(c);
	}*/
	
	public void testSalvarDeletarCarro() {
	    Carro c = new Carro();
	    c.setNome("Teste");
	    c.setDesc("Teste desc");
	    c.setUrlFoto("url foto aqui");
	    c.setUrlVideo("url video aqui");
	    c.setLatitude("lat");
	    c.setLongitude("lng");
	    c.setTipo("tipo");

	    // Antes de salvar, verifique se o ID é nulo
	    assertNull(c.getId());

	    carroService.save(c);

	    // Após salvar, verifique se o ID não é nulo
	    assertNotNull(c.getId());

	    // id do carro salvo
	    Long id = c.getId();
	    
	    // Busca no banco de dados para confirmar que o carro foi salvo
	    c = carroService.getCarro(id);
	    assertNotNull(c);
	    assertEquals("Teste", c.getNome());

	    // Atualiza o carro
	    c.setNome("Teste UPDATE");
	    carroService.save(c);

	    // Busca o carro novamente (vai estar atualizado)
	    c = carroService.getCarro(id);
	    assertEquals("Teste UPDATE", c.getNome());

	    // Deleta o carro
	    carroService.delete(id);

	    // Busca o carro novamente
	    c = carroService.getCarro(id);

	    // Desta vez o carro não existe mais.
	    assertNull(c);
	}
}
