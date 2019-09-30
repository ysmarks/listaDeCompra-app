package br.com.internet.kelysm.listaDeCompraapp.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.internet.kelysm.listaDeCompraapp.modelo.Pessoa;

public interface PessoaDAO extends PagingAndSortingRepository<Pessoa, Long> {

	List<Pessoa> getByPrimeiroNomeIgnoreCaseContaining(String primeiroNome);
}
