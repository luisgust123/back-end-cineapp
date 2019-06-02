package com.mitocode.service;

import java.util.List;

import com.mitocode.model.Menu;
import com.mitocode.model.Usuario;

public interface IMenuService extends ICRUD<Menu>{
	
	List<Menu> listarMenuPorUsuario(String nombre);
	
	public void modificarMenuRoles(Menu us);
	
}
