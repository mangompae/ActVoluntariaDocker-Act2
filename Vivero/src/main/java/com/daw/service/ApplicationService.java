package com.daw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.model.Arbol;
import com.daw.model.Persona;
import com.daw.repository.ArbolRepository;
import com.daw.repository.PersonaRepository;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class ApplicationService {
	
	@Autowired
	private PersonaRepository personaRepository;
	@Autowired
	private ArbolRepository arbolRepository;
	
	public Persona login(String usuario, String password) {
		return personaRepository.findByUsuarioAndPassword(usuario, password);
	}
	
	public Persona crear(String nombre, String apellidos, String usuario, String password) {
		Persona persona = new Persona();		
		persona.setNombre(nombre);
		persona.setApellidos(apellidos);
		persona.setUsuario(usuario);
		persona.setPassword(password);		
		return personaRepository.save(persona);		
	}
	
	public Arbol buscarArbol(String codigo) {
		return arbolRepository.findByCodigo(codigo);
	}
	
	public List<Arbol> buscarArboles(String tipoArbol, Integer tallaje, String mesFloracion) {
		return arbolRepository.findArboles(tipoArbol, tallaje, mesFloracion);
	}
	
	public Arbol crearArbol(String codigo, String tipoArbol, String especie, Integer tallaje, String mesFloracion, String floral) {
		Arbol arbol = new Arbol();
		arbol.setCodigo(codigo);
		arbol.setTipoArbol(tipoArbol);
		arbol.setEspecie(especie);
		arbol.setTallaje(tallaje);
		arbol.setMesFloracion(mesFloracion);
		arbol.setFloral(floral);
		arbolRepository.save(arbol);
		return arbol;
	}
	
	public Arbol actualizarTallaje(String codigo, Integer tallaje) {
		Arbol arbol = arbolRepository.findByCodigo(codigo);
		arbol.setTallaje(tallaje);
		arbolRepository.save(arbol);
		return arbol;
	}
	
	public void eliminarArbol(String codigo) {
		Arbol arbol = arbolRepository.findByCodigo(codigo);
		arbolRepository.delete(arbol);
	}
	
	
}
