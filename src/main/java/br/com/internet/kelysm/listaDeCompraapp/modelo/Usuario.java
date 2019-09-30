package br.com.internet.kelysm.listaDeCompraapp.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Usuario extends EntidadeAbstrata {

	private static final long serialVersionUID = 1L;
	
	@NotEmpty @Column(unique = true) private String username;
	@NotEmpty @JsonIgnore private String senha;
	@NotEmpty private String nome;
	@NotEmpty private boolean admin;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	
}
