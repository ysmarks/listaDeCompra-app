package br.com.internet.kelysm.listaDeCompraapp.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.internet.kelysm.listaDeCompraapp.modelo.Usuario;

public interface UsuarioDAO extends PagingAndSortingRepository<Usuario, Long> {
	
	Usuario getByUsername(String nome);

}
