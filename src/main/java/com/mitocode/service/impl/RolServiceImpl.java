package com.mitocode.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.dao.IRolDAO;
import com.mitocode.model.Rol;
import com.mitocode.service.IRolService;

@Service
public class RolServiceImpl implements IRolService {
	
	@Autowired
	private IRolDAO dao;

	@Override
	public Rol registrar(Rol obj) {
		return dao.save(obj);
	}

	@Override
	public Rol modificar(Rol obj) {
		return dao.save(obj);
	}

	@Override
	public List<Rol> listar() {
		return dao.findAll();
	}

	@Override
	public Rol leer(Integer id) {
		Optional<Rol> op = dao.findById(id);
		return op.isPresent() ? op.get() : new Rol();
	}

	@Override
	public void eliminar(Integer id) {
		dao.deleteById(id);
	}
	
	

}
