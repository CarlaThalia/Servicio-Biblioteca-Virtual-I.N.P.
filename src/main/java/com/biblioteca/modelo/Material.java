package com.biblioteca.modelo;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "material")
public class Material extends EntidadPadre implements Serializable {

	@Column(name = "nombre", length = 80, nullable = false) 
	private String nombre;
	@Column(name = "descripcion", length = 80, nullable = true) 
	private String descripcion;

	@OneToMany(mappedBy = "material", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Ejemplar> ejemplar;
	
	public Material(String nombre, String descripcion) {	
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	public Material() {
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
	
	@JsonIgnore
	public List<Ejemplar> getEjemplar() {
		return ejemplar;
	}
	public void setEjemplar(List<Ejemplar> ejemplar) {
		this.ejemplar = ejemplar;
	}
}
