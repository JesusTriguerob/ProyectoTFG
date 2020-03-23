package com.tfg.security;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.tfg.model.entity.Usuario;
 /**
  * Clase implementada para la autentificación, 
  * el metodo build crea una lista de privilegios y 
  * la asigna al usuario principal que devuelte el metodo
  * 
  * @author Jesus
  *
  */
public class UsuarioPrincipal implements UserDetails {

	
	private static final long serialVersionUID = 8541706094607972229L;
	
	private Long id;
    private String nombre;
    private String nombreUsuario;
    private String email;
    private String password;
    private String apellido1;
    private String apellido2;
    private String dni;
    private String calle;
	private String numCalle;
    private String telefono1;
    private String telefono2;
	private Date fechaNac;
    private String localidad;
    private String provincia;
    private String codigoPostal;
    private Collection<? extends GrantedAuthority> authorities;

	public UsuarioPrincipal(Long id, String nombre, String nombreUsuario, String email, String password,
			String apellido1, String apellido2, String dni, String calle, String numCalle, String telefono1,
			String telefono2, Date fechaNac, String localidad, String provincia, String codigoPostal,
			Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    	this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
		this.calle = calle;
		this.numCalle = numCalle;
		this.telefono1 = telefono1;
		this.telefono2 = telefono2;
		this.fechaNac = fechaNac;
		this.localidad = localidad;
		this.provincia = provincia;
		this.codigoPostal = codigoPostal;
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.password = password;
    }

    public static UsuarioPrincipal build(Usuario usuario){
        List<GrantedAuthority> authorities =
                usuario.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol.getRolNombre().name())).collect(Collectors.toList());
        return new UsuarioPrincipal(usuario.getId(), usuario.getNombre(), usuario.getNombreUsuario(), usuario.getEmail(), usuario.getPassword(),
        		usuario.getApellido1(), usuario.getApellido2(), usuario.getDni(), usuario.getCalle(), usuario.getNumCalle(), usuario.getTelefono1(),
        		usuario.getTelefono2(), usuario.getFechaNac(), usuario.getLocalidad(), usuario.getProvincia(), usuario.getCodigoPostal(),
        		authorities);
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getNombreUsuario() {
		return nombreUsuario;
	}

	public String getApellido1() {
		return apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public String getDni() {
		return dni;
	}

	public String getCalle() {
		return calle;
	}

	public String getNumCalle() {
		return numCalle;
	}

	public String getTelefono1() {
		return telefono1;
	}

	public String getTelefono2() {
		return telefono2;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public String getLocalidad() {
		return localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}
	
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return nombreUsuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
