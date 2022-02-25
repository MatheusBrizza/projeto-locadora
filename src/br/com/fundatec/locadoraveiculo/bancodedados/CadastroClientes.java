package br.com.fundatec.locadoraveiculo.bancodedados;

import java.util.LinkedList;
import java.util.List;

import br.com.fundatec.locadoraveiculo.model.Cliente;

public class CadastroClientes {

	private static CadastroClientes instancia;
	private List<Cliente> clientes;

	private CadastroClientes() {
		this.clientes = new LinkedList<>();
	}

	public static CadastroClientes criar() {
		if (instancia == null) {
			instancia = new CadastroClientes();
		}
		return instancia;
	}

	public static CadastroClientes getInstancia() {
		return instancia;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void adicionar(Cliente cliente) {
		clientes.add(cliente);
	}

}
