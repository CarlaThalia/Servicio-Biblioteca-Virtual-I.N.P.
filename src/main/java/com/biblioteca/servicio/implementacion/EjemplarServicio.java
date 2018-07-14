package com.biblioteca.servicio.implementacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.dto.EjemplarDto;
import com.biblioteca.modelo.Autor;
import com.biblioteca.modelo.Ejemplar;
import com.biblioteca.modelo.Material;
import com.biblioteca.repositorio.IEjemplarRepositorio;
import com.biblioteca.servicio.IServicioGenerico;

@Service
public class EjemplarServicio implements IServicioGenerico<Ejemplar> {

	@Autowired
	protected IEjemplarRepositorio ejemplarRepositorio;

	@Override
	public void crear(Ejemplar ejemplar) {
		ejemplarRepositorio.save(ejemplar);
	}

	@Override
	public List<Ejemplar> todos() {
		return ejemplarRepositorio.findAll();
	}

	@Override
	public Optional<Ejemplar> obtenerRegistro(Long id) {
		return ejemplarRepositorio.findById(id);
	}

	@Override
	public void actualizar(Ejemplar ejemplar) {
		ejemplarRepositorio.save(ejemplar);
	}

	@Override
	public void borrar(Long id) {
		ejemplarRepositorio.deleteById(id);
	}

	public List<Ejemplar> obtenerPorTitulo(String titulo) {
		return ejemplarRepositorio.findByTitulo(titulo);
	}

	public List<Ejemplar> filtrarPorTitulo(String filtro) {
		return ejemplarRepositorio.findAllByTituloContainingIgnoreCase('%' + filtro + '%');
	}

	public List<Ejemplar> obtenerEjemplarPorFicha(String id) {
		Long idLong = Long.parseLong(id);
		return ejemplarRepositorio.findByFichaId(idLong);
	}

	public List<Ejemplar> obtenerPorAutorId(Long id) {
		List<Ejemplar> ejemplares = ejemplarRepositorio.findByAutorId(id);
		return ejemplares;
	}

	public Ejemplar obtenerPorISBN(String isbn) {
		return ejemplarRepositorio.findByIsbn(isbn);
	}

	public List<Ejemplar> obtenerPorClasificacion(String clasificacion) {
		return ejemplarRepositorio.findByClasificacionLc(clasificacion);
	}

	public List<EjemplarDto> obtenerEjemplaresDeAutores(List<Autor> autores) {
		List<EjemplarDto> ejemplares = new ArrayList<>();
		for (Autor autor : autores) {
			List<Ejemplar> ejemplaresAutor = ejemplarRepositorio.findByAutorId(autor.getId());
			for (Ejemplar ejemplar : ejemplaresAutor) {
				EjemplarDto ejemplarDto = new EjemplarDto(ejemplar);
				ejemplares.add(ejemplarDto);
			}
		}
		return ejemplares;
	}

	public List<EjemplarDto> obtenerEjemplaresPorMaterial(List<Material> materiales) {
		List<EjemplarDto> ejemplares = new ArrayList<>();
		for (Material material : materiales) {
			List<Ejemplar> ejemplaresMaterial = ejemplarRepositorio.findByMaterialId(material.getId());
			for (Ejemplar ejemplar : ejemplaresMaterial) {
				EjemplarDto ejemplarDto = new EjemplarDto(ejemplar);
				ejemplares.add(ejemplarDto);
			}
		}
		return ejemplares;
	}

}
