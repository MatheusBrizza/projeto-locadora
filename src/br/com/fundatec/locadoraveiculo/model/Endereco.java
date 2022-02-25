package br.com.fundatec.locadoraveiculo.model;

public class Endereco {

	private String uf;
	private String cidade;
	private Integer cep;
	private String logradouro;
	private Integer numero;
	private String complemento;
	private String bairro;

	public Endereco(String uf, String cidade, Integer cep, String logradouro, Integer numero, String complemento,
			String bairro) {
		super();
		this.uf = uf;
		this.cidade = cidade;
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	@Override
	public String toString() {
		return "Endereco [uf=" + uf + ", cidade=" + cidade + ", cep=" + cep + ", logradouro=" + logradouro + ", numero="
				+ numero + ", complemento=" + complemento + ", bairro=" + bairro + "]";
	}

	public static Endereco valueOf(String endereco) {
		// TODO Auto-generated method stub
		return null;
	}

}
