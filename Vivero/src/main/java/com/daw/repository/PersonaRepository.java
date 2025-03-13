package com.daw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daw.model.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long>{
	
	public Persona findByUsuarioAndPassword(String usuario, String password);

}
