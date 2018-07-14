package com.biblioteca.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.modelo.Autor;

public interface IAutorRepositorio extends JpaRepository<Autor, Long>{
	
	public List<Autor> findByNombre(String nombre);

	public List<Autor> findAllByNombreContainingIgnoreCase(String filtro);
}
