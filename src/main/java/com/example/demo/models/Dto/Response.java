package com.example.demo.models.Dto;

public class Response<T> {
	private String Mensaje;
	private T Entity;
	
	public Response(String mensaje, T entity) {
		Mensaje = mensaje;
		Entity = entity;
	}
	
	public Response(String mensaje) {
		Mensaje = mensaje;
	}
	
	public String getMensaje() {
		return Mensaje;
	}
	public void setMensaje(String mensaje) {
		Mensaje = mensaje;
	}
	public T getEntity() {
		return Entity;
	}
	public void setEntity(T entity) {
		Entity = entity;
	}
	
}
