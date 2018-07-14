package com.biblioteca.jwt.seguridad;

public class ConstantesSeguridad {

	// SEGURIDAD SPRING 
	public static final String LOGIN_URL = "/login";
	public static final String HEADER_AUTHORIZATION_KEY = "Authorization";
	public static final String PREFIJO_TOKEN_BEARER = "Bearer ";
	
	// JWT
	
	public static final String LLAVE_SECRETA = "SecretKeyToGenJWTs";
	public static final long TOKEN_EXPIRACION = 86_400_0000; // 1 día
	
}
