package com.anfic.rest.app_proyectos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anfic.rest.app_proyectos.domain.Investigador;
import com.anfic.rest.app_proyectos.exception.EntityNotFoundException;
import com.anfic.rest.app_proyectos.exception.IllegalOperationException;
import com.anfic.rest.app_proyectos.service.InvestigadorService;

@RestController
@RequestMapping("/api/v1/investigadores")
public class InvestigadorController {
	@Autowired
	private InvestigadorService investigadorService;

	@GetMapping
	public List<Investigador> listarInvestigadores() {
		return investigadorService.listartodos();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> listarPorId(@PathVariable Long id) {
		Optional<Investigador> invOptional = Optional.ofNullable(investigadorService.buscarPorId(id));
		if (invOptional.isPresent()) {
			return ResponseEntity.ok(invOptional.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<?> crearInvestigador(@RequestBody Investigador investigador)
			throws IllegalOperationException {
		return ResponseEntity.status(HttpStatus.CREATED).body(investigadorService.grabar(investigador));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> editarInvestigador(@PathVariable Long id, @RequestBody Investigador investigador)
			throws IllegalOperationException {
		Optional<Investigador> o = Optional.ofNullable(investigadorService.buscarPorId(id));
		if (o.isPresent()) {
			Investigador invDB = o.get();
			invDB.setApePat(investigador.getApePat());
			invDB.setApeMat(investigador.getApeMat());
			invDB.setEmail(investigador.getEmail());
			invDB.setDni(investigador.getDni());
			invDB.setFechaReg(investigador.getFechaReg());
			invDB.setNombres(investigador.getNombres());

			return ResponseEntity.status(HttpStatus.CREATED).body(investigadorService.grabar(invDB));

		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarInvestigador(@PathVariable Long id)
			throws EntityNotFoundException, IllegalOperationException {
		Optional<Investigador> o = Optional.of(investigadorService.buscarPorId(id));
		if (o.isPresent()) {
			investigadorService.eliminar(id);
			return ResponseEntity.noContent().build();

		}
		return ResponseEntity.notFound().build();
	}

}
