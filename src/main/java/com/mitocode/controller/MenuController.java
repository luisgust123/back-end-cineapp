package com.mitocode.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.model.Menu;
import com.mitocode.model.Pelicula;
import com.mitocode.service.IMenuService;

@RestController
@RequestMapping("/menus")
public class MenuController {
	
	@Autowired
	private IMenuService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Menu>> listar() {
		List<Menu> menues = new ArrayList<>();
		menues = service.listar();
		return new ResponseEntity<List<Menu>>(menues, HttpStatus.OK);
	}
	
	
	@GetMapping( value = "/{id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public Menu listaId(@PathVariable("id") Integer id ) {
		return service.leer(id);
	}
	
	
	@PostMapping
	public Menu registrar(@RequestBody Menu menu ) {
		return service.registrar(menu);
	}
	
	@PutMapping
	public Menu modificar(@RequestBody Menu menu ) {
		return service.modificar(menu);
	}
	
	
	@DeleteMapping( value = "/{id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public void eliminar(@PathVariable("id") Integer id) {
		 service.eliminar(id);
	}
	
	@PostMapping(value = "/usuario", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Menu>> listar(@RequestBody String nombre) {
		List<Menu> menues = new ArrayList<>();
		menues = service.listarMenuPorUsuario(nombre);
		return new ResponseEntity<List<Menu>>(menues, HttpStatus.OK);
	}
	
	
	@PutMapping(value = "menu-rol" )
	public void asignaMenuRol(@RequestBody Menu menu ) {
		 service.modificarMenuRoles(menu);
	}
	
	
	
}
