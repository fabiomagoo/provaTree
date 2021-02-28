package br.com.tree.prova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.tree.prova.exception.ResourceNotFoundException;
import br.com.tree.prova.model.Nave;
import br.com.tree.prova.model.Starship;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/nave")
@Api(value = "Nave")
public class NaveController {

	@Autowired
	private RestTemplate restTemplate;
	
	private final String url =  "https://swapi.dev/api/starships/";	
	
	@ApiOperation(value = "Retorna uma nave")
	@GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
	public Starship get(@RequestParam(required = true) Integer id) {
		try{
			Starship starship = restTemplate.getForObject(url + id + "/", Starship.class);
			
			return starship;
		}catch (Exception e) {
			throw new ResourceNotFoundException( e.getMessage() );
		}
	}
	
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@ApiOperation(value = "Greets a person given her name")
	@GetMapping(value = "/hello/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Nave get(@PathVariable String name) {
		return new Nave();
	}
}
