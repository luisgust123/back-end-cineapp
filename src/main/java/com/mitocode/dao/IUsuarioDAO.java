package com.mitocode.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mitocode.model.Usuario;

public interface IUsuarioDAO extends JpaRepository<Usuario, Integer> {
			
	Usuario findOneByUsername(String username);
		
	@Modifying
	@Query(value = "INSERT INTO usuario_rol (id_usuario, id_rol) VALUES (:idUsuario, :idRol)", nativeQuery = true)
	void registrarRolPorDefecto(@Param("idUsuario") Integer idUsuario, @Param("idRol") Integer idRol);

	@Modifying
	@Query(value = "SELECT usuario.id_usuario, usuario.nombre, rol.id_rol,rol.nombre  FROM rol \r\n" + 
			"inner join usuario_rol on rol.id_rol = usuario_rol.id_rol\r\n" + 
			"INNER join usuario on usuario.id_usuario = usuario_rol.id_usuario\r\n" + 
			"where usuario.id_usuario = :idUsuario", nativeQuery = true)
	void ListarRolesUsuario(@Param("idUsuario") Integer idUsuario);

	
	@Modifying
	@Query(value = "DELETE FROM usuario_rol where id_usuario = :idUsuario ", nativeQuery = true)
	void EliminarRolUsuario(@Param("idUsuario") Integer idUsuario);
	

}