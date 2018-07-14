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
/**
 * Las entidades se trabajan en los repositorios
 * @author Daniel
 *
 */
@Entity
@Table(name = "bibliotecario")
public class Bibliotecario extends EntidadPadre implements Serializable {
	
	@Column(name = "nombre") // nombre de la columna de la propiedad título
	private String nombre;
	@Column(name = "apellido")
	private String apellido;
	@Column(name = "cedula")
	private String cedula;
	@Column(name = "direccion")
	private String direccion;
	@Column(name = "telefono")
	private String telefono;
	@Column(name = "correo")
	private String correo;
	
	@OneToMany(mappedBy = "bibliotecario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<AdquisicionPrestamo> adquisicionPrestamo;
	
	/**
	 * constructor vacío que utiliza Hibernate para poder acceder
	 */
	public Bibliotecario() {}
	public Bibliotecario(String nombre, String apellido, String cedula, String direccion, String telefono,
			String correo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	@JsonIgnore
	public List<AdquisicionPrestamo> getAdquisicionPrestamo() {
		return adquisicionPrestamo;
	}
	public void setAdquisicionPrestamo(List<AdquisicionPrestamo> adquisicionPrestamo) {
		this.adquisicionPrestamo = adquisicionPrestamo;
	}
}
