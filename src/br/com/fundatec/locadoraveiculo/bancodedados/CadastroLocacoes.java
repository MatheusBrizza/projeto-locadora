package br.com.fundatec.locadoraveiculo.bancodedados;

import java.util.LinkedList;
import java.util.List;

import br.com.fundatec.locadoraveiculo.model.Locacao;

public class CadastroLocacoes {

	private static CadastroLocacoes instancia;
	private List<Locacao> locacoes;

	private CadastroLocacoes() {
		this.locacoes = new LinkedList<>();
	}

	public static CadastroLocacoes criar() {
		if (instancia == null) {
			instancia = new CadastroLocacoes();
		}
		return instancia;
	}

	public static CadastroLocacoes getInstancia() {
		return instancia;
	}

	public List<Locacao> getLocacao() {
		return locacoes;
	}

	public void adicionar(Locacao locacao) {
		locacoes.add(locacao);
	}

}
