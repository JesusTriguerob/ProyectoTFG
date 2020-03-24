package com.tfg.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tfg.controllers.UsuarioRestController;
import com.tfg.model.dao.UsuarioDao;
import com.tfg.model.entity.Usuario;



@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService{
	
	//Inyección del repository
	@Autowired
	private UsuarioDao usuarioDao; 
	private UsuarioRestController usuarioController;
	
	@Override
	@Transactional(readOnly = true) // evitable en los implementados del dao de spring, obligatorio en las queries propias
	public List<Usuario> findAll() {
		 return (List<Usuario>) usuarioDao.findAll(); //Casteo porque devuelve un Iterable
		 
	}

	@Transactional(readOnly = true)
	@Override
	public Usuario findById(Long id) {
		return usuarioDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Usuario create(Usuario usuario) {
		return usuarioDao.save(usuario);
		
	}

	@Override
	public void delete(Long id) {
		
	}

	@Override
	public void update(Long id) {
		
	}

}
