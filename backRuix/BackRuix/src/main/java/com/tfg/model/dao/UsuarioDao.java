package com.tfg.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.tfg.model.entity.Usuario;

public interface UsuarioDao extends CrudRepository<Usuario, Long>{

}
