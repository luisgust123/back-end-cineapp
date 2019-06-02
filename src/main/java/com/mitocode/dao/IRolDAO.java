package com.mitocode.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.model.Rol;

public interface IRolDAO  extends JpaRepository<Rol, Integer> {

}
