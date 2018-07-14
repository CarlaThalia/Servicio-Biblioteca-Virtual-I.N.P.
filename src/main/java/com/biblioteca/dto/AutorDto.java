package com.biblioteca.dto;

import java.sql.Date;
import java.util.List;

import com.biblioteca.modelo.Autor;
import com.biblioteca.modelo.Ejemplar;

public class AutorDto {

	private Long id;
	private String nombre;
	private String nacionalidad;
	private Date fecha_nacimiento;

	private List<Ejemplar> ejemplares;

	public AutorDto() {
	}
	
	public AutorDto(Autor autor) {
		this.id = autor.getId();
		this.nombre = autor.getNombre();
		this.nacionalidad = autor.getNacionalidad();
		this.fecha_nacimiento = autor.getFecha_nacimiento();
		this.ejemplares = autor.getEjemplar();
	}
	
	public AutorDto(Autor autor, List<Ejemplar> ejemplares) {
		this.id = autor.getId();
		this.nombre = autor.getNombre();
		this.nacionalidad = autor.getNacionalidad();
		this.fecha_nacimiento = autor.getFecha_nacimiento();
		this.ejemplares = ejemplares;
	}

	public AutorDto(String nombre, String nacionalidad, Date fecha_nacimiento) {
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public List<Ejemplar> getEjemplares() {
		return ejemplares;
	}

	public void setEjemplares(List<Ejemplar> ejemplares) {
		this.ejemplares = ejemplares;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}