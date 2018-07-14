package com.biblioteca.servicio.implementacion;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.modelo.Bibliotecario;
import com.biblioteca.repositorio.IBibliotecarioRepositorio;
import com.biblioteca.servicio.IServicioGenerico;

@Service
public class BibliotecarioServicio implements IServicioGenerico<Bibliotecario> {

	@Autowired
	protected IBibliotecarioRepositorio repositorio;

	@Override
	public void crear(Bibliotecario bibliotecario) {
		repositorio.save(bibliotecario);
	}
	@Override
	public List<Bibliotecario> todos(){
		return repositorio.findAll();
	}
	@Override
	public Optional<Bibliotecario> obtenerRegistro(Long id) {
		return repositorio.findById(id);
	}
	@Override
	public void actualizar(Bibliotecario bibliotecario) {
		repositorio.save(bibliotecario);
	}
	@Override
	public void borrar(Long id) {
		repositorio.deleteById(id);
	}
}
