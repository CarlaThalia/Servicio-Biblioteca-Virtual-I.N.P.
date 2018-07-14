package com.biblioteca.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.modelo.Ejemplar;

public interface IEjemplarRepositorio extends JpaRepository<Ejemplar, Long>{
	
	public List<Ejemplar> findAllByTituloContainingIgnoreCase(String filtro);
	
	public List<Ejemplar> findByTitulo(String titulo);
	
	public List<Ejemplar> findByFichaId(Long id);
	
	public List<Ejemplar> findByAutorId(Long id); 
	
	public Ejemplar findByIsbn(String isbn);
	
	public List<Ejemplar> findByClasificacionLc(String clasificacion);
	
	public List<Ejemplar> findByMaterialId(Long id); 
}
