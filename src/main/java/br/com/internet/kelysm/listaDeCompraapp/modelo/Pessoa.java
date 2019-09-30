package br.com.internet.kelysm.listaDeCompraapp.modelo;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "pessoa")
public  class Pessoa extends EntidadeAbstrata {
	private static final long serialVersionUID = 1L;
	
	 @NotEmpty private String primeiroNome;
	 @NotEmpty private String nomeDoMeio;
	 @NotEmpty private String sobreNome;
	 @NotEmpty private String sexo;
	 private Long idade;
	 
	 
	 
	public Pessoa(@NotEmpty String primeiroNome, @NotEmpty String nomeDoMeio, @NotEmpty String sobreNome,
			@NotEmpty String sexo, Long idade) {
		super();
		this.primeiroNome = primeiroNome;
		this.nomeDoMeio = nomeDoMeio;
		this.sobreNome = sobreNome;
		this.sexo = sexo;
		this.idade = idade;
	}
	public Pessoa() {}
	public String getPrimeiroNome() {
		return primeiroNome;
	}
	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}
	public String getNomeDoMeio() {
		return nomeDoMeio;
	}
	public void setNomeDoMeio(String nomeDoMeio) {
		this.nomeDoMeio = nomeDoMeio;
	}
	public String getSobreNome() {
		return sobreNome;
	}
	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Long getIdade() {
		return idade;
	}
	public void setIdade(Long idade) {
		this.idade = idade;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Pessoa [primeiroNome=" + primeiroNome + ", nomeDoMeio=" + nomeDoMeio + ", sobreNome=" + sobreNome
				+ ", sexo=" + sexo + ", idade=" + idade + "]";
	}
	 
	 


}
