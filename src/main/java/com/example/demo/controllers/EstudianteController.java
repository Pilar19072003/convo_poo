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

import com.example.demo.models.Estudiante;
import com.example.demo.models.Dto.RequestEstudiante;
import com.example.demo.models.Dto.Response;
import com.example.demo.services.EstudianteService;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {
	
	@Autowired
	private EstudianteService estudianteService;
	
	@GetMapping
	public ResponseEntity<Object> getAll(){
		return ResponseEntity.ok(estudianteService.getall());
	}
	
	@PostMapping
	public ResponseEntity<Estudiante> save(@RequestBody RequestEstudiante estudiante){
		return ResponseEntity.ok(estudianteService.save(estudiante));
	}
	
	@PutMapping
	public ResponseEntity<Object> update(@RequestBody Estudiante estudiante){
		var actualizarEstudiante = estudianteService.update(estudiante);
		
		if(actualizarEstudiante == null) {
			return ResponseEntity.ok(new Response <>("Estudiante no existe", actualizarEstudiante));
		}else {
			return ResponseEntity.ok(new Response <>("Estudiante Actualizado", actualizarEstudiante.getId()));			
		}
		
	}
	@DeleteMapping("/{Id}")
	public ResponseEntity<Object> delete(@PathVariable ("Id") int Id){
		
		if (estudianteService.delete(Id)) {
			return ResponseEntity.ok(new Response<>("Estudiante Eliminado"));
		}else {
			return ResponseEntity.ok(new Response<>("Estudiante No fue eliminado"));
		}
	}
	
	
}
