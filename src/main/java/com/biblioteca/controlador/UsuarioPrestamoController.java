package com.biblioteca.controlador;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.biblioteca.modelo.UsuarioPrestamo;
import com.biblioteca.servicio.implementacion.UsuarioPrestamoServicio;
import com.biblioteca.utils.RestResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin
@RestController
@RequestMapping("/api/usuarioPrestamo")
public class UsuarioPrestamoController {

	@Autowired
	protected UsuarioPrestamoServicio servicio;

	protected ObjectMapper mapeador = new ObjectMapper();

	@GetMapping
	public ResponseEntity<List<UsuarioPrestamo>> obtenerTodos() {
		List<UsuarioPrestamo> usuarios = this.servicio.todos();
		if (usuarios.isEmpty()) {
			return new ResponseEntity<List<UsuarioPrestamo>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<UsuarioPrestamo>>(usuarios, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> obtenerRegistro(@PathVariable("id") Long id) {
		Optional<UsuarioPrestamo> usuario = this.servicio.obtenerRegistro(id);
		if (!usuario.isPresent()) {
			return ((BodyBuilder) ResponseEntity.notFound())
					.body(new RestResponse(HttpStatus.NOT_FOUND.value(), "Registro no encontrado"));
		}
		return ResponseEntity.ok(usuario);
	}

	@PostMapping()
	public ResponseEntity<Object> crear(@RequestBody String entidadJSON)
			throws JsonParseException, JsonMappingException, IOException {
		UsuarioPrestamo usuario = this.mapeador.readValue(entidadJSON, UsuarioPrestamo.class);
		if (!esValido(usuario)) {
			return ResponseEntity.badRequest().body(
					new RestResponse(HttpStatus.BAD_REQUEST.value(), "Error, Existen campos que son obligatorios."));
		}
		if (usuario.getId() != null) {
			return ResponseEntity.badRequest().body(new RestResponse(HttpStatus.BAD_REQUEST.value(),
					"No se debe enviar el ID en la creación de registros, ya que se generan automáticamente."));
		}
		this.servicio.crear(usuario);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> actualizarRegistro(@RequestBody String entidadJSON, @PathVariable Long id)
			throws JsonParseException, JsonMappingException, IOException {
		UsuarioPrestamo usuario = this.mapeador.readValue(entidadJSON, UsuarioPrestamo.class);
		long idGetId = usuario.getId();
		long identiRuta = usuario.getId() ;
		if (id != identiRuta) {
			return ResponseEntity.badRequest().body(new RestResponse(HttpStatus.BAD_REQUEST.value(),
					"Error, Verifique que el Id del objeto coincida con el id enviado en la ruta /{id}."));
		}
		Optional<UsuarioPrestamo> usuarioEncontrado = servicio.obtenerRegistro(id);
		if (!usuarioEncontrado.isPresent()) {
			return ((BodyBuilder) ResponseEntity.notFound())
					.body(new RestResponse(HttpStatus.NOT_FOUND.value(), "Registro no encontrado para actualizar"));
		}
		if (!esValido(usuario)) {
			return ResponseEntity.badRequest().body(
					new RestResponse(HttpStatus.BAD_REQUEST.value(), "Error, Existen campos que son obligatorios."));
		}

		this.servicio.actualizar(usuario);
		return ResponseEntity.ok().body(new RestResponse(HttpStatus.OK.value(), "Registro actualizado exitósamente"));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> borrarRegistro(@PathVariable("id") Long id) {
		Optional<UsuarioPrestamo> usuario = servicio.obtenerRegistro(id);
		if (!usuario.isPresent()) {
			return ((BodyBuilder) ResponseEntity.notFound())
					.body(new RestResponse(HttpStatus.NOT_FOUND.value(), "Registro no encontrado para eliminar"));
		}
		this.servicio.borrar(id);

		return ResponseEntity.ok().body(new RestResponse(HttpStatus.OK.value(), "Registro eliminado exitósamente"));
	}

	private boolean esValido(UsuarioPrestamo usuario) {
		boolean esValido = true;
		if (usuario.getNombre() == null) {
			esValido = false;
		}
		return esValido;
	}

}
