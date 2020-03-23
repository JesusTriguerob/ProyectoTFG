package com.tfg.model.service;

import java.util.Optional;

import com.tfg.enums.RolNombre;
import com.tfg.model.entity.Rol;

public interface RolService {

	 public Optional<Rol> getByRolNombre(RolNombre rolNombre);
}
