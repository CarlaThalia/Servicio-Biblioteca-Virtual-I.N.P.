package com.biblioteca.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.modelo.UsuarioPrestamo;

public interface IUsuarioPrestamoRepositorio extends JpaRepository<UsuarioPrestamo, Long> {
	
	
}
