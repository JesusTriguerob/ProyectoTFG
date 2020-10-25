package com.tfg.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tfg.back.dao.UsuarioDao;
import com.tfg.back.entity.UsuarioOld;


@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioDao usuarioDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<UsuarioOld> findAll() {
		return (List<UsuarioOld>) usuarioDao.findAll();
	}

	@Override
	@Transactional
	public void save(UsuarioOld usuario) {
		usuarioDao.save(usuario);
	}

	@Override
	@Transactional(readOnly = true)
	public UsuarioOld findById(Long id) {
		return usuarioDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(UsuarioOld cliente) {
		usuarioDao.delete(cliente);
		
	}

}
