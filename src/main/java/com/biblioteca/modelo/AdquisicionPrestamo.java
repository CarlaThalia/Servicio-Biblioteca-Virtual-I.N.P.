package com.biblioteca.modelo;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "adquisicion_prestamo")
public class AdquisicionPrestamo extends EntidadPadre implements Serializable {

	@Column(name = "fecha_entrega", nullable = true)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date fecha_entrega;
	@Column(name = "fecha_prestamo", nullable = true)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date fecha_prestamo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = true)
	private Adquisicion adquisicion; 
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = true)
	private UsuarioPrestamo usuarioPrestamo;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = true)
	private Bibliotecario bibliotecario;
	
	public AdquisicionPrestamo() {
	}

	public AdquisicionPrestamo(Date fecha_entrega, Date fecha_prestamo) {
		this.fecha_entrega = fecha_entrega;
		this.fecha_prestamo = fecha_prestamo;
	}

	public Date getFecha_entrega() {
		return fecha_entrega;
	}

	public void setFecha_entrega(Date fecha_entrega) {
		this.fecha_entrega = fecha_entrega;
	}

	public Date getFecha_prestamo() {
		return fecha_prestamo;
	}

	public void setFecha_prestamo(Date fecha_prestamo) {
		this.fecha_prestamo = fecha_prestamo;
	}
	@JsonIgnore
	public Adquisicion getAdquisicion() {
		return adquisicion;
	}
	@JsonProperty
	public void setAdquisicion(Adquisicion adquisicion) {
		this.adquisicion = adquisicion;
	}
	@JsonIgnore
	public UsuarioPrestamo getUsuarioPrestamo() {
		return usuarioPrestamo;
	}
	@JsonProperty
	public void setUsuarioPrestamo(UsuarioPrestamo usuarioPrestamo) {
		this.usuarioPrestamo = usuarioPrestamo;
	}
	@JsonIgnore
	public Bibliotecario getBibliotecario() {
		return bibliotecario;
	}
	@JsonProperty
	public void setBibliotecario(Bibliotecario bibliotecario) {
		this.bibliotecario = bibliotecario;
	}


}
