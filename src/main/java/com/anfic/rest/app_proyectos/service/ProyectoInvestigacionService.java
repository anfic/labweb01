package com.anfic.rest.app_proyectos.service;

import java.util.List;

import com.anfic.rest.app_proyectos.domain.ProyectoInvestigacion;

public interface ProyectoInvestigacionService {
	List<ProyectoInvestigacion> listarTodos();
	ProyectoInvestigacion buscarPorId(Long id);
	ProyectoInvestigacion grabar(ProyectoInvestigacion proyInvest);
	
}
