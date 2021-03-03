package com.example.restbasico.controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.restbasico.entidad.Videojuego;

public class ControladorMensaje {
	private Videojuego v;
	/*
	 * private String mensaje = "Esto es un mensaje de prueba";
	 * 
	 * // para acceder http://localhost:8090/mensaje
	 * 
	 * @GetMapping("mensaje") public String obtenerMensaje() { return mensaje;
	 * 
	 * }
	 */

	// http://localhost:8090/videojuego
	@GetMapping("videojuego")
	public Videojuego sacarVideoJuego() {
		v = new Videojuego();
		v.setId(1);
		v.setNombre("Fifa 2021");
		v.setCompania("EA Sport");
		v.setPrecio(60);
		return v;
	}

	@PutMapping("videojuego")
	public Videojuego cambiarPrecio() {
		v.setPrecio(v.getPrecio() + 10);
		return v;
	}
}
