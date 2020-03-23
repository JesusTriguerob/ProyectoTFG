package com.tfg.model.service;

import java.util.List;
import java.util.Optional;

import com.tfg.model.entity.Usuario;

public interface UsuarioService {
	
	public List<Usuario> findAll();
	
	public Usuario findById(Long id);
	
	public Usuario save(Usuario usuario);
	
	public void delete(Long id);
	
	public Optional<Usuario> getByNombreUsuario(String nomUsu);
	
	public boolean existePorNombre(String nomUsu);
	
	public boolean existePorEmail(String email);
}
