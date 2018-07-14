package com.biblioteca.modelo;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Daniel
 *
 */
@Entity
@Table(name = "ejemplar")
@Access(AccessType.FIELD)
public class Ejemplar extends EntidadPadre implements Serializable {

	@Column(name = "titulo", nullable = false) // nombre de la columna de la propiedad título
	private String titulo;
	@Column(name = "isbn", nullable = false)
	private String isbn;
	@Column(name = "edicion", nullable = true)
	private String edicion;
	@Column(name = "editorial", nullable = true)
	private String editorial;
	@Column(name = "autor_corporativo", nullable = true)
	private String autor_corporativo;
	@Column(name = "autor_por_asamblea_conferencia_congreso", nullable = true)
	private String autor_por_asamblea_conferencia_congreso;
	@Column(name = "paginas_volumen_dimensiones", nullable = true)
	private String paginas_volumen_dimensiones;
	@Column(name = "serie_mencion_responsabilidad", nullable = true)
	private String serie_mencion_responsabilidad;
	@Column(name = "notas_generales", nullable = true)
	private String notas_generales;
	@Column(name = "notas_catalogo_personalizado", nullable = true)
	private String notas_catalogo_personalizado;
	@Column(name = "encabezamientos_bajo_autor_personal", nullable = true)
	private String encabezamientos_bajo_autor_personal;
	@Column(name = "encabezamientos_bajo_autor_corporativo", nullable = true)
	private String encabezamientos_bajo_autor_corporativo;
	@Column(name = "encabezamientos_bajo_titulo_uniforme", nullable = true)
	private String encabezamientos_bajo_titulo_uniforme;
	@Column(name = "encabezamientos_bajo_temas_generales", nullable = true)
	private String encabezamientos_bajo_temas_generales;
	@Column(name = "asientos_secundarios_bajo_autor_personal", nullable = true)
	private String asientos_secundarios_bajo_autor_personal;
	@Column(name = "clasificacionLc", nullable = true)
	private String clasificacionLc;
	@Column(name = "clasificacion_decimal_dewey", nullable = true)
	private String clasificacion_decimal_dewey;
	@Column(name = "nota_contenido", nullable = true)
	private String nota_contenido;
	@Column(name = "nota_resumen", nullable = true)
	private String nota_resumen;

	/**
	 * Relaciones de muchos a uno
	 */
	// @JsonBackReference
	// @JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = true)
	private Autor autor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = true)
	private Material material;
	
	@OneToOne(mappedBy = "ejemplar", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JsonIgnore
	private Ficha ficha;

	public Ejemplar() {
	}
	
	public Ejemplar(String titulo, String isbn, String edicion, String editorial, String autor_corporativo,
			String autor_por_asamblea_conferencia_congreso, String paginas_volumen_dimensiones,
			String serie_mencion_responsabilidad, String notas_generales, String notas_catalogo_personalizado,
			String encabezamientos_bajo_autor_personal, String encabezamientos_bajo_autor_corporativo,
			String encabezamientos_bajo_titulo_uniforme, String encabezamientos_bajo_temas_generales,
			String asientos_secundarios_bajo_autor_personal, String clasificacion_lc,
			String clasificacion_decimal_dewey, String nota_contenido, String nota_resumen) {
		this.titulo = titulo;
		this.isbn = isbn;
		this.edicion = edicion;
		this.editorial = editorial;
		this.autor_corporativo = autor_corporativo;
		this.autor_por_asamblea_conferencia_congreso = autor_por_asamblea_conferencia_congreso;
		this.paginas_volumen_dimensiones = paginas_volumen_dimensiones;
		this.serie_mencion_responsabilidad = serie_mencion_responsabilidad;
		this.notas_generales = notas_generales;
		this.notas_catalogo_personalizado = notas_catalogo_personalizado;
		this.encabezamientos_bajo_autor_personal = encabezamientos_bajo_autor_personal;
		this.encabezamientos_bajo_autor_corporativo = encabezamientos_bajo_autor_corporativo;
		this.encabezamientos_bajo_titulo_uniforme = encabezamientos_bajo_titulo_uniforme;
		this.encabezamientos_bajo_temas_generales = encabezamientos_bajo_temas_generales;
		this.asientos_secundarios_bajo_autor_personal = asientos_secundarios_bajo_autor_personal;
		this.clasificacionLc = clasificacion_lc;
		this.clasificacion_decimal_dewey = clasificacion_decimal_dewey;
		this.nota_contenido = nota_contenido;
		this.nota_resumen = nota_resumen;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getEdicion() {
		return edicion;
	}

	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}

	public String getAutor_corporativo() {
		return autor_corporativo;
	}

	public void setAutor_corporativo(String autor_corporativo) {
		this.autor_corporativo = autor_corporativo;
	}

	public String getAutor_por_asamblea_conferencia_congreso() {
		return autor_por_asamblea_conferencia_congreso;
	}

	public void setAutor_por_asamblea_conferencia_congreso(String autor_por_asamblea_conferencia_congreso) {
		this.autor_por_asamblea_conferencia_congreso = autor_por_asamblea_conferencia_congreso;
	}

	public String getPaginas_volumen_dimensiones() {
		return paginas_volumen_dimensiones;
	}

	public void setPaginas_volumen_dimensiones(String paginas_volumen_dimensiones) {
		this.paginas_volumen_dimensiones = paginas_volumen_dimensiones;
	}

	public String getSerie_mencion_responsabilidad() {
		return serie_mencion_responsabilidad;
	}

	public void setSerie_mencion_responsabilidad(String serie_mencion_responsabilidad) {
		this.serie_mencion_responsabilidad = serie_mencion_responsabilidad;
	}

	public String getNotas_generales() {
		return notas_generales;
	}

	public void setNotas_generales(String notas_generales) {
		this.notas_generales = notas_generales;
	}

	public String getNotas_catalogo_personalizado() {
		return notas_catalogo_personalizado;
	}

	public void setNotas_catalogo_personalizado(String notas_catalogo_personalizado) {
		this.notas_catalogo_personalizado = notas_catalogo_personalizado;
	}

	public String getEncabezamientos_bajo_autor_personal() {
		return encabezamientos_bajo_autor_personal;
	}

	public void setEncabezamientos_bajo_autor_personal(String encabezamientos_bajo_autor_personal) {
		this.encabezamientos_bajo_autor_personal = encabezamientos_bajo_autor_personal;
	}

	public String getEncabezamientos_bajo_autor_corporativo() {
		return encabezamientos_bajo_autor_corporativo;
	}

	public void setEncabezamientos_bajo_autor_corporativo(String encabezamientos_bajo_autor_corporativo) {
		this.encabezamientos_bajo_autor_corporativo = encabezamientos_bajo_autor_corporativo;
	}

	public String getEncabezamientos_bajo_titulo_uniforme() {
		return encabezamientos_bajo_titulo_uniforme;
	}
	
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public void setEncabezamientos_bajo_titulo_uniforme(String encabezamientos_bajo_titulo_uniforme) {
		this.encabezamientos_bajo_titulo_uniforme = encabezamientos_bajo_titulo_uniforme;
	}

	public String getEncabezamientos_bajo_temas_generales() {
		return encabezamientos_bajo_temas_generales;
	}

	public void setEncabezamientos_bajo_temas_generales(String encabezamientos_bajo_temas_generales) {
		this.encabezamientos_bajo_temas_generales = encabezamientos_bajo_temas_generales;
	}

	public String getAsientos_secundarios_bajo_autor_personal() {
		return asientos_secundarios_bajo_autor_personal;
	}

	public void setAsientos_secundarios_bajo_autor_personal(String asientos_secundarios_bajo_autor_personal) {
		this.asientos_secundarios_bajo_autor_personal = asientos_secundarios_bajo_autor_personal;
	}

	public String getClasificacionLc() {
		return clasificacionLc;
	}

	public void setClasificacionLc(String clasificacion_lc) {
		this.clasificacionLc = clasificacion_lc;
	}

	public String getNota_contenido() {
		return nota_contenido;
	}

	public void setNota_contenido(String nota_contenido) {
		this.nota_contenido = nota_contenido;
	}

	public String getNota_resumen() {
		return nota_resumen;
	}

	public String getClasificacion_decimal_dewey() {
		return clasificacion_decimal_dewey;
	}
	public void setClasificacion_decimal_dewey(String clasificacion_decimal_dewey) {
		this.clasificacion_decimal_dewey = clasificacion_decimal_dewey;
	}
	
	public void setNota_resumen(String nota_resumen) {
		this.nota_resumen = nota_resumen;
	}
	@JsonIgnore
	public Autor getAutor() {
		return autor;
	}
	@JsonProperty
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	@JsonIgnore
	public Material getMaterial() {
		return material;
	}
	@JsonProperty
	public void setMaterial(Material material) {
		this.material = material;
	}

	public Ficha getFicha() {
		return ficha;
	}

	public void setFicha(Ficha ficha) {
		this.ficha = ficha;
	}
}
