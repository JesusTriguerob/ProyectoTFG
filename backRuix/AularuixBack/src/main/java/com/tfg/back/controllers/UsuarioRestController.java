package com.tfg.back.controllers;

import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tfg.back.entity.Usuario;
import com.tfg.back.service.LibroService;
import com.tfg.back.service.UsuarioService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class UsuarioRestController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private LibroService libroService;

	@GetMapping("/usuarios")
	public List<Usuario> index() {
		return usuarioService.findAll();
	}

	@GetMapping("/usuarios/{id}")
	public Usuario show(@PathVariable Long id) {
		return this.usuarioService.findById(id);
	}

	@PostMapping("/usuarios")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario create(@RequestBody Usuario usuario) {	
	//Generador usuario y contraseña aleatorio.
		//nombre usuario = 3 primeras letras de nombre y apellidos y 3 ultimos numeros dni.
		String nomUsu = usuario.getNombre().substring(0,3).concat(usuario.getApellido1().substring(0,3).concat(usuario.getApellido2().substring(0, 3)).concat(usuario.getDni().substring(5, 8)));
		
		//Contraseña = 4 cifras aleatorias.
		int password = (int)(Math.random()*9999 + 1000);
		
		//Rol por defecto = alumno
		if (usuario.getRol() == null) {
			usuario.setRol("alumno");
		}
		
		usuario.setPassword(String.valueOf(password));
		usuario.setNombreUsuario(nomUsu);
		this.usuarioService.save(usuario);
		return usuario;
	}

	@PutMapping("/usuarios/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario update(@RequestBody Usuario usuario, @PathVariable Long id) {
		Usuario usuarioUp = this.usuarioService.findById(id);
		usuarioUp.setNombre(usuario.getNombre());
		usuarioUp.setApellido1(usuario.getApellido1());
		usuarioUp.setApellido2(usuario.getApellido2());
		usuarioUp.setDni(usuario.getDni());
		usuarioUp.setTelefono1(usuario.getTelefono1());
		usuarioUp.setTelefono2(usuario.getTelefono2());
		usuarioUp.setEmail(usuario.getEmail());
		usuarioUp.setCalle(usuario.getCalle());
		usuarioUp.setNumCalle(usuario.getNumCalle());
		usuarioUp.setFechaNac(usuario.getFechaNac());
		usuarioUp.setCodigoPostal(usuario.getCodigoPostal());
		usuarioUp.setLocalidad(usuario.getLocalidad());
		usuarioUp.setProvincia(usuario.getProvincia());
		usuarioUp.setRol(usuario.getRol());
		this.usuarioService.save(usuarioUp);
		return usuarioUp;
	}

	@DeleteMapping("/usuarios/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		Usuario currentCliente = this.usuarioService.findById(id);
		this.usuarioService.delete(currentCliente);
	}
}