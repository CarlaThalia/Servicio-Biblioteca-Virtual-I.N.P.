package com.biblioteca.utils;

import java.util.ArrayList;
import java.util.List;

import com.biblioteca.dto.EjemplarDto;
import com.biblioteca.modelo.Autor;
import com.biblioteca.modelo.Ejemplar;

public class Convertidor{

	public static List<EjemplarDto> convertEjemplarToEjemplarDto(List<Ejemplar> entidades, Autor autor) {
		List<EjemplarDto> modeloDtoLista = new ArrayList<EjemplarDto>();
		for (Ejemplar entidad : entidades)
			modeloDtoLista.add(new EjemplarDto(entidad, autor));
		return modeloDtoLista;
	}
	
	public static List<EjemplarDto> convertEjemplarToEjemplarDto(List<Ejemplar> entidades) {
		List<EjemplarDto> modeloDtoLista = new ArrayList<EjemplarDto>();
		for (Ejemplar entidad : entidades)
			modeloDtoLista.add(new EjemplarDto(entidad));
		return modeloDtoLista;
	}
}
