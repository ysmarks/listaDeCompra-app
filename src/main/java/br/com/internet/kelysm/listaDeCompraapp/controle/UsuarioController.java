package br.com.internet.kelysm.listaDeCompraapp.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.internet.kelysm.listaDeCompraapp.dao.UsuarioDAO;
import br.com.internet.kelysm.listaDeCompraapp.modelo.Usuario;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {
	
	private final UsuarioDAO dao;
	
	@Autowired
	public UsuarioController(UsuarioDAO dao) {
		this.dao = dao;
	}

	@GetMapping
	public ResponseEntity<?> pegaTodosUsuarios(Pageable pageable) {
		
		return new ResponseEntity<>(dao.findAll(pageable), HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<?> salvar(Usuario usuario) {
		
		return new ResponseEntity<>(dao.save(usuario), HttpStatus.OK);
	}
}
