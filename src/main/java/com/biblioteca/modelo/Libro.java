package com.biblioteca.modelo;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * Las entidades se trabajan en los repositorios
 * @author Daniel
 *
 */
@Entity
@Table(name = "libro")
@Access(AccessType.FIELD)
public class Libro extends EntidadPadre implements Serializable {
	
	private static final long serialVersionUID = 4430233357452107298L;

	@Column(name = "titulo", nullable = false, length = 255) // nombre de la columna de la propiedad título
	private String titulo;
	@Column(name = "edicion", nullable = true, length = 255)
	private String edicion;
	@Column(name = "editorial", nullable = true, length = 255)
	private String editorial;
	@Column(name = "isbn", nullable = false, length = 255)
	private String isbn;
	@Column(name = "categoria", nullable = false, length = 255)
	private String categoria;
	@Column(name = "fecha_publicacion")
	@JsonFormat(pattern="yyyy-MM-dd", locale = "es-EC")
	private Date fecha_publicacion;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn
	private Autor autor;
	
	public Libro() {}
	public Libro(String titulo, String edicion, String editorial, String isbn, String categoria) {
		this.titulo = titulo;
		this.edicion = edicion;
		this.editorial = editorial;
		this.isbn = isbn;
		this.categoria = categoria;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getEdicion() {
		return edicion;
	}
	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	
}
