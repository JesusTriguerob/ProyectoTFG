package com.tfg.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.tfg.model.entity.Usuario;


public interface UsuarioService {
	
	public List<Usuario> findAll();
	
	public void save(Usuario cliente);
	
	public Usuario findById(Long id);
	
	public void delete(Usuario cliente);

}
