package com.anfic.rest.app_proyectos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anfic.rest.app_proyectos.domain.Usuario;
import com.anfic.rest.app_proyectos.repositories.UsuarioRepository;

import jakarta.transaction.Transactional;
@Service
public class UsuarioServiceImp implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuRep;

	@Override
	@Transactional
	public List<Usuario> listarTodos() {		
		return usuRep.findAll();
	}

	@Override
	@Transactional
	public Usuario buscarPorId(Long id) {
		Optional<Usuario> usuario=usuRep.findById(id);
		return usuario.get();
	}

	@Override
	@Transactional
	public Usuario grabar(Usuario usuario) {
		return usuRep.save(usuario);
	}

	@Override
	@Transactional
	public Usuario actualizar(Usuario usuario, long id) {
		usuario.setId(id);
		return usuRep.save(usuario);
	}

	@Override
	@Transactional
	public void eliminar(Long id) {
		usuRep.deleteById(id);
	}

	@Override
	@Transactional
	public Usuario findByEmail(String email) {
		Optional<Usuario> usu=usuRep.findByEmail(email);
		return usu.get();
	}

	@Override
	public Usuario findByRol(String rol) {
		Optional<Usuario> usu=usuRep.findByRol(rol);
		return usu.get();
	}

}
