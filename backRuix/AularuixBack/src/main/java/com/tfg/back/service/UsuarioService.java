package com.tfg.back.service;

import java.util.List;

import com.tfg.back.entity.UsuarioOld;

public interface UsuarioService {
	
	public List<UsuarioOld> findAll();
	
	public void save(UsuarioOld usuario);
	
	public UsuarioOld findById(Long id);
	
	public void delete(UsuarioOld usuario);

}

