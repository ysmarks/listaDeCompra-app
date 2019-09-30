package br.com.internet.kelysm.listaDeCompraapp.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.internet.kelysm.listaDeCompraapp.erro.ErroDetalhe;
import br.com.internet.kelysm.listaDeCompraapp.exception.RecursoNaoEncontradoException;

/**
 * 
 * @author ysantos
 *
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(RecursoNaoEncontradoException.class)
	public ResponseEntity<?> handler(RecursoNaoEncontradoException recursoNaoEncontradoException) {
		ErroDetalhe erroDetalhe = ErroDetalhe.builder()
		.withTitulo(recursoNaoEncontradoException.getMessage())
		.withDetalhe("Teste")
		.withStatus(HttpStatus.NOT_FOUND.value())
		.withTimestemp(new Date().getTime())
		.withMensagem(recursoNaoEncontradoException.getMessage())
		.build();
		
		return new ResponseEntity<>(erroDetalhe, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handler(Exception recursoNaoEncontradoException) {
		ErroDetalhe erroDetalhe = ErroDetalhe.builder()
		.withTitulo(recursoNaoEncontradoException.getMessage())
		.withDetalhe("Teste")
		.withStatus(HttpStatus.NOT_FOUND.value())
		.withTimestemp(new Date().getTime())
		.withMensagem(recursoNaoEncontradoException.getMessage())
		.build();
		
		return new ResponseEntity<>(erroDetalhe, HttpStatus.NOT_FOUND);
	}
}
