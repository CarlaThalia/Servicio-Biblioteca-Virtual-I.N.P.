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

import com.biblioteca.modelo.Libro;
import com.biblioteca.servicio.implementacion.LibroServicio;
import com.biblioteca.utils.RestResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin
@RestController
@RequestMapping("/api/libro")
public class LibroController {

	@Autowired
	protected LibroServicio servicio;

	protected ObjectMapper mapeador = new ObjectMapper();

	@GetMapping
	public ResponseEntity<List<Libro>> obtenerTodos() {
		List<Libro> libros = this.servicio.todos();
		if (libros.isEmpty()) {
			return new ResponseEntity<List<Libro>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Libro>>(libros, HttpStatus.OK);
	}

	@GetMapping("porTitulo/{titulo}")
	public ResponseEntity<List<Libro>> obtenerLibroPorTitulo(@PathVariable("titulo") String titulo) {
		List<Libro> libros = this.servicio.obtenerPorTitulo(titulo);
		if (libros.isEmpty()) {
			return new ResponseEntity<List<Libro>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Libro>>(libros, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> obtenerRegistro(@PathVariable("id") Long id) {
		Optional<Libro> libro = this.servicio.obtenerRegistro(id);
		if (!libro.isPresent()) {
			return ((BodyBuilder) ResponseEntity.notFound())
					.body(new RestResponse(HttpStatus.NOT_FOUND.value(), "Registro no encontrado"));
		}
		return ResponseEntity.ok(libro);
	}

	@PostMapping()
	public ResponseEntity<Object> crear(@RequestBody String entidadJSON)
			throws JsonParseException, JsonMappingException, IOException {
		Libro libro = this.mapeador.readValue(entidadJSON, Libro.class);
		if (!esValido(libro)) {
			return ResponseEntity.badRequest().body(
					new RestResponse(HttpStatus.BAD_REQUEST.value(), "Error, Existen campos que son obligatorios."));
		}
		if (libro.getId() != null) {
			return ResponseEntity.badRequest().body(new RestResponse(HttpStatus.BAD_REQUEST.value(),
					"No se debe enviar el ID en la creación de registros, ya que se generan automáticamente."));
		}
		this.servicio.crear(libro);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(libro.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> actualizarRegistro(@RequestBody String entidadJSON, @PathVariable Long id)
			throws JsonParseException, JsonMappingException, IOException {
		Libro libro = this.mapeador.readValue(entidadJSON, Libro.class);
		if (id != libro.getId()) {
			return ResponseEntity.badRequest().body(new RestResponse(HttpStatus.BAD_REQUEST.value(),
					"Error, Verifique que el Id del objeto coincida con el id enviado en la ruta /{id}."));
		}
		Optional<Libro> libroEncontrado = servicio.obtenerRegistro(id);
		if (!libroEncontrado.isPresent()) {
			return ((BodyBuilder) ResponseEntity.notFound())
					.body(new RestResponse(HttpStatus.NOT_FOUND.value(), "Registro no encontrado para actualizar"));
		}
		if (!esValido(libro)) {
			return ResponseEntity.badRequest().body(
					new RestResponse(HttpStatus.BAD_REQUEST.value(), "Error, Existen campos que son obligatorios."));
		}

		this.servicio.actualizar(libro);
		return ResponseEntity.ok().body(new RestResponse(HttpStatus.OK.value(), "Registro actualizado exitósamente"));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> borrarRegistro(@PathVariable("id") Long id) {
		Optional<Libro> libro = servicio.obtenerRegistro(id);
		if (!libro.isPresent()) {
			return ((BodyBuilder) ResponseEntity.notFound())
					.body(new RestResponse(HttpStatus.NOT_FOUND.value(), "Registro no encontrado para eliminar"));
		}
		this.servicio.borrar(id);

		return ResponseEntity.ok().body(new RestResponse(HttpStatus.OK.value(), "Registro eliminado exitósamente"));
	}

	private boolean esValido(Libro libro) {
		boolean esValido = true;
		if (libro.getTitulo() == null) {
			esValido = false;
		}
		if (libro.getIsbn() == null) {
			esValido = false;
		}
		if (libro.getCategoria() == null) {
			esValido = false;
		}
		return esValido;
	}

}
