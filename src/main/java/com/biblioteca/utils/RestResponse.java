package com.biblioteca.utils;

public class RestResponse {

	private Integer codigoRespuesta;
	private String mensajeRespuesta;

	public RestResponse(Integer codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}

	public RestResponse(Integer codigoRespuesta, String mensajeRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
		this.mensajeRespuesta = mensajeRespuesta;
	}
	
	public Integer getCodigoRespuesta() {
		return codigoRespuesta;
	}

	public void setCodigoRespuesta(Integer codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}

	public String getMensajeRespuesta() {
		return mensajeRespuesta;
	}

	public void setMensajeRespuesta(String mensajeRespuesta) {
		this.mensajeRespuesta = mensajeRespuesta;
	}

}
