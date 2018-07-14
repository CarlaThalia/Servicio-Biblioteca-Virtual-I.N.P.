package com.biblioteca.modelo;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "autor")
public class Autor extends EntidadPadre implements Serializable {

	@Column(name = "nombre", nullable = false) 
	private String nombre;
	@Column(name = "nacionalidad", nullable = true, length = 60)
	private String nacionalidad;
	@Column(name = "fecha_nacimiento", nullable = true)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date fecha_nacimiento;
	
	@OneToMany(mappedBy = "autor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//@JsonManagedReference
	private List<Ejemplar> ejemplar;
	
	public Autor() {
	}
	
	public Autor(String nombre, String nacionalidad, Date fecha_nacimiento) {
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
	@JsonIgnore
	public List<Ejemplar> getEjemplar() {
		return ejemplar;
	}
	public void setEjemplar(List<Ejemplar> ejemplar) {
		this.ejemplar = ejemplar;
	}
}
