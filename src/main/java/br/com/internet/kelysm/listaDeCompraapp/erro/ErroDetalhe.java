package br.com.internet.kelysm.listaDeCompraapp.erro;

import javax.annotation.Generated;

public class ErroDetalhe  {
	
	private String titulo;
	private int status;
	private String detalhe;
	private long timestemp;
	private String mensagem;

	@Generated("SparkTools")
	private ErroDetalhe(Builder builder) {
		this.titulo = builder.titulo;
		this.status = builder.status;
		this.detalhe = builder.detalhe;
		this.timestemp = builder.timestemp;
		this.mensagem = builder.mensagem;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getDetalhe() {
		return detalhe;
	}
	public void setDetalhe(String detalhe) {
		this.detalhe = detalhe;
	}
	public long getTimestemp() {
		return timestemp;
	}
	public void setTimestemp(long timestemp) {
		this.timestemp = timestemp;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	/**
	 * Creates builder to build {@link ErroDetalhe}.
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}
	/**
	 * Builder to build {@link ErroDetalhe}.
	 */
	@Generated("SparkTools")
	public static final class Builder {
		private String titulo;
		private int status;
		private String detalhe;
		private long timestemp;
		private String mensagem;

		private Builder() {
		}

		public Builder withTitulo(String titulo) {
			this.titulo = titulo;
			return this;
		}

		public Builder withStatus(int status) {
			this.status = status;
			return this;
		}

		public Builder withDetalhe(String detalhe) {
			this.detalhe = detalhe;
			return this;
		}

		public Builder withTimestemp(long timestemp) {
			this.timestemp = timestemp;
			return this;
		}

		public Builder withMensagem(String mensagem) {
			this.mensagem = mensagem;
			return this;
		}

		public ErroDetalhe build() {
			return new ErroDetalhe(this);
		}
	}

	
	
	
}
