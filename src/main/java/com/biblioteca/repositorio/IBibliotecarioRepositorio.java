package com.biblioteca.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.modelo.Bibliotecario;

public interface IBibliotecarioRepositorio extends JpaRepository<Bibliotecario, Long>{
	

}
