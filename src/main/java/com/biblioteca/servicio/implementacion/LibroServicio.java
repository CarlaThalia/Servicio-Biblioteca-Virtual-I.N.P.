package com.biblioteca.servicio.implementacion;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.modelo.Libro;
import com.biblioteca.repositorio.ILibroRepositorio;
import com.biblioteca.servicio.IServicioGenerico;

@Service
public class LibroServicio implements IServicioGenerico<Libro> {

	@Autowired
	protected ILibroRepositorio libroRepositorio;

	@Override
	public void crear(Libro libro) {
		libroRepositorio.save(libro);
	}
	@Override
	public List<Libro> todos(){
		return libroRepositorio.findAll();
	}
	@Override
	public Optional<Libro> obtenerRegistro(Long id) {
		// Libro libro = (Libro) libroRepositorio.findAll().stream().filter(l -> l.getId().equals(2L));
		//Optional<Libro> libro = libroRepositorio.findAll().stream().filter(l -> l.getId().equals(2L)).findFirst();
		//libroRepositorio.findOne(id);
		return libroRepositorio.findById(id);
	}
	@Override
	public void actualizar(Libro libro) {
		libroRepositorio.save(libro);
	}
	@Override
	public void borrar(Long id) {
		libroRepositorio.deleteById(id);
	}

	public List<Libro> obtenerPorTitulo(String titulo) {
		return libroRepositorio.findByTitulo(titulo);
	}
}
