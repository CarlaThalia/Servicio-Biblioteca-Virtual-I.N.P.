package com.biblioteca.dto;

import com.biblioteca.modelo.Autor;
import com.biblioteca.modelo.Ejemplar;	

public class EjemplarDto {

	private Long id;
	private String titulo;
	private String isbn;
	private String edicion;
	private String editorial;
	private String autor_corporativo;
	private String autor_por_asamblea_conferencia_congreso;
	private String paginas_volumen_dimensiones;
	private String serie_mencion_responsabilidad;
	private String notas_generales;
	private String notas_catalogo_personalizado;
	private String encabezamientos_bajo_autor_personal;
	private String encabezamientos_bajo_autor_corporativo;
	private String encabezamientos_bajo_titulo_uniforme;
	private String encabezamientos_bajo_temas_generales;
	private String asientos_secundarios_bajo_autor_personal;
	private String clasificacionLc;
	private String clasificacion_decimal_dewey;
	private String nota_contenido;
	private String nota_resumen;
	
	private MaterialDto material;

	private String autor;
	private Long autor_id;
	private Long ficha_id;

	public EjemplarDto() {
	}
	
	public EjemplarDto(Ejemplar ejemplar) {
		this.id = ejemplar.getId();
		this.autor_id = ejemplar.getAutor().getId();
		this.autor = ejemplar.getAutor().getNombre();
		this.titulo = ejemplar.getTitulo();
		this.isbn = ejemplar.getIsbn();
		this.edicion = ejemplar.getEdicion();
		this.autor_corporativo = ejemplar.getAutor_corporativo();
		this.autor_por_asamblea_conferencia_congreso = ejemplar.getAutor_por_asamblea_conferencia_congreso();
		this.paginas_volumen_dimensiones = ejemplar.getPaginas_volumen_dimensiones();
		this.serie_mencion_responsabilidad = ejemplar.getSerie_mencion_responsabilidad();
		this.notas_generales = ejemplar.getNotas_generales();
		this.notas_catalogo_personalizado = ejemplar.getNotas_catalogo_personalizado();
		this.encabezamientos_bajo_autor_personal = ejemplar.getEncabezamientos_bajo_autor_personal();
		this.encabezamientos_bajo_autor_corporativo = ejemplar.getEncabezamientos_bajo_autor_corporativo();
		this.encabezamientos_bajo_titulo_uniforme = ejemplar.getEncabezamientos_bajo_titulo_uniforme();
		this.encabezamientos_bajo_temas_generales = ejemplar.getEncabezamientos_bajo_temas_generales();
		this.asientos_secundarios_bajo_autor_personal = ejemplar.getAsientos_secundarios_bajo_autor_personal();
		this.clasificacionLc = ejemplar.getClasificacionLc();
		this.nota_contenido = ejemplar.getNota_contenido();
		this.nota_resumen = ejemplar.getNota_resumen();
		this.clasificacion_decimal_dewey = ejemplar.getClasificacion_decimal_dewey();
		this.editorial = ejemplar.getEditorial();
		this.ficha_id = ejemplar.getFicha().getId();
	}

	public EjemplarDto(Ejemplar ejemplar, Autor autor) {
		this.id = ejemplar.getId();
		this.autor_id = autor.getId();
		this.autor = autor.getNombre();
		this.titulo = ejemplar.getTitulo();
		this.isbn = ejemplar.getIsbn();
		this.edicion = ejemplar.getEdicion();
		this.autor_corporativo = ejemplar.getAutor_corporativo();
		this.autor_por_asamblea_conferencia_congreso = ejemplar.getAutor_por_asamblea_conferencia_congreso();
		this.paginas_volumen_dimensiones = ejemplar.getPaginas_volumen_dimensiones();
		this.serie_mencion_responsabilidad = ejemplar.getSerie_mencion_responsabilidad();
		this.notas_generales = ejemplar.getNotas_generales();
		this.notas_catalogo_personalizado = ejemplar.getNotas_catalogo_personalizado();
		this.encabezamientos_bajo_autor_personal = ejemplar.getEncabezamientos_bajo_autor_personal();
		this.encabezamientos_bajo_autor_corporativo = ejemplar.getEncabezamientos_bajo_autor_corporativo();
		this.encabezamientos_bajo_titulo_uniforme = ejemplar.getEncabezamientos_bajo_titulo_uniforme();
		this.encabezamientos_bajo_temas_generales = ejemplar.getEncabezamientos_bajo_temas_generales();
		this.asientos_secundarios_bajo_autor_personal = ejemplar.getAsientos_secundarios_bajo_autor_personal();
		this.clasificacionLc = ejemplar.getClasificacionLc();
		this.nota_contenido = ejemplar.getNota_contenido();
		this.nota_resumen = ejemplar.getNota_resumen();
		this.clasificacion_decimal_dewey = ejemplar.getClasificacion_decimal_dewey();
		
	}

	public EjemplarDto(String titulo, String isbn, String edicion, String editorial, String autor_corporativo,
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

	public Long getFicha_id() {
		return ficha_id;
	}
	public void setFicha_id(Long ficha_id) {
		this.ficha_id = ficha_id;
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

	public String getClasificacion_decimal_dewey() {
		return clasificacion_decimal_dewey;
	}
	public void setClasificacion_decimal_dewey(String clasificacion_decimal_dewey) {
		this.clasificacion_decimal_dewey = clasificacion_decimal_dewey;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
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

	public void setNota_resumen(String nota_resumen) {
		this.nota_resumen = nota_resumen;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Long getAutor_id() {
		return autor_id;
	}

	public void setAutor_id(Long autor_id) {
		this.autor_id = autor_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public void setMaterial(MaterialDto material) {
		this.material = material;
	}
	public MaterialDto getMaterial() {
		return material;
	}
	
	
}
