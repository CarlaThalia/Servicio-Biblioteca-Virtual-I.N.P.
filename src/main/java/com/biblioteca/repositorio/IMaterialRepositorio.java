package com.biblioteca.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.modelo.Material;

public interface IMaterialRepositorio extends JpaRepository<Material, Long>{

	public List<Material> findAllByNombreContainingIgnoreCase(String material);
	

}
