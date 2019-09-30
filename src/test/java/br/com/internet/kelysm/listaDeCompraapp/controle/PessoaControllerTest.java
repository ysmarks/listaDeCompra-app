package br.com.internet.kelysm.listaDeCompraapp.controle;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.internet.kelysm.listaDeCompraapp.dao.PessoaDAO;
import br.com.internet.kelysm.listaDeCompraapp.modelo.Pessoa;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PessoaControllerTest {
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PessoaDAO dao;
	
	@TestConfiguration
	static class Config {
		@Bean
		public RestTemplateBuilder restTemplateBuilder() {
			return new RestTemplateBuilder().basicAuthentication("ysmarks", "senha2019");
		}
	}

	@Test
	public void listaPessoasComUsuarioSenhaIncorretoStatusCodigo401() {
		System.out.println(port);
		testRestTemplate = testRestTemplate.withBasicAuth("1", "1");
		ResponseEntity<String> response = testRestTemplate.getForEntity("/v1/protected", String.class);
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(401);
	}
	@Test
	public void listaPessoasComUsuarioSenhaCorretoStatusCodigo200() {
		Iterable<Pessoa> pessoas =  Arrays.asList(new Pessoa("Ysmarks", "Santos", "Santos", "m", 31l));
		BDDMockito.when(dao.findAll()).thenReturn(pessoas);
		ResponseEntity<String> response = testRestTemplate.getForEntity("/v1/protected", String.class);
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);
	}

}
