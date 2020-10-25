package com.tfg.back.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.tfg.back.entity.UsuarioOld;

public interface UsuarioDao extends PagingAndSortingRepository<UsuarioOld, Long>{

}
