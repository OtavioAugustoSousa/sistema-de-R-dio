package br.edu.unicatolica.radio.daos;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.edu.unicatolica.radio.models.Usuario;

@Service
public class UserDetailsServiceDAO implements UserDetailsService {
	@Autowired
	public UsuarioDao  usuarioDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario userInfo = usuarioDao.getByName(username);
		GrantedAuthority authority = new SimpleGrantedAuthority("USER");
		UserDetails userDetails = new User(userInfo.getNomeUsuario(), 
				userInfo.getSenha(), Arrays.asList(authority));
		return userDetails;
	}

}