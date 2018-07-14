package com.biblioteca.dto;

import java.util.List;

import com.biblioteca.modelo.Adquisicion;
import com.biblioteca.modelo.AdquisicionPrestamo;
import com.biblioteca.modelo.Ficha;

public class AdquisicionDto {

	private Long id;
	private String cod_adquisicion;
	private Number numero_ejemplar;
	private String volumen;
	private String ubicacion;
	private Integer cod_accesibilidad;
	

	private FichaDto ficha;

	public AdquisicionDto() {
	}

	public AdquisicionDto(Adquisicion adquisicion) {
		this.id = adquisicion.getId();
		this.cod_adquisicion = adquisicion.getCod_adquisicion();
		this.numero_ejemplar = adquisicion.getNumero_ejemplar();
		this.volumen = adquisicion.getVolumen();
		this.ubicacion = adquisicion.getUbicacion();
		this.cod_accesibilidad = adquisicion.getCod_accesibilidad();
		this.ficha = new FichaDto(adquisicion.getFicha());
	}

	public AdquisicionDto(Long id, String cod_adquisicion, Number numero_ejemplar, String volumen,
			String ubicacion, Integer cod_accesibilidad) {
		this.id = id;
		this.cod_adquisicion = cod_adquisicion;
		this.numero_ejemplar = numero_ejemplar;
		this.volumen = volumen;
		this.ubicacion = ubicacion;
		this.cod_accesibilidad = cod_accesibilidad;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCod_adquisicion() {
		return cod_adquisicion;
	}

	public void setCod_adquisicion(String cod_adquisicion) {
		this.cod_adquisicion = cod_adquisicion;
	}

	public Number getNumero_ejemplar() {
		return numero_ejemplar;
	}

	public void setNumero_ejemplar(Number numero_ejemplar) {
		this.numero_ejemplar = numero_ejemplar;
	}

	public String getVolumen() {
		return volumen;
	}

	public void setVolumen(String volumen) {
		this.volumen = volumen;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Integer getCod_accesibilidad() {
		return cod_accesibilidad;
	}

	public void setCod_accesibilidad(Integer cod_accesibilidad) {
		this.cod_accesibilidad = cod_accesibilidad;
	}

	public FichaDto getFicha() {
		return ficha;
	}

	public void setFicha(FichaDto ficha) {
		this.ficha = ficha;
	}
}
