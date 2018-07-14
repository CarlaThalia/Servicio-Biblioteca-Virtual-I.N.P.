package com.biblioteca.servicio.implementacion;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.biblioteca.modelo.Usuario;
import com.biblioteca.repositorio.IUsuarioRepositorio;
import com.biblioteca.servicio.IServicioGenerico;

@Service
public class UsuarioServicio implements IServicioGenerico<Usuario>{

	private BCryptPasswordEncoder codificadorPassword;
	
	@Autowired
	protected IUsuarioRepositorio repositorio;

	public void crear(Usuario usuario) {
		codificadorPassword = new BCryptPasswordEncoder();
		usuario.setPassword(codificadorPassword.encode(usuario.getPassword()));
		usuario.setUsername(usuario.getUsername());
		repositorio.save(usuario);
	}
	@Override
	public List<Usuario> todos(){
		return repositorio.findAll();
	}
	@Override
	public Optional<Usuario> obtenerRegistro(Long id) {
		return repositorio.findById(id);
	}
	@Override
	public void actualizar(Usuario usuario) {
		repositorio.save(usuario);
	}
	@Override
	public void borrar(Long id) {
		repositorio.deleteById(id);
	}	
	
	
}
