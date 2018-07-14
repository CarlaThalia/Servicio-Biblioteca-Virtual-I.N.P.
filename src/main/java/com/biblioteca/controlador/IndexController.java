package com.biblioteca.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlar para iniciar el index.html del servicio
 * @author Daniel
 *
 */
@Controller
public class IndexController {

	@RequestMapping("/")
	public String getIndexPage() {
		return "index";
	}
}
