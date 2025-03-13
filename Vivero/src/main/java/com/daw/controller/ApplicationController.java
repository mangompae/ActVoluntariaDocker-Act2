package com.daw.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daw.model.Arbol;
import com.daw.model.Persona;
import com.daw.service.ApplicationService;

@RestController
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class ApplicationController {
	
	@Autowired
	private ApplicationService servicio;

	@GetMapping(path = "/login",
			params = {"usuario", "password"})
	public ResponseEntity<Persona> login(@RequestParam("usuario") String usuario,
			@RequestParam("password") String password) {
		return ResponseEntity.ok().body(servicio.login(usuario, password));
	}
	
	@PostMapping("/persona")
	public ResponseEntity<Persona> crearPersona(@RequestBody Map<String, String> parameters) {
		return ResponseEntity.ok().body(servicio.crear(parameters.get("nombre"), parameters.get("apellidos"), parameters.get("usuario"), parameters.get("password")));
	}
	
	@GetMapping("/arbol/{codigo}")
	public ResponseEntity<Arbol> buscarArbol(@PathVariable("codigo") String codigo) {
		return ResponseEntity.ok().body(servicio.buscarArbol(codigo));
	}
	
	@GetMapping("/arbol")
	public ResponseEntity<List<Arbol>> buscarArboles(@RequestParam(name = "tipo", required = false) String tipo,
			@RequestParam(name = "tallaje", required = false) Integer tallaje,
			@RequestParam(name = "mesFloracion", required = false) String mesFloracion) {
		return ResponseEntity.ok().body(servicio.buscarArboles(tipo, tallaje, mesFloracion));
	}
	
	@PostMapping("/arbol") 
	public ResponseEntity<Arbol> crearArbol(@RequestBody Map<String, String> parameters) {
		return ResponseEntity.ok().body(servicio.crearArbol(parameters.get("_codigo"),
				parameters.get("_tipoArbol"),
				parameters.get("_especie"),
				Integer.parseInt(parameters.get("_tallaje")),
				parameters.get("_mesFloracion"),
				parameters.get("_frutal")));
	}
	
	@PutMapping("/arbol/{codigo}") 
	public ResponseEntity<Arbol> actualizarTallaje(@PathVariable("codigo") String codigo, @RequestBody Map<String, String> parameters) {
		return ResponseEntity.ok().body(servicio.actualizarTallaje(codigo, Integer.parseInt(parameters.get("tallaje"))));
	}
	
	@DeleteMapping("/arbol/{codigo}")
	public ResponseEntity<String> eliminarArbol(@PathVariable("codigo") String codigo) {
		servicio.eliminarArbol(codigo);
		return ResponseEntity.ok().body("Eliminación Correcta");
	}
	
}
