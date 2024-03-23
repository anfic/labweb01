package com.anfic.rest.app_proyectos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anfic.rest.app_proyectos.domain.Usuario;
import com.anfic.rest.app_proyectos.service.UsuarioService;


@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioService ususervice;
	@GetMapping
	public List<Usuario> listarUsuario(){
		return ususervice.listarTodos();
	}
	@GetMapping("/{id}")
	public Usuario listarPorId(@PathVariable Long id) {
		return ususervice.buscarPorId(id);
	}
	@PostMapping
	public Usuario crearusuario(@RequestBody Usuario usuario) {
		return ususervice.grabar(usuario);		
	}
	@PutMapping("/{id}")
	public Usuario editarUsuario(@PathVariable Long id,@RequestBody Usuario usuario) {
		Usuario usuBD=ususervice.buscarPorId(id);
		usuBD.setEmail(usuario.getEmail());
		usuBD.setPassword(usuario.getPassword());
		usuBD.setRol(usuario.getRol());
		return ususervice.actualizar(usuario, id);
	}
	@DeleteMapping("/{id}")
	public void eliminarUsuario(@PathVariable Long id) {
		ususervice.eliminar(id);
	}

}
