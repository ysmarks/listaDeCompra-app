package br.com.internet.kelysm.listaDeCompraapp.controle;

import java.sql.SQLException;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.internet.kelysm.listaDeCompraapp.dao.PessoaDAO;
import br.com.internet.kelysm.listaDeCompraapp.exception.RecursoNaoEncontradoException;
import br.com.internet.kelysm.listaDeCompraapp.modelo.Pessoa;

@RestController
@RequestMapping("v1")
public class PessoaController {
	
	private final PessoaDAO dao;
	
	@Autowired
	public PessoaController(PessoaDAO dao) {
		this.dao = dao;
	}
	
	@GetMapping(path = "protected")
	public ResponseEntity<?> pegaTodos(Pageable pageable) {
		System.out.println(dao.findAll(pageable));
		return new ResponseEntity<>(dao.findAll(pageable), HttpStatus.OK);
	}
	@GetMapping(path = "protected/{id}")
	public ResponseEntity<?> pegaPorId(@PathVariable("id") Long id) {
		//System.out.println(details);
		verificaSePesssoaExiste(id);
		Optional<Pessoa> pessoa = dao.findById(id);
		return new ResponseEntity<>(pessoa, HttpStatus.OK);
	}
	@GetMapping(path = "protected/nome/{primeiroNome}")
	public ResponseEntity<?> pegaPorNome(@PathVariable("primeiroNome") String nome) {
		
		return new ResponseEntity<>(dao.getByPrimeiroNomeIgnoreCaseContaining(nome), HttpStatus.OK);
	}
	
	@PostMapping(path = "admin")
	public ResponseEntity<?> salvar(@Valid @RequestBody Pessoa pessoa) throws SQLException {
		System.out.println("Registro salvo com sucesso no banco de dados!");
		return new ResponseEntity<>(dao.save(pessoa), HttpStatus.OK);
		
		
	}
	//Metodo put
	@PutMapping(path = "admin")
	public ResponseEntity<?> atualizar(@RequestBody Pessoa pessoa) {
		verificaSePesssoaExiste(pessoa.getId());
		dao.save(pessoa);
		System.out.println("Registro atualizado com sucesso!");
		return new ResponseEntity<>(HttpStatus.OK);
	}
	//Metodo Delete
	@DeleteMapping(path = "admin/{id}")
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		verificaSePesssoaExiste(id);
		dao.deleteById(id);
		System.out.println("Pessoa removida do banco de dados com sucesso!");
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	private void verificaSePesssoaExiste(Long id) {
		System.out.println("Entrou na condição");
		if(dao.findById(id) == null)
			throw new RecursoNaoEncontradoException("Pessoa com id "+ id + " Não encontrado");
	}

}
