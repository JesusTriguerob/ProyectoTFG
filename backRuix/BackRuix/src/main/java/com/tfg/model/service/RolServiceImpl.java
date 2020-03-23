package com.tfg.model.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tfg.enums.RolNombre;
import com.tfg.model.entity.Rol;
import com.tfg.repository.RolRepository;

@Service
@Transactional
public class RolServiceImpl implements RolService{

	@Autowired
    RolRepository rolRepository;
	
	@Override
	public Optional<Rol> getByRolNombre(RolNombre rolNombre) {	
		return rolRepository.findByRolNombre(rolNombre);
	}

}
