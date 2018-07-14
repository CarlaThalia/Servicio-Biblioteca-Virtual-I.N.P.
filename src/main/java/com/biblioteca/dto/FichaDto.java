package com.biblioteca.dto;

import java.sql.Date;

import com.biblioteca.modelo.Ficha;

public class FichaDto {

	private Long id;
	private Date primera_fecha;
	private Date segunda_fecha;
	private String codigo_lengua;
	private String codigo_ilustracion;
	private String lugar_publicacion;

	private String nivel_intelectual;
	private String indicador_indice;
	private String estado_registro;
	private String forma_reproduccion;
	private String tipo_registro;
	private String catalogacion_descriptiva;
	
	private MaterialDto material;
	
	private EjemplarDto ejemplar;

	private Long ejemplar_id;

	public FichaDto() {
	}

	public FichaDto(Long id, Date primera_fecha, Date segunda_fecha, String codigo_lengua, String codigo_ilustracion,
			String lugar_publicacion, String nivel_intelectual, String indicador_indice, String estado_registro,
			String forma_reproduccion, String tipo_registro, String catalogacion_descriptiva, String tipo_material,
			Long ejemplar_id) {
		this.id = id;
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

	public FichaDto(Ficha ficha) {
		this.id = ficha.getId();
		this.primera_fecha = ficha.getPrimera_fecha();
		this.segunda_fecha = ficha.getSegunda_fecha();
		this.codigo_lengua = ficha.getCodigo_lengua();
		this.codigo_ilustracion = ficha.getCodigo_ilustracion();
		this.lugar_publicacion = ficha.getLugar_publicacion();
		this.nivel_intelectual = ficha.getNivel_intelectual();
		this.indicador_indice = ficha.getIndicador_indice();
		this.estado_registro = ficha.getEstado_registro();
		this.forma_reproduccion = ficha.getForma_reproduccion();
		this.tipo_registro = ficha.getTipo_registro();
		this.catalogacion_descriptiva = ficha.getCatalogacion_descriptiva();
		this.ejemplar = new EjemplarDto(ficha.getEjemplar());
		this.material = new MaterialDto(ficha.getEjemplar().getMaterial());
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getEjemplar_id() {
		return ejemplar_id;
	}

	public void setEjemplar_id(Long ejemplar_id) {
		this.ejemplar_id = ejemplar_id;
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

	public EjemplarDto getEjemplar() {
		return ejemplar;
	}

	public void setEjemplar(EjemplarDto ejemplar) {
		this.ejemplar = ejemplar;
	}
	
	public MaterialDto getMaterial() {
		return material;
	}
	public void setMaterial(MaterialDto material) {
		this.material = material;
	}

}
