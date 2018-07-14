package com.biblioteca.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * Las entidades se trabajan en los repositorios
 * @author Daniel
 *
 */
@Entity
@Table(name = "usuario_prestamo")
public class UsuarioPrestamo extends EntidadPadre implements Serializable {
	
	@Column(name = "nombre", nullable = false) 
	private String nombre;
	@Column(name = "cedula", nullable = false)
	private String cedula;
	@Column(name = "direccion", nullable = true)
	private String direccion;
	@Column(name = "telefono", nullable = true)
	private String telefono;
	@Column(name = "correo", nullable = true)
	private String correo;
	
	
	@OneToMany(mappedBy = "usuarioPrestamo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<AdquisicionPrestamo> adquisicionPrestamo;

	/**
	 * constructor vacío que utiliza Hibernate para poder acceder
	 */
	public UsuarioPrestamo() {}
	public UsuarioPrestamo(String nombre, String cedula, String direccion, String telefono,
			String correo, String tipo_usuario) {
		this.nombre = nombre;
		this.cedula = cedula;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
	}
	@JsonIgnore
	public List<AdquisicionPrestamo> getAdquisicionPrestamo() {
		return adquisicionPrestamo;
	}
	public void setAdquisicionPrestamo(List<AdquisicionPrestamo> adquisicionPrestamo) {
		this.adquisicionPrestamo = adquisicionPrestamo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
}
