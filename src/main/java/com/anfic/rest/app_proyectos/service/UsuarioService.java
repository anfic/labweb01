package com.anfic.rest.app_proyectos.service;

import java.util.List;

import com.anfic.rest.app_proyectos.domain.Usuario;



public interface UsuarioService {
	List<Usuario> listarTodos();
	Usuario buscarPorId(Long id);
	Usuario grabar(Usuario usuario);
	Usuario actualizar(Usuario usuario, long id);
	void eliminar(Long id);
	Usuario findByEmail(String email);
	Usuario findByRol(String rol);
}
