package com.tfg.back.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tfg.back.entity.Libro;
import com.tfg.back.enums.Alquilado;
import com.tfg.back.enums.Estado;
import com.tfg.back.service.LibroService;
import com.tfg.back.service.UsuarioService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class LibroRestController {

	@Autowired
	private LibroService libroService;
	
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/biblioteca")
	public List<Libro> index() {
		return libroService.findAll();
	}
	
	@GetMapping("/biblioteca/alquilado")
	public List<Libro> getBooksForState() {
		return libroService.findAll();
	}
	
	@GetMapping("/biblioteca/{id}")
	public Libro show(@PathVariable Long id) {
		return this.libroService.findById(id);
	}

	@PostMapping("/biblioteca")
	@ResponseStatus(HttpStatus.CREATED)
	public Libro create(@RequestBody Libro libro) {	
		libro.setEstado(Estado.NUEVO);
		libro.setAlquilado(Alquilado.DISPONIBLE);
//		libro.setUsuario("USUARIO LOGUEADO");
		this.libroService.save(libro);
		return libro;
	}

	@PutMapping("/biblioteca/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Libro update(@RequestBody Libro libro, @PathVariable Long id) {
		Libro libroUp = this.libroService.findById(id);
		
		libroUp.setNombre(libro.getNombre());
		libroUp.setTematica(libro.getTematica());
		this.libroService.save(libroUp);
		return libroUp;
	}

	@DeleteMapping("/biblioteca/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		Libro currentLibro = this.libroService.findById(id);
		this.libroService.delete(currentLibro);
	}
	
	@PostMapping("/biblioteca/alquilar")
	@ResponseStatus(HttpStatus.CREATED)
	public Libro alquilar(@RequestBody Libro libro) {	
		libro.setAlquilado(Alquilado.ALQUILADO);
//		libro.setUsuario("USUARIO LOGUEADO");
		this.libroService.save(libro);
		return libro;
	}
}