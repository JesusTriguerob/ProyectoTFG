package com.tfg.back.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.tfg.back.entity.Usuario;

public interface UsuarioDao extends PagingAndSortingRepository<Usuario, Long>{

}
