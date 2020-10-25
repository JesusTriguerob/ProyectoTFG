package com.tfg.back.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tfg.back.security.entity.Rol;
import com.tfg.back.security.enums.RolNombre;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{

	Optional<Rol> findByRolNombre(RolNombre rolnombre);
}
