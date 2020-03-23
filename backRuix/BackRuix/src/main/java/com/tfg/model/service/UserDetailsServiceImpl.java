package com.tfg.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.tfg.model.entity.Usuario;
import com.tfg.security.UsuarioPrincipal;

/**
 * Clase implementada para hacer uso de la entity generada en Uuario principal.
 * @author Jesus
 *
 */
public class UserDetailsServiceImpl implements UserDetailsService{

	//Inyectamos el servicio de usuario
	@Autowired
    UsuarioService usuarioService;
	
	@Override
	@Transactional //Defino transacional porque vamos a operar sobre la BD por medio del UsuarioService
	public UserDetails loadUserByUsername(String nomUsu) throws UsernameNotFoundException {
		Usuario usuario = usuarioService.getByNombreUsuario(nomUsu).get();
        return UsuarioPrincipal.build(usuario);
	}

}
