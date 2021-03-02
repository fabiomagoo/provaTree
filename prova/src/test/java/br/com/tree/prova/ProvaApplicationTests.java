package br.com.tree.prova;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import br.com.tree.prova.model.Starship;

@SpringBootTest
class ProvaApplicationTests {

	@Autowired
    private RestTemplate restTemplate;

	@Test
	void encontraDeathStar() throws Exception {
	
		Starship starship = restTemplate.getForObject("http://localhost:8080/nave/get?id=9", Starship.class);
		assertEquals( starship.getModel(), ("DS-1 Orbital Battle Station"));
                                  
	}
	
	@Test
	void calculaQuantidadeParadas() throws Exception {
	
		String resultado = restTemplate.getForObject("http://localhost:8080/nave/calculaParadasPorNave?distancia=400", String.class);
		assertTrue( resultado.contains("Sentinel-class landing craft: 6 paradas"));
                                  
	}
	
	@Test
	void retornaMelhorNaveParaViagem() throws Exception {
	
		String resultado = restTemplate.getForObject("http://localhost:8080/nave/melhorNavePraTransporte?distancia=400&qtdPassageiros=50", String.class);
		assertEquals( resultado, ("Sentinel-class landing craft: é a melhor opção pois leva 75 passageiros, percorrendo 70 de distância por parada"));

                                  
	}
	
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

}
