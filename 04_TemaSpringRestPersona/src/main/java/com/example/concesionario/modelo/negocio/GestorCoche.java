package com.example.concesionario.modelo.negocio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.concesionario.modelo.entidad.Coche;
import com.example.concesionario.modelo.persistencia.DaoCoche;

@Service
public class GestorCoche {

	@Autowired
	private DaoCoche daoCoche;

	public List<Coche> listarCoche() {
		List<Coche> lista = daoCoche.findAll();
		return lista;
	}

	public Coche obtenerCoche(int id) {
		Optional<Coche> opt = daoCoche.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		return null;
	}

	public Coche altaCoche(Coche coche) {
		Coche c = null;
		if (Integer.parseInt(coche.getPotencia()) < 0) {
			return null;
		} else {
			c = daoCoche.save(coche);
			return c;
		}
	}

	public Coche modificarCoche(Coche coche) {
		Coche c = daoCoche.save(coche);
		return c;
	}

	public boolean borrarCoche(int id) {
		if (daoCoche.findById(id).isPresent()) {
			return true;
		}
		return false;
	}
}
