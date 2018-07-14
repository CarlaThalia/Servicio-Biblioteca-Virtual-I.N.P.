package com.biblioteca.utils;

import java.util.ArrayList;
import java.util.List;

import com.biblioteca.dto.FichaDto;
import com.biblioteca.modelo.Ficha;

public class ConvertFicha {

	public static List<FichaDto> convertFichaToFichaDto(List<Ficha> entidades) {
		List<FichaDto> modeloDtoLista = new ArrayList<FichaDto>();
		for (Ficha entidad : entidades)
			modeloDtoLista.add(new FichaDto(entidad));
		return modeloDtoLista;
	}

	
}
