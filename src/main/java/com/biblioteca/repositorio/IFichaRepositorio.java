package com.biblioteca.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.biblioteca.modelo.Ficha;

public interface IFichaRepositorio extends JpaRepository<Ficha, Long>{
	
	public Ficha findByEjemplarId(Long ejemplarId);
	
	public List<Ficha> findByEjemplarIdIn(long[] ejemplarIds);
} 
