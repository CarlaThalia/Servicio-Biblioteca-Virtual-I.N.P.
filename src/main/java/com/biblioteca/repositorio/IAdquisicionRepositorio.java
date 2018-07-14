package com.biblioteca.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.modelo.Adquisicion;

public interface IAdquisicionRepositorio extends JpaRepository<Adquisicion, Long>{
	
	public List<Adquisicion> findByCodAdquisicion(String codAdquisicion);

}
