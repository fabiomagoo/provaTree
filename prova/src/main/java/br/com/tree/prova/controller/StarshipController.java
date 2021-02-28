package br.com.tree.prova.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.tree.prova.exception.ResourceNotFoundException;
import br.com.tree.prova.model.Starship;
import br.com.tree.prova.model.StarshipResults;
import br.com.tree.prova.vo.ParadaViagem;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/nave")
@Api(value = "Nave")
public class StarshipController {

	@Autowired
	private RestTemplate restTemplate;	
	
	@ApiOperation(value = "Retorna uma nave")
	@GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <Starship> get(@RequestParam(required = true) Integer id) {
		
		final String url =  "https://swapi.dev/api/starships/%d/";
		Starship starship = Optional.of( restTemplate.getForObject( String.format(url, id), Starship.class) )
				.orElseThrow(() -> new ResourceNotFoundException( String.format("Starship com id %d nao encontrado", id)) );
			
		return ResponseEntity.ok(starship);
	}
	
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@ApiOperation(value = "Calcula a quantidade de paradas por nave")
	@GetMapping(value = "/calculaParadasPorNave", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> calculaParadasPorNave(@RequestParam(required = true) BigDecimal distancia, @RequestParam(required = false) boolean parteAbastecido) {
		final String url =  "https://swapi.dev/api/starships/";
		StarshipResults results = restTemplate.getForObject( String.format(url), StarshipResults.class);
		List<String> lista = new ArrayList<String>();
		
		for (Starship s : results.getStarshipList()) {
			BigDecimal qtd = distancia.divide(s.getMglt(), parteAbastecido? RoundingMode.DOWN: RoundingMode.UP);
			
			lista.add( new ParadaViagem( s.getName(), s.getMglt(), qtd ).toString() );
		}

		return lista;
	}
}
