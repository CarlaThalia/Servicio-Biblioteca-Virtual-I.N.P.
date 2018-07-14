package com.biblioteca.servicio.implementacion;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.biblioteca.modelo.Usuario;
import com.biblioteca.repositorio.IUsuarioRepositorio;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServicio implements UserDetailsService {

	   private IUsuarioRepositorio repositorioUsuario;

	    public UserDetailsServicio(IUsuarioRepositorio repositorioUsuario) {
	        this.repositorioUsuario = repositorioUsuario;
	    }

	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        Usuario user = repositorioUsuario.findByUsername(username);
	        if (user == null) {
	            throw new UsernameNotFoundException(username);
	        }
	        return new User(user.getUsername(), user.getPassword(), emptyList());
	    }
	
}
