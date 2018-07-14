package com.biblioteca.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "adquisicion")
public class Adquisicion extends EntidadPadre implements Serializable {

	private static final long serialVersionUID = -7481066994250226014L;
	@Column(name = "cod_adquisicion", nullable = false)
	private String codAdquisicion;
	@Column(name = "numero_ejemplar", nullable = false)
	private Number numeroEjemplar;
	@Column(name = "volumen", nullable = false)
	private String volumen;
	@Column(name = "ubicacion", nullable = false)
	private String ubicacion;
	@Column(name = "cod_accesibilidad", nullable = false)
	private Integer codAccesibilidad;
	@Column(name = "estado", nullable = false)
	private String estado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = true)
	private Ficha ficha;
	
	@OneToMany(mappedBy = "adquisicion", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<AdquisicionPrestamo> adquisicionPrestamo;
		
	public Adquisicion() {
	}

	public Adquisicion(String cod_adquisicion, Number numero_ejemplar, String volumen, String estado, String ubicacion,
			Integer cod_accesibilidad) {
		this.codAdquisicion = cod_adquisicion;
		this.numeroEjemplar = numero_ejemplar;
		this.volumen = volumen;
		this.estado = estado;
		this.ubicacion = ubicacion;
		this.codAccesibilidad = cod_accesibilidad;
	}

	public String getCod_adquisicion() {
		return codAdquisicion;
	}

	public void setCod_adquisicion(String cod_adquisicion) {
		this.codAdquisicion = cod_adquisicion;
	}

	public Number getNumero_ejemplar() {
		return numeroEjemplar;
	}

	public void setNumero_ejemplar(Number numero_ejemplar) {
		this.numeroEjemplar = numero_ejemplar;
	}

	public String getVolumen() {
		return volumen;
	}

	public void setVolumen(String volumen) {
		this.volumen = volumen;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Integer getCod_accesibilidad() {
		return codAccesibilidad;
	}

	public void setCod_accesibilidad(Integer cod_accesibilidad) {
		this.codAccesibilidad = cod_accesibilidad;
	}

	@JsonIgnore
	public Ficha getFicha() {
		return ficha;
	}

	@JsonProperty
	public void setFicha(Ficha ficha) {
		this.ficha = ficha;
	}
	@JsonIgnore
	public List<AdquisicionPrestamo> getAdquisicionPrestamo() {
		return adquisicionPrestamo;
	}
	
	public void setAdquisicionPrestamo(List<AdquisicionPrestamo> adquisicionPrestamo) {
		this.adquisicionPrestamo = adquisicionPrestamo;
	}
	
	
}
