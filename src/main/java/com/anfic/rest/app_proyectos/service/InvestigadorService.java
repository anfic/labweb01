package com.anfic.rest.app_proyectos.service;

import java.util.List;

import com.anfic.rest.app_proyectos.domain.Investigador;
import com.anfic.rest.app_proyectos.exception.EntityNotFoundException;
import com.anfic.rest.app_proyectos.exception.IllegalOperationException;

public interface InvestigadorService {
	List<Investigador> listartodos();
	Investigador buscarPorId(Long id);
	Investigador grabar(Investigador investigador) throws IllegalOperationException;
	Investigador actualizar(Investigador investigador, long id) throws EntityNotFoundException, IllegalOperationException;
	void eliminar(Long id)throws EntityNotFoundException, IllegalOperationException;
	Investigador findByDni(String dni);
	Investigador findByEmail(String email);
}
