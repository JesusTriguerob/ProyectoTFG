package com.tfg.back.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tfg.back.security.entity.Rol;
import com.tfg.back.security.enums.RolNombre;
import com.tfg.back.security.repository.RolRepository;

@Service
@Transactional
public class RolService {
	
	@Autowired
	RolRepository rolRepository;

	public Optional<Rol> getByRolNombre(RolNombre rolnombre){
		
		return rolRepository.findByRolNombre(rolnombre);
	}
	
	public void save(Rol rol) {
		rolRepository.save(rol);
	}
}
