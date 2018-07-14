package com.biblioteca.servicio.implementacion;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.modelo.Autor;
import com.biblioteca.repositorio.IAutorRepositorio;
import com.biblioteca.servicio.IServicioGenerico;

@Service
public class AutorServicio implements IServicioGenerico<Autor> {

	@Autowired
	protected IAutorRepositorio repositorio;

	@Override
	public void crear(Autor autor) {
		repositorio.save(autor);
	}
	@Override
	public List<Autor> todos(){
		return repositorio.findAll();
	}
	@Override
	public Optional<Autor> obtenerRegistro(Long id) {
		return repositorio.findById(id);
	}
	@Override
	public void actualizar(Autor autor) {
		repositorio.save(autor);
	}
	@Override
	public void borrar(Long id) {
		repositorio.deleteById(id);
	}
	public List<Autor> buscarPorNombre(String nombre){
		return repositorio.findByNombre(nombre);
	}
	public List<Autor> filtrarPorNombre(String filtro){
		return repositorio.findAllByNombreContainingIgnoreCase('%' + filtro + '%');
	}
}