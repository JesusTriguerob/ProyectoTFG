package com.tfg.repository;

import com.tfg.enums.RolNombre;
import com.tfg.model.entity.Rol;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
	
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}