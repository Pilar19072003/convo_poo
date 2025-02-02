package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Docente;
import com.example.demo.models.Dto.RequestDocente;
import com.example.demo.models.Dto.Response;
import com.example.demo.services.DocenteService;

@RestController
@RequestMapping("/docente")
public class DocenteController {

	@Autowired
	private DocenteService docenteService;

	@GetMapping
	public ResponseEntity<Object> getAll() {
		return ResponseEntity.ok(docenteService.getall());
	}

	@PostMapping
	public ResponseEntity<Object> save(@RequestBody RequestDocente docente) {

		var postDocente = docenteService.save(docente);
		if (postDocente == null) {
			return ResponseEntity.ok(new Response<>("Docente ya existe"));
		} else {
			return ResponseEntity.ok(new Response<>("Docente creado", postDocente));
		}

	}

	@PutMapping
	public ResponseEntity<Object> update(@RequestBody  Docente docente) {
		
		Docente actualizarDocente = docenteService.update(docente);
		if (actualizarDocente == null) {
			return ResponseEntity.notFound().build();
		}	
		else {
			return ResponseEntity.ok(new Response<>("Docente Actualizado", actualizarDocente));
		}
		
	}

	@DeleteMapping("/{Id}")
	public ResponseEntity<Object> delete(@PathVariable("Id") int Id) {
		if (docenteService.delete(Id)) {

			return ResponseEntity.ok(new Response<>("Docente Eliminado"));
		} else {
			return ResponseEntity.ok(new Response<>("Docente Ya se encuentra eliminado o no existe."));

		}
	}

}
