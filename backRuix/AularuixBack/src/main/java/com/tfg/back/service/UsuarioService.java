package com.tfg.back.service;

import java.util.List;

import com.tfg.back.entity.Usuario;

public interface UsuarioService {
	
	public List<Usuario> findAll();
	
	public void save(Usuario usuario);
	
	public Usuario findById(Long id);
	
	public void delete(Usuario usuario);

}

