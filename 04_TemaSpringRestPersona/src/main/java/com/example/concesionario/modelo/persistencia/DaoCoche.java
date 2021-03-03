package com.example.concesionario.modelo.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.concesionario.modelo.entidad.Coche;

@Repository
public interface DaoCoche extends JpaRepository<Coche, Integer>{

}
