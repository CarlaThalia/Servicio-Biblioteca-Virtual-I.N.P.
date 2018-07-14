package com.biblioteca.servicio.implementacion;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.modelo.AdquisicionPrestamo;
import com.biblioteca.repositorio.IAdquisicionPrestamoRepositorio;
import com.biblioteca.servicio.IServicioGenerico;

@Service
public class AdquisicionPrestamoServicio implements IServicioGenerico<AdquisicionPrestamo> {

	@Autowired
	protected IAdquisicionPrestamoRepositorio repositorio;

	@Override
	public void crear(AdquisicionPrestamo adquisicion) {
		repositorio.save(adquisicion);
	}
	@Override
	public List<AdquisicionPrestamo> todos(){
		return repositorio.findAll();
	}
	@Override
	public Optional<AdquisicionPrestamo> obtenerRegistro(Long id) {
		return repositorio.findById(id);
	}
	@Override
	public void actualizar(AdquisicionPrestamo adquisicion) {
		repositorio.save(adquisicion);
	}
	@Override
	public void borrar(Long id) {
		repositorio.deleteById(id);
	}

}