package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="estudiante")
public class Estudiante {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO )
	@Column(nullable = false , unique = true)
	private int id;
	
	private String tipoDoc;
	private String numDoc;
	private String nombres;
	private String apellidos;
	private String grupo;
	private String telefono;
	private String email;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
	    this.id = id;
	}

	public String getTipoDoc() {
	    return tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
	    this.tipoDoc = tipoDoc;
	}


	public String getNumDoc() {
	    return numDoc;
	}

	public void setNumDoc(String numDoc) {
	    this.numDoc = numDoc;
	}

	public String getNombres() {
	    return nombres;
	}

	public void setNombres(String nombres) {
	    this.nombres = nombres;
	}

	public String getApellidos() {
	    return apellidos;
	}

	public void setApellidos(String apellidos) {
	    this.apellidos = apellidos;
	}

	public String getGrupo() {
	    return grupo;
	}

	public void setGrupo(String grupo) {
	    this.grupo = grupo;
	}

	public String getTelefono() {
	    return telefono;
	}

	public void setTelefono(String telefono) {
	    this.telefono = telefono;
	}

	public String getEmail() {
	    return email;
	}

	public void setEmail(String email) {
	    this.email = email;
	}
}
