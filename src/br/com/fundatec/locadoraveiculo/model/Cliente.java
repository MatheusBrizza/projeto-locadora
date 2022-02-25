package br.com.fundatec.locadoraveiculo.model;

import br.com.fundatec.locadoraveiculo.enums.TipoDocumento;
import br.com.fundatec.locadoraveiculo.enums.TipoPessoa;

public class Cliente {

	private TipoPessoa tipoPessoa;
	private String nome;
	private TipoDocumento tipoDocumento;
	private Long documento;
	private String razaoSocial;
	private Long cnpj;
	private Endereco endereco;

	public Cliente (String nome, Long documento, TipoDocumento tipoDocumento, Endereco endereco) {
		this.tipoPessoa = TipoPessoa.FISICA;
		this.nome = nome;
		this.documento = documento;
		this.tipoDocumento = tipoDocumento;
		this.endereco = endereco;
	}
	
	
	public Cliente(String razaoSocial, Long cnpj, Endereco endereco) {
		this.tipoPessoa = TipoPessoa.JURIDICA;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.endereco = endereco;
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getDocumento() {
		return documento;
	}

	public void setDocumento(Long documento) {
		this.documento = documento;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public Long getCnpj() {
		return cnpj;
	}

	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
	@Override
	public String toString() {
		return "Cliente [tipoPessoa=" + tipoPessoa + ", nome=" + nome + ", tipoDocumento=" + tipoDocumento
				+ ", documento=" + documento + ", razaoSocial=" + razaoSocial + ", cnpj=" + cnpj + ", endereco="
				+ endereco + "]";
	}

}
