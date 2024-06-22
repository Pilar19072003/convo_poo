package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Estudiante;
import com.example.demo.models.Dto.RequestEstudiante;
import com.example.demo.models.Dto.Response;
import com.example.demo.repositories.EstudianteRepository;

@Service
public class EstudianteService {
	
	@Autowired
	private EstudianteRepository estudianteRepository;
	
	public Response<Object> getall(){		
		return new Response<>("Listado de estudiantes", (List<Estudiante>) estudianteRepository.findAll());
	}
	
	public Estudiante save(RequestEstudiante estudiante) {
		
		return estudianteRepository.save(mapperEstudiante(estudiante));
		
	}
	
	public Estudiante update(Estudiante estudiante) {
		
		var existeEstudiante = estudianteRepository.findById(estudiante.getId());
		
		if (!existeEstudiante.isEmpty()) {			
			return estudianteRepository.save(estudiante);
		}else {
			return null; 
		}
	}
	
	public boolean delete(int Id) {
		
		try {
			return estudianteRepository.existsById(Id) ? eliminarEstudiante(Id) : false;
		}catch(Exception ex) {
			return false;
		}
		
	}
	
	private boolean eliminarEstudiante(int Id) {
		estudianteRepository.deleteById(Id);
	    return true;
	}
	
	private Estudiante mapperEstudiante(RequestEstudiante estudiante) {
		
		Estudiante est = new Estudiante();
		est.setApellidos(estudiante.getApellidos());
		est.setEmail(estudiante.getEmail());
		est.setGrupo(estudiante.getGrupo());
		est.setNombres(estudiante.getNombres());
		est.setTipoDoc(estudiante.getTipoDoc());
		est.setNumDoc(estudiante.getNumDoc());
		est.setTelefono(estudiante.getTelefono());
		est.setId(0);
		
		return est;
	}
	
}
