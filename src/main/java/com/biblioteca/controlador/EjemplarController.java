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

import com.biblioteca.dto.AutorDto;
import com.biblioteca.dto.EjemplarDto;
import com.biblioteca.dto.FichaDto;
import com.biblioteca.modelo.Autor;
import com.biblioteca.modelo.Ejemplar;
import com.biblioteca.modelo.Ficha;
import com.biblioteca.modelo.Material;
import com.biblioteca.servicio.implementacion.AutorServicio;
import com.biblioteca.servicio.implementacion.EjemplarServicio;
import com.biblioteca.servicio.implementacion.FichaServicio;
import com.biblioteca.servicio.implementacion.MaterialServicio;
import com.biblioteca.utils.ConvertFicha;
import com.biblioteca.utils.Convertidor;
import com.biblioteca.utils.RestResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin
@RestController
@RequestMapping("/api/ejemplar")
public class EjemplarController {

	@Autowired
	protected EjemplarServicio servicio;
	@Autowired
	protected FichaServicio servicioFicha;
	@Autowired
	protected AutorServicio servicioAutor;
	@Autowired
	protected MaterialServicio servicioMaterial;

	protected ObjectMapper mapeador = new ObjectMapper();

	@GetMapping
	public ResponseEntity<Object> obtenerTodos() {
		List<Ejemplar> ejemplars = this.servicio.todos();
		List<Ficha> fichas = this.servicioFicha.obtenerListaDefichasPorEjemplarId(ejemplars);
		List<FichaDto> fichasDto = ConvertFicha.convertFichaToFichaDto(fichas);
		if (ejemplars.isEmpty()) {
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Object>(fichasDto, HttpStatus.OK);
	}

	@GetMapping("filtrarTitulo/{titulo}")
	public ResponseEntity<Object> filtrarEjemplarPorTitulo(@PathVariable("titulo") String titulo) {
		List<Ejemplar> ejemplars = this.servicio.filtrarPorTitulo(titulo);
		List<Ficha> fichas = this.servicioFicha.obtenerListaDefichasPorEjemplarId(ejemplars);
		List<FichaDto> fichasDto = ConvertFicha.convertFichaToFichaDto(fichas);
		if (ejemplars.isEmpty()) {
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Object>(fichasDto, HttpStatus.OK);
	}

	@GetMapping("porIsbn/{isbn}")
	public ResponseEntity<Object> obtenerPorISBN(@PathVariable("isbn") String isbn) {
		Ejemplar ejemplars = this.servicio.obtenerPorISBN(isbn);
		Ficha fichas = this.servicioFicha.obtenerFichasPorEjemplarId(ejemplars.getId());
		FichaDto fichasDto = new FichaDto(fichas);
		return new ResponseEntity<Object>(fichasDto, HttpStatus.OK);
	}

	@GetMapping("porClasificacion/{clasificacion}")
	public ResponseEntity<Object> obtenerPorCLasificacion(@PathVariable("clasificacion") String clasificacion) {
		List<Ejemplar> ejemplars = this.servicio.obtenerPorClasificacion(clasificacion);
		List<Ficha> fichas = this.servicioFicha.obtenerListaDefichasPorEjemplarId(ejemplars);
		List<FichaDto> fichasDto = ConvertFicha.convertFichaToFichaDto(fichas);
		if (ejemplars.isEmpty()) {
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Object>(fichasDto, HttpStatus.OK);
	}

	@GetMapping("porTitulo/{titulo}")
	public ResponseEntity<List<Ejemplar>> obtenerEjemplarPorTitulo(@PathVariable("titulo") String titulo) {

		List<Ejemplar> ejemplars = this.servicio.obtenerPorTitulo(titulo);
		if (ejemplars.isEmpty()) {
			return new ResponseEntity<List<Ejemplar>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Ejemplar>>(ejemplars, HttpStatus.OK);
	}

	@GetMapping("porAutorId/{autorId}")
	public ResponseEntity<Object> obtenerEjemplarPorAutorId(@PathVariable("autorId") Long autorId) {
		// List<EjemplarDto> ejemplaresDto = this.servicio.obtenerPorAutorId(autorId);
		// Convertidor.convertEjemplarToEjemplarDto(this.servicio.obtenerPorAutorId(autorId));
		Autor autor = this.servicioAutor.obtenerRegistro(autorId).get();
		AutorDto autorDto = new AutorDto(autor);
		if (autorDto.getEjemplares().isEmpty()) {
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Object>(autorDto, HttpStatus.OK);
	}

	@GetMapping("filtrarPorNombreAutor/{autor}")
	public ResponseEntity<Object> obtenerEjemplarPorAutorFiltrado(@PathVariable("autor") String autor) {
		List<Autor> autores = this.servicioAutor.filtrarPorNombre(autor);
		List<EjemplarDto> ejemplares = this.servicio.obtenerEjemplaresDeAutores(autores);
		List<Ficha> fichas = this.servicioFicha.obtenerListaDefichasPorEjemplarDtoId(ejemplares);
		List<FichaDto> fichasDto = ConvertFicha.convertFichaToFichaDto(fichas);
		if (ejemplares.isEmpty()) {
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Object>(fichasDto, HttpStatus.OK);
	}
	
	@GetMapping("filtrarPorMaterial/{material}")
	public ResponseEntity<Object> obtenerEjemplarPorMaterial(@PathVariable("material") String material) {
		List<Material> materiales = this.servicioMaterial.filtrarPorNombre(material);
		List<EjemplarDto> ejemplares = this.servicio.obtenerEjemplaresPorMaterial(materiales);
		List<Ficha> fichas = this.servicioFicha.obtenerListaDefichasPorEjemplarDtoId(ejemplares);
		List<FichaDto> fichasDto = ConvertFicha.convertFichaToFichaDto(fichas);
		if (ejemplares.isEmpty()) {
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Object>(fichasDto, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> obtenerRegistro(@PathVariable("id") Long id) {
		Optional<Ejemplar> ejemplar = this.servicio.obtenerRegistro(id);
		EjemplarDto ejemplarDto = new EjemplarDto(ejemplar.get());
		if (!ejemplar.isPresent()) {
			return ((BodyBuilder) ResponseEntity.notFound())
					.body(new RestResponse(HttpStatus.NOT_FOUND.value(), "Registro no encontrado"));
		}
		return ResponseEntity.ok(ejemplarDto);
	}

	@PostMapping()
	public ResponseEntity<Object> crear(@RequestBody String entidadJSON)
			throws JsonParseException, JsonMappingException, IOException {
		Ejemplar ejemplar = this.mapeador.readValue(entidadJSON, Ejemplar.class);
		if (!esValido(ejemplar)) {
			return ResponseEntity.badRequest().body(
					new RestResponse(HttpStatus.BAD_REQUEST.value(), "Error, Existen campos que son obligatorios."));
		}
		if (ejemplar.getId() != null) {
			return ResponseEntity.badRequest().body(new RestResponse(HttpStatus.BAD_REQUEST.value(),
					"No se debe enviar el ID en la creación de registros, ya que se generan automáticamente."));
		}
		this.servicio.crear(ejemplar);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ejemplar.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> actualizarRegistro(@RequestBody String entidadJSON, @PathVariable Long id)
			throws JsonParseException, JsonMappingException, IOException {
		Ejemplar ejemplar = this.mapeador.readValue(entidadJSON, Ejemplar.class);
		if (id != ejemplar.getId()) {
			return ResponseEntity.badRequest().body(new RestResponse(HttpStatus.BAD_REQUEST.value(),
					"Error, Verifique que el Id del objeto coincida con el id enviado en la ruta /{id}."));
		}
		Optional<Ejemplar> ejemplarEncontrado = servicio.obtenerRegistro(id);
		if (!ejemplarEncontrado.isPresent()) {
			return ((BodyBuilder) ResponseEntity.notFound())
					.body(new RestResponse(HttpStatus.NOT_FOUND.value(), "Registro no encontrado para actualizar"));
		}
		if (!esValido(ejemplar)) {
			return ResponseEntity.badRequest().body(
					new RestResponse(HttpStatus.BAD_REQUEST.value(), "Error, Existen campos que son obligatorios."));
		}

		this.servicio.actualizar(ejemplar);
		return ResponseEntity.ok().body(new RestResponse(HttpStatus.OK.value(), "Registro actualizado exitósamente"));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> borrarRegistro(@PathVariable("id") Long id) {
		Optional<Ejemplar> ejemplar = servicio.obtenerRegistro(id);
		Ficha ficha = this.servicioFicha.obtenerFichasPorEjemplarId(ejemplar.get().getId());
		if (!ejemplar.isPresent()) {
			return ((BodyBuilder) ResponseEntity.notFound())
					.body(new RestResponse(HttpStatus.NOT_FOUND.value(), "Registro no encontrado para eliminar"));
		}
		this.servicioFicha.borrar(ficha.getId());

		return ResponseEntity.ok().body(new RestResponse(HttpStatus.OK.value(), "Registro eliminado exitósamente"));
	}

	private boolean esValido(Ejemplar ejemplar) {
		boolean esValido = true;

		return esValido;
	}

}
