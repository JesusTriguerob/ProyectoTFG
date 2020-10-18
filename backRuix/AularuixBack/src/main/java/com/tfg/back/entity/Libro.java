package com.tfg.back.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.tfg.back.enums.Alquilado;
import com.tfg.back.enums.Estado;

@Entity
@Table(name="libros")
public class Libro implements Serializable {

	private static final long serialVersionUID = -8987273076895521726L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private Long id_usuario;
	
    @NotNull
    private String nombre;
    
    @NotNull
    private String tematica;
    
    @NotNull
    private Estado estado;
    
    @NotNull
    private Alquilado alquilado;

	public Alquilado getAlquilado() {
		return alquilado;
	}

	public void setAlquilado(Alquilado alquilado) {
		this.alquilado = alquilado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTematica() {
		return tematica;
	}

	public void setTematica(String tematica) {
		this.tematica = tematica;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado nuevo) {
		this.estado = nuevo;
	}

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}


}
