package br.com.fundatec.locadoraveiculo.tela;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import br.com.fundatec.locadoraveiculo.bancodedados.CadastroClientes;
import br.com.fundatec.locadoraveiculo.enums.TipoDocumento;
import br.com.fundatec.locadoraveiculo.enums.TipoPessoa;
import br.com.fundatec.locadoraveiculo.model.Cliente;
import br.com.fundatec.locadoraveiculo.model.Endereco;

public class TelaCliente {

	public void imprimirMenuCliente() {
		Scanner console = new Scanner(System.in);

		do {
			System.out.println("digite a opção que deseja:");
			System.out.println("Opção 1 - cadastrar Clientes (Pessoa Física ou Pessoa Jurídica)");
			System.out.println("Opção 2 - listar Clientes");
			System.out.println("Opção 0 - retornar ao Menu Principal");

			int opcao;

			try {
				opcao = console.nextInt();
				console.nextLine();
			} catch (InputMismatchException excecao) {
				opcao = -1;
			}
			switch (opcao) {
			case 1:
				this.cadastrarCliente(console);
				break;
			case 2:
				this.listarClientes(console);
				break;
			case 0:
				System.out.println("Voltando ao Menu Principal...");
				return;
			default:
				System.out.println("Opção inválida.");
			}
		} while (true);

	}

	private void cadastrarCliente(Scanner console) {

		String simOuNao = "";
		do {
			CadastroClientes cadastro = CadastroClientes.criar();

			System.out.println("Informar o tipo de pessoa: (fisica ou juridica)");
			TipoPessoa tipoPessoa = lerTipoPessoa(console);

			System.out.println("Informar a UF do cliente:");
			String uf = console.nextLine().toUpperCase();

			System.out.println("Informar a cidade do cliente:");
			String cidade = console.nextLine();

			System.out.println("Informar o CEP do cliente:");
			Integer cep = lerInt(console);

			System.out.println("Informar logradouro:");
			String logradouro = console.nextLine();

			System.out.println("Informar número do logradouro:");
			Integer numero = lerInt(console);

			System.out.println("Informar complemento:");
			String complemento = console.nextLine();

			System.out.println("Informar bairro:");
			String bairro = console.nextLine();

			Endereco endereco = new Endereco(uf, cidade, cep, logradouro, numero, complemento, bairro);

			if (tipoPessoa.equals(TipoPessoa.FISICA)) {

				System.out.println("Informar o Nome:");
				String nome = console.nextLine();

				System.out.println("Informar o tipo do documento: (rg, cpf, cnh)");
				TipoDocumento tipoDocumento = lerTipoDocumento(console);

				System.out.println("Informar o número do documento:");
				Long documento = lerLong(console);

				Cliente pessoa = new Cliente(nome, documento, tipoDocumento, endereco);
				cadastro.adicionar(pessoa);

			} else if (tipoPessoa.equals(TipoPessoa.JURIDICA)) {

				System.out.println("Informar a razão social:");
				String razaoSocial = console.nextLine();

				System.out.println("informar o CNPJ:");
				Long cnpj = lerLong(console);

				Cliente empresa = new Cliente(razaoSocial, cnpj, endereco);
				cadastro.adicionar(empresa);
			}

			System.out.println("deseja cadastrar outro cliente?");
			simOuNao = console.nextLine();
		} while (simOuNao.equalsIgnoreCase("sim"));
	}

	private void listarClientes(Scanner console) {
		CadastroClientes cadastro = CadastroClientes.criar();
		List<Cliente> clientes = cadastro.getClientes();

		if (clientes.isEmpty()) {
			System.out.println("Ainda não foram cadastrados clientes à lista.");
		} else {

			for (int i = 1; i <= clientes.size(); i++) {
				Cliente pessoa = clientes.get(i - 1);
				System.out.println("(" + i + ")" + pessoa);
			}
		}
	}

	public TipoDocumento lerTipoDocumento(Scanner console) {
		while (true) {
			try {
				String tipo = console.nextLine();
				return TipoDocumento.valueOf(tipo.toUpperCase());
			} catch (IllegalArgumentException excecao) {
				System.out.println("Tipo de documento inválido.");
			}
		}
	}

	public TipoPessoa lerTipoPessoa(Scanner console) {
		while (true) {
			try {
				String tipo = console.nextLine();
				return TipoPessoa.valueOf(tipo.toUpperCase());
			} catch (IllegalArgumentException excecao) {
				System.out.println("Tipo de pessoa inválido");
			}
		}
	}

	public Long lerLong(Scanner console) {
		while (true) {
			try {
				Long a = console.nextLong();
				console.nextLine();
				return a;
			} catch (InputMismatchException excecao) {
				System.out.println("Por favor informar apenas números.");
				console.nextLine();
			}
		}
	}

	public Integer lerInt(Scanner console) {
		while (true) {
			try {
				Integer a = console.nextInt();
				console.nextLine();
				return a;
			} catch (InputMismatchException excecao) {
				System.out.println("Por favor informar apenas números.");
				console.nextLine();
			}
		}
	}

}
