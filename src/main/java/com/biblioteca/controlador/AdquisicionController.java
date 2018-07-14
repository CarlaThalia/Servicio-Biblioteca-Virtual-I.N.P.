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

import com.biblioteca.dto.AdquisicionDto;
import com.biblioteca.modelo.Adquisicion;
import com.biblioteca.servicio.implementacion.AdquisicionServicio;
import com.biblioteca.servicio.implementacion.FichaServicio;
import com.biblioteca.utils.RestResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin
@RestController
@RequestMapping("/api/adquisicion")
public class AdquisicionController {

	@Autowired
	protected AdquisicionServicio servicio;
	@Autowired
	protected FichaServicio servicioFicha;
	protected ObjectMapper mapeador = new ObjectMapper();

	@GetMapping
	public ResponseEntity<List<Adquisicion>> obtenerTodos() {
		List<Adquisicion> adquisicions = this.servicio.todos();
		if (adquisicions.isEmpty()) {
			return new ResponseEntity<List<Adquisicion>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Adquisicion>>(adquisicions, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> obtenerRegistro(@PathVariable("id") Long id) {
		Optional<Adquisicion> adquisicion = this.servicio.obtenerRegistro(id);
		AdquisicionDto adquisicionDto = new AdquisicionDto(adquisicion.get());
		if (!adquisicion.isPresent()) {
			return ((BodyBuilder) ResponseEntity.notFound())
					.body(new RestResponse(HttpStatus.NOT_FOUND.value(), "Registro no encontrado"));
		}
		return ResponseEntity.ok(adquisicionDto);
	}
	
	@GetMapping("/ObtenerPorCodAdquisicion/{cod_adquisicion}")
	public ResponseEntity<Object> obtenerAdquisicionPorCodigo(@PathVariable("cod_adquisicion") String cod_adquisicion) {
		Adquisicion adquisicion = this.servicio.obtenerAdquisicionPorCodAdquisicion(cod_adquisicion).get();
		AdquisicionDto adquisicionDto = new AdquisicionDto(adquisicion);
		if (adquisicion == null) {
			return ((BodyBuilder) ResponseEntity.notFound())
					.body(new RestResponse(HttpStatus.NOT_FOUND.value(), "Registro no encontrado"));
		}
		return ResponseEntity.ok(adquisicionDto);
	}

	@PostMapping()
	public ResponseEntity<Object> crear(@RequestBody String entidadJSON)
			throws JsonParseException, JsonMappingException, IOException {
		Adquisicion adquisicion = this.mapeador.readValue(entidadJSON, Adquisicion.class);
		if (!esValido(adquisicion)) {
			return ResponseEntity.badRequest().body(
					new RestResponse(HttpStatus.BAD_REQUEST.value(), "Error, Existen campos que son obligatorios."));
		}
		if (adquisicion.getId() != null) {
			return ResponseEntity.badRequest().body(new RestResponse(HttpStatus.BAD_REQUEST.value(),
					"No se debe enviar el ID en la creación de registros, ya que se generan automáticamente."));
		}
		this.servicio.crear(adquisicion);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(adquisicion.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> actualizarRegistro(@RequestBody String entidadJSON, @PathVariable Long id)
			throws JsonParseException, JsonMappingException, IOException {
		Adquisicion adquisicion = this.mapeador.readValue(entidadJSON, Adquisicion.class);
		if (id != adquisicion.getId()) {
			return ResponseEntity.badRequest().body(new RestResponse(HttpStatus.BAD_REQUEST.value(),
					"Error, Verifique que el Id del objeto coincida con el id enviado en la ruta /{id}."));
		}
		Optional<Adquisicion> adquisicionEncontrado = servicio.obtenerRegistro(id);
		if (!adquisicionEncontrado.isPresent()) {
			return ((BodyBuilder) ResponseEntity.notFound())
					.body(new RestResponse(HttpStatus.NOT_FOUND.value(), "Registro no encontrado para actualizar"));
		}
		if (!esValido(adquisicion)) {
			return ResponseEntity.badRequest().body(
					new RestResponse(HttpStatus.BAD_REQUEST.value(), "Error, Existen campos que son obligatorios."));
		}

		this.servicio.actualizar(adquisicion);
		return ResponseEntity.ok().body(new RestResponse(HttpStatus.OK.value(), "Registro actualizado exitósamente"));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> borrarRegistro(@PathVariable("id") Long id) {
		Optional<Adquisicion> adquisicion = servicio.obtenerRegistro(id);
		if (!adquisicion.isPresent()) {
			return ((BodyBuilder) ResponseEntity.notFound())
					.body(new RestResponse(HttpStatus.NOT_FOUND.value(), "Registro no encontrado para eliminar"));
		}
		this.servicio.borrar(id);

		return ResponseEntity.ok().body(new RestResponse(HttpStatus.OK.value(), "Registro eliminado exitósamente"));
	}

	private boolean esValido(Adquisicion adquisicion) {
		boolean esValido = true;
		
		return esValido;
	}

}
