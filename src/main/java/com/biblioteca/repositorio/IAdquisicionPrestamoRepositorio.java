package com.biblioteca.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.modelo.AdquisicionPrestamo;

public interface IAdquisicionPrestamoRepositorio extends JpaRepository<AdquisicionPrestamo, Long>{

}
