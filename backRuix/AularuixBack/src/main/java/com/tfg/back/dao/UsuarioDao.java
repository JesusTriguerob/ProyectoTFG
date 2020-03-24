package com.tfg.back.dao;

import org.springframework.data.repository.CrudRepository;

import com.tfg.back.entity.Usuario;

public interface UsuarioDao extends CrudRepository<Usuario, Long>{

}
