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

import com.biblioteca.modelo.Autor;
import com.biblioteca.servicio.implementacion.AutorServicio;
import com.biblioteca.utils.RestResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin
@RestController
@RequestMapping("/api/autor")
public class AutorController {

	@Autowired
	protected AutorServicio servicio;

	protected ObjectMapper mapeador = new ObjectMapper();

	@GetMapping
	public ResponseEntity<List<Autor>> obtenerTodos() {
		List<Autor> autors = this.servicio.todos();
		if (autors.isEmpty()) {
			return new ResponseEntity<List<Autor>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Autor>>(autors, HttpStatus.OK);
	}
	
	@GetMapping("/buscarPorNombre/{nombre}")
	public ResponseEntity<List<Autor>> buscarPorNombre(@PathVariable("nombre") String nombre) {
		List<Autor> autors = this.servicio.buscarPorNombre(nombre);
		if (autors.isEmpty()) {
			return new ResponseEntity<List<Autor>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Autor>>(autors, HttpStatus.OK);
	}
	
	@GetMapping("/filtrarPorNombre/{filtro}")
	public ResponseEntity<List<Autor>> filtrarPorNombre(@PathVariable("filtro") String filtro) {
		List<Autor> autors = this.servicio.filtrarPorNombre(filtro);
		if (autors.isEmpty()) {
			return new ResponseEntity<List<Autor>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Autor>>(autors, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> obtenerRegistro(@PathVariable("id") Long id) {
		Autor autor = this.servicio.obtenerRegistro(id).get();
		if (autor == null ) {
			return ((BodyBuilder) ResponseEntity.notFound())
					.body(new RestResponse(HttpStatus.NOT_FOUND.value(), "Registro no encontrado"));
		}
		return ResponseEntity.ok(autor);
	}

	@PostMapping
	public ResponseEntity<Object> crear(@RequestBody String entidadJSON)
			throws JsonParseException, JsonMappingException, IOException {
		Autor autor = this.mapeador.readValue(entidadJSON, Autor.class);
		if (!esValido(autor)) {
			return ResponseEntity.badRequest().body(
					new RestResponse(HttpStatus.BAD_REQUEST.value(), "Error, Existen campos que son obligatorios."));
		}
		if (autor.getId() != null) {
			return ResponseEntity.badRequest().body(new RestResponse(HttpStatus.BAD_REQUEST.value(),
					"No se debe enviar el ID en la creación de registros, ya que se generan automáticamente."));
		}
		this.servicio.crear(autor);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(autor.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> actualizarRegistro(@RequestBody String entidadJSON, @PathVariable Long id)
			throws JsonParseException, JsonMappingException, IOException {
		Autor autor = this.mapeador.readValue(entidadJSON, Autor.class);
		if (id != autor.getId()) {
			return ResponseEntity.badRequest().body(new RestResponse(HttpStatus.BAD_REQUEST.value(),
					"Error, Verifique que el Id del objeto coincida con el id enviado en la ruta /{id}."));
		}
		Optional<Autor> autorEncontrado = servicio.obtenerRegistro(id);
		if (!autorEncontrado.isPresent()) {
			return ((BodyBuilder) ResponseEntity.notFound())
					.body(new RestResponse(HttpStatus.NOT_FOUND.value(), "Registro no encontrado para actualizar"));
		}
		if (!esValido(autor)) {
			return ResponseEntity.badRequest().body(
					new RestResponse(HttpStatus.BAD_REQUEST.value(), "Error, Existen campos que son obligatorios."));
		}
		this.servicio.actualizar(autor);
		return ResponseEntity.ok().body(new RestResponse(HttpStatus.OK.value(), "Registro actualizado exitósamente"));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> borrarRegistro(@PathVariable("id") Long id) {
		Optional<Autor> autor = servicio.obtenerRegistro(id);
		if (!autor.isPresent()) {
			return ((BodyBuilder) ResponseEntity.notFound())
					.body(new RestResponse(HttpStatus.NOT_FOUND.value(), "Registro no encontrado para eliminar"));
		}
		this.servicio.borrar(id);

		return ResponseEntity.ok().body(new RestResponse(HttpStatus.OK.value(), "Registro eliminado exitósamente"));
	}

	private boolean esValido(Autor autor) {
		boolean esValido = true;
		if (autor.getNombre() == null) {
			esValido = false;
		}
		return esValido;
	}

}
