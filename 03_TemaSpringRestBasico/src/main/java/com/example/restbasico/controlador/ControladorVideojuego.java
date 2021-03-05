package com.example.restbasico.controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.restbasico.entidad.Videojuego;

public class ControladorVideojuego {
	
	private Videojuego v = new Videojuego();

	@GetMapping("videojuego")
	public Videojuego recuperarVideoJuego() {
		v.setId(1);
		v.setNombre("Sonic");
		v.setCompania("Sega");
		v.setPrecio(30);
		return v;
	}

	@PutMapping("videojuego")
	public Videojuego modificarPrecio() {
		v.setPrecio(v.getPrecio() + 10);
		return v;
	}
}
