package br.com.fundatec.locadoraveiculo.bancodedados;

import java.util.LinkedList;
import java.util.List;

import br.com.fundatec.locadoraveiculo.model.Veiculo;

public class CadastroVeiculos {

	private static CadastroVeiculos instancia;
	private List<Veiculo> veiculos;

	private CadastroVeiculos() {
		this.veiculos = new LinkedList<>();
	}

	public static CadastroVeiculos criar() {
		if (instancia == null) {
			instancia = new CadastroVeiculos();
		}
		return instancia;
	}

	public static CadastroVeiculos getInstancia() {
		return instancia;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void adicionar(Veiculo veiculo) {
		veiculos.add(veiculo);
	}

}
