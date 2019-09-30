package br.com.internet.kelysm.listaDeCompraapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.internet.kelysm.listaDeCompraapp.dao.UsuarioDAO;
import br.com.internet.kelysm.listaDeCompraapp.modelo.Usuario;

@Component
public class UsuarioCustomizadoDetalhesService implements UserDetailsService {

	private final UsuarioDAO dao;
	
	@Autowired
	public UsuarioCustomizadoDetalhesService(UsuarioDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = dao.getByUsername(username);
		List<GrantedAuthority> authorizaListaAdmin = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
		List<GrantedAuthority> authorizaListaUsuario = AuthorityUtils.createAuthorityList("ROLE_USER");
		return new User(usuario.getUsername(), usuario.getSenha(), usuario.isAdmin() ? authorizaListaAdmin : authorizaListaUsuario);
	}

}
