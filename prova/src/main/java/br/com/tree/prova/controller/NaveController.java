package br.com.tree.prova.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;

import br.com.tree.prova.GetRequestRepository;
import br.com.tree.prova.exception.ResourceNotFoundException;
import br.com.tree.prova.model.Nave;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/nave")
@Api(value = "Nave")
public class NaveController {

	private final String url =  "starships/";
	private GetRequestRepository restRequest = new GetRequestRepository();
	
	@ApiOperation(value = "Retorna uma nave")
	@GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
	public String get(@RequestParam(required = true) Integer id) {
		try{
			JsonObject result = restRequest.getAll(url + id + "/");
			return result.toString();
			
		}catch (Exception e) {
			throw new ResourceNotFoundException( e.getMessage() );
		}
	}

	@ApiOperation(value = "Greets a person given her name")
	@GetMapping(value = "/hello/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Nave get(@PathVariable String name) {
		return new Nave();
	}
}
