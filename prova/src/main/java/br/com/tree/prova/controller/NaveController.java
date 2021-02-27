package br.com.tree.prova.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.tree.prova.model.Nave;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/nave")
@Api(value = "Nave")
public class NaveController {

  @ApiOperation(value = "Greets the world or Niteroi")
  @GetMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
  public Nave hello(@RequestParam(required = false) boolean niteroi) {
    Nave greeting = new Nave("falcon", "f-50", 3);
    return greeting;
  }

  @ApiOperation(value = "Greets a person given her name")
  @GetMapping(value = "/hello/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Nave get(@PathVariable String name) {
    return new Nave();
  }
}
