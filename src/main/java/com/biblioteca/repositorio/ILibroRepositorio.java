package com.biblioteca.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.modelo.Libro;

public interface ILibroRepositorio extends JpaRepository<Libro, Long>{
	
	List<Libro> findByTitulo(String titulo);
	
}
