package com.anfic.rest.app_proyectos.domain;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
public class AvanceProyecto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idAvance;
	private String descripcionAvance;
	@Temporal(TemporalType.DATE)
	private Date fechaRegistroAvance;
	private String estadoAv;
	private float presupuestoAsignado;
	private float presupuestogastado;
	@ManyToOne()
	private ProyectoInvestigacion proyecto;
}
