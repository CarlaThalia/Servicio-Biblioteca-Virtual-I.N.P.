package com.biblioteca.utils;

import java.util.List;

public class QueryResult {

	private int totalRegistros;
	private List<Object> registros;
	
	public int getTotalRegistros() {
		return totalRegistros;
	}
	public void setTotalRegistros(int totalRegistros) {
		this.totalRegistros = totalRegistros;
	}
	public List<Object> getRegistros() {
		return registros;
	}
	public void setRegistros(List<Object> registros) {
		this.registros = registros;
	}
	
	
}
