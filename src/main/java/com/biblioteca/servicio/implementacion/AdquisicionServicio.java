package com.biblioteca.servicio.implementacion;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.modelo.Adquisicion;
import com.biblioteca.repositorio.IAdquisicionRepositorio;
import com.biblioteca.servicio.IServicioGenerico;

@Service
public class AdquisicionServicio implements IServicioGenerico<Adquisicion> {

	@Autowired
	protected IAdquisicionRepositorio repositorio;

	@Override
	public void crear(Adquisicion adquisicion) {
		repositorio.save(adquisicion);
	}
	@Override
	public List<Adquisicion> todos(){
		return repositorio.findAll();
	}
	@Override
	public Optional<Adquisicion> obtenerRegistro(Long id) {
		return repositorio.findById(id);
	}
	@Override
	public void actualizar(Adquisicion adquisicion) {
		repositorio.save(adquisicion);
	}
	@Override
	public void borrar(Long id) {
		repositorio.deleteById(id);
	}
	
	public Optional<Adquisicion> obtenerAdquisicionPorCodAdquisicion(String codAdquisicion){
		return repositorio.findByCodAdquisicion(codAdquisicion).stream().findFirst();
	}
}