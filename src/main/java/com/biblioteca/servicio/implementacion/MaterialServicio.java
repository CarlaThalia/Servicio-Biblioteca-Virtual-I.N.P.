package com.biblioteca.servicio.implementacion;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.modelo.Material;
import com.biblioteca.repositorio.IMaterialRepositorio;
import com.biblioteca.servicio.IServicioGenerico;

@Service
public class MaterialServicio implements IServicioGenerico<Material> {

	@Autowired
	protected IMaterialRepositorio repositorio;

	@Override
	public void crear(Material categoria) {
		repositorio.save(categoria);
	}
	@Override
	public List<Material> todos(){
		return repositorio.findAll();
	}
	@Override
	public Optional<Material> obtenerRegistro(Long id) {
		return repositorio.findById(id);
	}
	@Override
	public void actualizar(Material categoria) {
		repositorio.save(categoria);
	}
	@Override
	public void borrar(Long id) {
		repositorio.deleteById(id);
	}
	public List<Material> filtrarPorNombre(String filtro) {
		return repositorio.findAllByNombreContainingIgnoreCase('%' + filtro + '%');
	}
}
