package com.tfg.back.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.tfg.back.entity.Usuario;

public interface UsuarioDao extends PagingAndSortingRepository<Usuario, Long>{

}
