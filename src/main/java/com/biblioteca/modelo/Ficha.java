package com.biblioteca.modelo;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Null;

import com.biblioteca.dto.FichaDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ficha")
public class Ficha extends EntidadPadre implements Serializable {

	@Column(name = "primera_fecha", nullable = false)
	@JsonFormat(pattern = "yyyy")
	private Date primera_fecha;
	@Column(name = "segunda_fecha", nullable = false)
	@JsonFormat(pattern = "yyyy")
	private Date segunda_fecha;
	@Column(name = "codigo_lengua", nullable = false)
	private String codigo_lengua;
	@Column(name = "codigo_ilustracion", nullable = false)
	private String codigo_ilustracion;
	@Column(name = "lugar_publicacion", nullable = false)
	private String lugar_publicacion;
	
	@Column(name = "nivel_intelectual", nullable = true)
	private String nivel_intelectual;
	@Column(name = "indicador_indice", nullable = true)
	private String indicador_indice;
	@Column(name = "estado_registro", nullable = true)
	private String estado_registro;
	@Column(name = "forma_reproduccion", nullable = true)
	private String forma_reproduccion;
	@Column(name = "tipo_registro", nullable = true)
	private String tipo_registro;
	@Column(name = "catalogacion_descriptiva", nullable = true)
	private String catalogacion_descriptiva;

	@OneToMany(mappedBy = "ficha", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Adquisicion> adquisicion;	

	@OneToOne( cascade = { CascadeType.ALL })
	@JoinColumn(name = "ejemplar_id")
	private Ejemplar ejemplar;
	/**
	 * TODO: agregar Ficha_préstamos con relación de 1 a 1
	 */
	
	public Ficha() {
	}
	
	public Ficha(FichaDto fichaDto, Ejemplar ejemplar) {
		this.primera_fecha = fichaDto.getPrimera_fecha();
		this.segunda_fecha = fichaDto.getSegunda_fecha();
		this.codigo_lengua = fichaDto.getCodigo_lengua();
		this.codigo_ilustracion = fichaDto.getCodigo_ilustracion();
		this.lugar_publicacion = fichaDto.getLugar_publicacion();
		this.nivel_intelectual = fichaDto.getNivel_intelectual();
		this.indicador_indice = fichaDto.getIndicador_indice();
		this.estado_registro = fichaDto.getEstado_registro();
		this.forma_reproduccion = fichaDto.getForma_reproduccion();
		this.tipo_registro = fichaDto.getTipo_registro();
		this.catalogacion_descriptiva = fichaDto.getCatalogacion_descriptiva();
		this.ejemplar = ejemplar;
	}
	
	public Ficha(Date primera_fecha, Date segunda_fecha, String codigo_lengua, String codigo_ilustracion,
			String lugar_publicacion, String nivel_intelectual, String indicador_indice, String estado_registro,
			String forma_reproduccion, String tipo_registro, String catalogacion_descriptiva) {
		this.primera_fecha = primera_fecha;
		this.segunda_fecha = segunda_fecha;
		this.codigo_lengua = codigo_lengua;
		this.codigo_ilustracion = codigo_ilustracion;
		this.lugar_publicacion = lugar_publicacion;
		this.nivel_intelectual = nivel_intelectual;
		this.indicador_indice = indicador_indice;
		this.estado_registro = estado_registro;
		this.forma_reproduccion = forma_reproduccion;
		this.tipo_registro = tipo_registro;
		this.catalogacion_descriptiva = catalogacion_descriptiva;
	}

	public Date getPrimera_fecha() {
		return primera_fecha;
	}
	public void setPrimera_fecha(Date primera_fecha) {
		this.primera_fecha = primera_fecha;
	}
	public Date getSegunda_fecha() {
		return segunda_fecha;
	}
	public void setSegunda_fecha(Date segunda_fecha) {
		this.segunda_fecha = segunda_fecha;
	}
	public String getCodigo_lengua() {
		return codigo_lengua;
	}
	public void setCodigo_lengua(String codigo_lengua) {
		this.codigo_lengua = codigo_lengua;
	}
	public String getCodigo_ilustracion() {
		return codigo_ilustracion;
	}
	public void setCodigo_ilustracion(String codigo_ilustracion) {
		this.codigo_ilustracion = codigo_ilustracion;
	}
	public String getLugar_publicacion() {
		return lugar_publicacion;
	}
	public void setLugar_publicacion(String lugar_publicacion) {
		this.lugar_publicacion = lugar_publicacion;
	}
	public String getNivel_intelectual() {
		return nivel_intelectual;
	}
	public void setNivel_intelectual(String nivel_intelectual) {
		this.nivel_intelectual = nivel_intelectual;
	}
	public String getIndicador_indice() {
		return indicador_indice;
	}
	public void setIndicador_indice(String indicador_indice) {
		this.indicador_indice = indicador_indice;
	}
	public String getEstado_registro() {
		return estado_registro;
	}
	public void setEstado_registro(String estado_registro) {
		this.estado_registro = estado_registro;
	}
	public String getForma_reproduccion() {
		return forma_reproduccion;
	}
	public void setForma_reproduccion(String forma_reproduccion) {
		this.forma_reproduccion = forma_reproduccion;
	}
	public String getTipo_registro() {
		return tipo_registro;
	}
	public void setTipo_registro(String tipo_registro) {
		this.tipo_registro = tipo_registro;
	}
	public String getCatalogacion_descriptiva() {
		return catalogacion_descriptiva;
	}
	public void setCatalogacion_descriptiva(String catalogacion_descriptiva) {
		this.catalogacion_descriptiva = catalogacion_descriptiva;
	}
	@JsonIgnore
	public List<Adquisicion> getAdquisicion() {
		return adquisicion;
	}
	public void setAdquisicion(List<Adquisicion> adquisicion) {
		this.adquisicion = adquisicion;
	}
	public Ejemplar getEjemplar() {
		return ejemplar;
	}
	public void setEjemplar(Ejemplar ejemplar) {
		this.ejemplar = ejemplar;
	}
	@Override
	public String toString() {
		return "Ficha [primera_fecha=" + primera_fecha + ", segunda_fecha=" + segunda_fecha + ", codigo_lengua="
				+ codigo_lengua + ", codigo_ilustracion=" + codigo_ilustracion + ", lugar_publicacion="
				+ lugar_publicacion + ", nivel_intelectual=" + nivel_intelectual + ", indicador_indice="
				+ indicador_indice + ", estado_registro=" + estado_registro + ", forma_reproduccion="
				+ forma_reproduccion + ", tipo_registro=" + tipo_registro + ", catalogacion_descriptiva="
				+ catalogacion_descriptiva + ", adquisicion=" + adquisicion
				+ ", ejemplar=" + ejemplar.getId() + "]";
	}
}
