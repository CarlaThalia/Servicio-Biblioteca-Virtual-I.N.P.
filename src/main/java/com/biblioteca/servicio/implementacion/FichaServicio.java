package com.biblioteca.servicio.implementacion;

import com.biblioteca.dto.EjemplarDto;
import com.biblioteca.modelo.Ejemplar;
import com.biblioteca.modelo.Ficha;
import com.biblioteca.repositorio.IFichaRepositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.servicio.IServicioGenerico;

@Service
public class FichaServicio implements IServicioGenerico<Ficha> {
	@Autowired
	protected IFichaRepositorio repositorio;

	/// *********** Métodos Propios de la Clase **********///

	public Ficha obtenerFichasPorEjemplarId(long id) {
		return repositorio.findByEjemplarId(id);
	}

	public List<Ficha> obtenerListaDefichasPorEjemplarId(List<Ejemplar> ejemplares){
		List<Ficha> fichas = new ArrayList<>();
		for (Ejemplar ejemplar : ejemplares) {
			Ficha ficha = repositorio.findByEjemplarId(ejemplar.getId());
			fichas.add(ficha);
		}
		return fichas;
	}

	public List<Ficha> obtenerListaDefichasPorEjemplarDtoId(List<EjemplarDto> ejemplares) {
		List<Ficha> fichas = new ArrayList<>();
		for (EjemplarDto ejemplar : ejemplares) {
			Ficha ficha = repositorio.findByEjemplarId(ejemplar.getId());
			fichas.add(ficha);
		}
		return fichas;
	}
	
	
	@Override
	public void crear(Ficha entidad) {
		repositorio.save(entidad);
	}

	@Override
	public List<Ficha> todos() {
		return repositorio.findAll();
	}

	@Override
	public Optional<Ficha> obtenerRegistro(Long id) {
		return repositorio.findById(id);
	}

	@Override
	public void actualizar(Ficha entidad) {
		repositorio.save(entidad);
	}

	@Override
	public void borrar(Long id) {
		repositorio.deleteById(id);
	}


}
