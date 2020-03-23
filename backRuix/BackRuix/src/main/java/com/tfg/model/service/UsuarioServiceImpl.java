package com.tfg.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tfg.model.dao.UsuarioDao;
import com.tfg.model.entity.Usuario;
import com.tfg.repository.UsuarioRepository;


@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService{
	
	//Inyección del repository
	@Autowired
	private UsuarioRepository usuarioRepository;
	private UsuarioDao usuarioDao; 
	
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
	public Usuario save(Usuario usuario) {
		usuarioRepository.save(usuario); //TODO mirar si es lo mismo.
		return usuarioDao.save(usuario);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		usuarioDao.deleteById(id);
	}

	@Override
	public Optional<Usuario> getByNombreUsuario(String nomUsu) {
		return usuarioRepository.findByNombreUsuario(nomUsu);
	}

	@Override
	public boolean existePorNombre(String nomUsu) {
		return usuarioRepository.existsByNombreUsuario(nomUsu);
	}

	@Override
	public boolean existePorEmail(String email) {
		return usuarioRepository.existsByEmail(email);
	}

}
