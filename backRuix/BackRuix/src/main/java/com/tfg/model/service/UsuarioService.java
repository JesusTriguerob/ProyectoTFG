package com.tfg.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.tfg.model.entity.Usuario;

public interface UsuarioService {
	
	public List<Usuario> findAll();
	
	public Usuario findById(Long id);
	
	public Usuario create(Usuario usuario);
	
	public void delete(Long id);
	
	public void update(Long id);
	
	
	

}
