package br.com.internet.kelysm.listaDeCompraapp.dao;

import static org.junit.Assert.*;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.internet.kelysm.listaDeCompraapp.modelo.Pessoa;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class PessoaDAOTest {
	
	@Autowired
	private PessoaDAO dao; 
	
	@Rule
	public ExpectedException expectedException;

	@Test
	public void criarPessoaTest() {
		Pessoa pessoa = new Pessoa();
		pessoa.setIdade(31l);
		pessoa.setPrimeiroNome("Ysmarks");
		pessoa.setNomeDoMeio("Silva");
		pessoa.setSobreNome("Santos");
		pessoa.setSexo("m");
		this.dao.save(pessoa);
		
		Assertions.assertThat(pessoa.getId()).isNotNull();
		Assertions.assertThat(pessoa.getIdade()).isEqualTo(31l);
		Assertions.assertThat(pessoa.getPrimeiroNome()).isEqualTo("Ysmarks");
		Assertions.assertThat(pessoa.getNomeDoMeio()).isEqualTo("Silva");
		Assertions.assertThat(pessoa.getSobreNome()).isEqualTo("Santos");
		Assertions.assertThat(pessoa.getSexo()).isEqualTo("m");
	}
	@Test
	public void deletarPessoaTest() {
		Pessoa pessoa = new Pessoa();
		pessoa.setIdade(31l);
		pessoa.setPrimeiroNome("Ysmarks");
		pessoa.setNomeDoMeio("Silva");
		pessoa.setSobreNome("Santos");
		pessoa.setSexo("m");
		this.dao.save(pessoa);
		this.dao.delete(pessoa);
		
		Assertions.assertThat(dao.findById(pessoa.getId())).isNull();
	}
	
	@Test
	public void atualizarPessoaTeste() {
		Pessoa pessoa = new Pessoa();
		pessoa.setIdade(20l);
		pessoa.setPrimeiroNome("Teste");
		pessoa.setNomeDoMeio("meioTeste");
		pessoa.setSobreNome("fimTeste");
		pessoa.setSexo("m");
		dao.save(pessoa);
		pessoa.setPrimeiroNome("Kelly");
		pessoa.setNomeDoMeio("Pliveira");
		dao.save(pessoa);
		
		Assertions.assertThat(pessoa.getPrimeiroNome()).isEqualTo("Kelly");
		Assertions.assertThat(pessoa.getNomeDoMeio()).isEqualTo("Pliveira");
	}
	

}
