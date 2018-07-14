package com.biblioteca.dto;

import java.util.List;

import com.biblioteca.modelo.Ejemplar;
import com.biblioteca.modelo.Material;

public class MaterialDto {

	private Long id;
	private String nombre;
	private String descripcion;

	private List<Ejemplar> ejemplares;
	
	public MaterialDto() {
	}

	public MaterialDto(Material material) {
		this.id = material.getId();
		this.nombre = material.getNombre();
		this.descripcion = material.getDescripcion();
	}
	
	public MaterialDto(Long id, String nombre, String descripcion) {	
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public List<Ejemplar> getEjemplares() {
		return ejemplares;
	}
	public void setEjemplares(List<Ejemplar> ejemplares) {
		this.ejemplares = ejemplares;
	}
	
}
