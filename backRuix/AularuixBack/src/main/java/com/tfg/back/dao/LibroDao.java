package com.tfg.back.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.tfg.back.entity.Libro;

public interface LibroDao extends PagingAndSortingRepository<Libro, Long>{

}
