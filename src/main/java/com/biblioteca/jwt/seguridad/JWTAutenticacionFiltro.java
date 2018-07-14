package com.biblioteca.jwt.seguridad;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.biblioteca.modelo.Usuario;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
/**
 * Clase responsable del proceso de autenticación.
 * Emite JWTS a los usuarios que envían credenciales,
 * @author Inepe
 *
 */
public class JWTAutenticacionFiltro extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager autenticacionManager;
	
	public JWTAutenticacionFiltro(AuthenticationManager autenticacionManager) {
		this.autenticacionManager = autenticacionManager;
	}
	
	// intento de Autenticación
	// Analiza las credenciales del usuario y las emitimos a AuthenticationManager.
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		try {
			Usuario credenciales = new ObjectMapper().readValue(request.getInputStream(), Usuario.class);

			return autenticacionManager.authenticate(
					new UsernamePasswordAuthenticationToken(
					credenciales.getUsername(),
					credenciales.getPassword(),
					new ArrayList<>()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	// Autenticación satisfactoria
	// llamado cuando un usuario inicia sesión con éxito. Utilizamos este método para generar un JWT para este usuario.
	@Override
	protected void successfulAuthentication(HttpServletRequest requerimiento, HttpServletResponse respuesta, FilterChain chain,
			Authentication auth) throws IOException, ServletException {

		String token = Jwts.builder()
				.setSubject(((User)auth.getPrincipal()).getUsername())
				.setExpiration(new Date(System.currentTimeMillis() + ConstantesSeguridad.TOKEN_EXPIRACION))
				.signWith(SignatureAlgorithm.HS512, ConstantesSeguridad.LLAVE_SECRETA.getBytes())
				.compact();
		respuesta.addHeader(ConstantesSeguridad.HEADER_AUTHORIZATION_KEY, ConstantesSeguridad.PREFIJO_TOKEN_BEARER + " " + token);

	}
	
}
