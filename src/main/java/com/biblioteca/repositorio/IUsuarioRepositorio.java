package com.biblioteca.repositorio;

import com.biblioteca.modelo.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepositorio extends JpaRepository<Usuario, Long> {

	public Usuario findByUsername(String username);

}
