package com.biblioteca.servicio.implementacion;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.modelo.UsuarioPrestamo;
import com.biblioteca.repositorio.IUsuarioPrestamoRepositorio;
import com.biblioteca.servicio.IServicioGenerico;

@Service
public class UsuarioPrestamoServicio implements IServicioGenerico<UsuarioPrestamo> {

	@Autowired
	protected IUsuarioPrestamoRepositorio usuarioRepositorio;

	@Override
	public void crear(UsuarioPrestamo usuario) {
		usuarioRepositorio.save(usuario);
	}
	@Override
	public List<UsuarioPrestamo> todos(){
		return usuarioRepositorio.findAll();
	}
	@Override
	public Optional<UsuarioPrestamo> obtenerRegistro(Long id) {
		return usuarioRepositorio.findById(id);
	}
	@Override
	public void actualizar(UsuarioPrestamo usuario) {
		usuarioRepositorio.save(usuario);
	}
	@Override
	public void borrar(Long id) {
		usuarioRepositorio.deleteById(id);
	}
}
