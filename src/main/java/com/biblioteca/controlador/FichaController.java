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

import com.biblioteca.dto.FichaDto;
import com.biblioteca.modelo.Ejemplar;
import com.biblioteca.modelo.Ficha;
import com.biblioteca.servicio.implementacion.EjemplarServicio;
import com.biblioteca.servicio.implementacion.FichaServicio;
import com.biblioteca.utils.ConvertFicha;
import com.biblioteca.utils.RestResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin
@RestController
@RequestMapping("/api/ficha")
public class FichaController {

	@Autowired
	protected FichaServicio servicio;
	@Autowired
	protected EjemplarServicio servicioEjemplar;

	protected ObjectMapper mapeador = new ObjectMapper();

	@GetMapping
	public ResponseEntity<Object> obtenerTodos() {
		List<Ficha> fichas = this.servicio.todos();
		List<FichaDto> fichasDto = ConvertFicha.convertFichaToFichaDto(fichas);
		if (fichas.isEmpty()) {
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Object>(fichasDto, HttpStatus.OK);
	}

	@GetMapping("/obtenerFichasConEjemplar/{id}")
	public ResponseEntity<Ficha> obtenerTodosConEjemplar(@PathVariable String id) {
		Ficha fichas = this.servicio.obtenerFichasPorEjemplarId(Long.parseLong(id));
		if (fichas == null) {
			return new ResponseEntity<Ficha>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Ficha>(fichas, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> obtenerRegistro(@PathVariable("id") Long id) {
		Optional<Ficha> ficha = this.servicio.obtenerRegistro(id);
		if (!ficha.isPresent()) {
			return ((BodyBuilder) ResponseEntity.notFound())
					.body(new RestResponse(HttpStatus.NOT_FOUND.value(), "Registro no encontrado"));
		}
		return ResponseEntity.ok(ficha);
	}

	@PostMapping("/crearFichaEjemplarId")
	public ResponseEntity<Object> crearConEjemplarId(@RequestBody String entidadJSON)
			throws JsonParseException, JsonMappingException, IOException {

		FichaDto fichaDto = this.mapeador.readValue(entidadJSON, FichaDto.class);
		Optional<Ejemplar> ejemplar = servicioEjemplar.obtenerRegistro(fichaDto.getEjemplar_id());
		if (!ejemplar.isPresent()) {
			return ((BodyBuilder) ResponseEntity.notFound())
					.body(new RestResponse(HttpStatus.BAD_REQUEST.value(), "Es necesario ejemplarId para realizar su petición"));
		}
		Ficha ficha = new Ficha(fichaDto, ejemplar.get());

		if (!esValido(ficha)) {
			return ResponseEntity.badRequest().body(
					new RestResponse(HttpStatus.BAD_REQUEST.value(), "Error, Existen campos que son obligatorios."));
		}
		if (ficha.getId() != null) {
			return ResponseEntity.badRequest().body(new RestResponse(HttpStatus.BAD_REQUEST.value(),
					"No se debe enviar el ID en la creación de registros, ya que se generan automáticamente."));
		}
		this.servicio.crear(ficha);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ficha.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping
	public ResponseEntity<Object> crear(@RequestBody String entidadJSON)
			throws JsonParseException, JsonMappingException, IOException {

		Ficha ficha = this.mapeador.readValue(entidadJSON, Ficha.class);
		if (!esValido(ficha)) {
			return ResponseEntity.badRequest().body(
					new RestResponse(HttpStatus.BAD_REQUEST.value(), "Error, Existen campos que son obligatorios."));
		}
		if (ficha.getId() != null) {
			return ResponseEntity.badRequest().body(new RestResponse(HttpStatus.BAD_REQUEST.value(),
					"No se debe enviar el ID en la creación de registros, ya que se generan automáticamente."));
		}
		this.servicio.crear(ficha);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ficha.getId())
				.toUri();
		return ResponseEntity.ok().body(new RestResponse(HttpStatus.OK.value(), location.toString()));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> actualizarRegistro(@RequestBody String entidadJSON, @PathVariable Long id)
			throws JsonParseException, JsonMappingException, IOException {
		Ficha ficha = this.mapeador.readValue(entidadJSON, Ficha.class);
		if (id != ficha.getId()) {
			return ResponseEntity.badRequest().body(new RestResponse(HttpStatus.BAD_REQUEST.value(),
					"Error, Verifique que el Id del objeto coincida con el id enviado en la ruta /{id}."));
		}
		Optional<Ficha> fichaEncontrado = servicio.obtenerRegistro(id);
		if (!fichaEncontrado.isPresent()) {
			return ((BodyBuilder) ResponseEntity.notFound())
					.body(new RestResponse(HttpStatus.NOT_FOUND.value(), "Registro no encontrado para actualizar"));
		}
		if (!esValido(ficha)) {
			return ResponseEntity.badRequest().body(
					new RestResponse(HttpStatus.BAD_REQUEST.value(), "Error, Existen campos que son obligatorios."));
		}

		this.servicio.actualizar(ficha);
		return ResponseEntity.ok().body(new RestResponse(HttpStatus.OK.value(), "Registro actualizado exitósamente"));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> borrarRegistro(@PathVariable("id") Long id) {
		Optional<Ficha> ficha = servicio.obtenerRegistro(id);
		if (!ficha.isPresent()) {
			return ((BodyBuilder) ResponseEntity.notFound())
					.body(new RestResponse(HttpStatus.NOT_FOUND.value(), "Registro no encontrado para eliminar"));
		}
		this.servicio.borrar(id);

		return ResponseEntity.ok().body(new RestResponse(HttpStatus.OK.value(), "Registro eliminado exitósamente"));
	}

	private boolean esValido(Ficha ficha) {
		boolean esValido = true;

		return esValido;
	}
}
