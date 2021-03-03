package com.example.concesionario.controlador;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.concesionario.modelo.entidad.Coche;
import com.example.concesionario.modelo.negocio.GestorCoche;

@RestController
public class ControladorCoche {
	@Autowired
	private GestorCoche negocio;

	@GetMapping("coche")
	public ResponseEntity<List<Coche>> listar() {
		List<Coche> lista = negocio.listarCoche();
		ResponseEntity<List<Coche>> resp = new ResponseEntity<List<Coche>>(lista, HttpStatus.OK);
		return resp;
	}

	@GetMapping("coche/{id}")
	public ResponseEntity<Coche> obtener(@PathVariable("id") int id) {
		Coche c = negocio.obtenerCoche(id);
		HttpStatus hp = null;
		if (c != null) {
			hp = HttpStatus.OK;
		} else {
			hp = HttpStatus.NOT_FOUND;
		}
		ResponseEntity<Coche> resp = new ResponseEntity<Coche>(c, hp);
		return resp;
	}

	@PostMapping("coche")
	public ResponseEntity<Coche> alta(@RequestBody Coche coche) throws SQLIntegrityConstraintViolationException {
		Coche c = negocio.altaCoche(coche);
		HttpStatus hp = null;
		if (c != null) {
			hp = HttpStatus.CREATED;
		} else {
			hp = HttpStatus.BAD_REQUEST;
		}
		ResponseEntity<Coche> resp = new ResponseEntity<Coche>(c, hp);
		return resp;
	}

	@PutMapping("coche/{id}")
	public ResponseEntity<Coche> modificar(@PathVariable("id") int id, @RequestBody Coche coche) {
		coche.setId(id);
		Coche c = negocio.modificarCoche(coche);
		HttpStatus hp = null;
		if (c != null) {
			hp = HttpStatus.OK;
		} else {
			hp = HttpStatus.BAD_REQUEST;
		}
		ResponseEntity<Coche> resp = new ResponseEntity<Coche>(c, hp);
		return resp;
	}

	@DeleteMapping("coche/{id}")
	public ResponseEntity<Integer> borrar(@PathVariable("id") int id) {
		boolean borrado = negocio.borrarCoche(id);
		HttpStatus hp = null;
		if (borrado) {
			hp = HttpStatus.CREATED;
		} else {
			hp = HttpStatus.BAD_REQUEST;
		}
		ResponseEntity<Integer> resp = new ResponseEntity<Integer>(id, hp);
		return resp;
	}
}
