package com.mitocode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.model.Menu;
import com.mitocode.model.Rol;
import com.mitocode.service.IRolService;

@RestController
@RequestMapping("/roles")

public class RolController {
	
	@Autowired
	private IRolService service;
	
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Rol>  lista( ) {
		return service.listar();
	}
	
	
	@GetMapping( value = "/{id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public Rol listaId(@PathVariable("id") Integer id ) {
		return service.leer(id);
	}
	
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Rol registrar(@RequestBody Rol rol ) {
		return service.registrar(rol);
	}
	
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Rol modificar(@RequestBody Rol rol ) {
		return service.modificar(rol);
	}
	

	@DeleteMapping( value = "/{id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public void eliminar(@PathVariable("id") Integer id  ) {
		 service.eliminar(id);
	}

}
