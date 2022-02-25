package br.com.fundatec.locadoraveiculo.tela;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import br.com.fundatec.locadoraveiculo.bancodedados.CadastroClientes;
import br.com.fundatec.locadoraveiculo.bancodedados.CadastroLocacoes;
import br.com.fundatec.locadoraveiculo.bancodedados.CadastroVeiculos;
import br.com.fundatec.locadoraveiculo.enums.TipoDocumento;
import br.com.fundatec.locadoraveiculo.enums.TipoPessoa;
import br.com.fundatec.locadoraveiculo.enums.TipoVeiculo;
import br.com.fundatec.locadoraveiculo.model.Cliente;
import br.com.fundatec.locadoraveiculo.model.Locacao;
import br.com.fundatec.locadoraveiculo.model.Veiculo;

public class TelaLocacao {
	public void imprimirMenulocacao() {
		Scanner console = new Scanner(System.in);

		do {
			System.out.println("digite a op��o que deseja:");
			System.out.println("Op��o 1 - cadastrar Loca��es");
			System.out.println("Op��o 2 - encerrar Loca��es");
			System.out.println("Op��o 3 - listar Loca��es");
			System.out.println("Op��o 0 - retornar ao Menu Principal");

			int opcao;

			try {
				opcao = console.nextInt();
				console.nextLine();
			} catch (InputMismatchException excecao) {
				opcao = -1;
			}

			switch (opcao) {
			case 1:
				this.cadastrarLocacao(console);
				break;
			case 2:
				this.encerrarLocacoes(console);
				break;
			case 3:
				this.listarLocacoes(console);
				break;
			case 0:
				System.out.println("Voltando ao Menu Principal...");
				return;
			default:
				System.out.println("Op��o inv�lida.");
			}
		} while (true);
	}

	private void cadastrarLocacao(Scanner console) {

		String simOuNao = "";
		do {

			System.out.println("");
			CadastroClientes cadastro1 = CadastroClientes.criar();
			List<Cliente> cadastroClientes = cadastro1.getClientes();

			for (int i = 1; i <= cadastroClientes.size(); i++) {
				Cliente cliente = cadastroClientes.get(i - 1);
				System.out.println("(" + i + ")" + cliente);
			}
			
			System.out.println("");
			System.out.println("Escolher um dos clientes listados.");
			Integer i = lerInt(console);
			Cliente clienteEscolhido = cadastroClientes.get(i);
			System.out.println(clienteEscolhido);
			System.out.println("");

			CadastroVeiculos cadastro2 = CadastroVeiculos.criar();
			List<Veiculo> cadastroVeiculos = cadastro2.getVeiculos();
			
			for (i = 1; i <= cadastroVeiculos.size(); i++) {
				Veiculo veiculo = cadastroVeiculos.get(i - 1);
				System.out.println("(" + i + ")" + veiculo);
			}
			
			System.out.println("");
			System.out.println("Escolher um dos ve�culos listados.");
			i = lerInt(console);
			Veiculo veiculoEscolhido = cadastroVeiculos.get(i);
			System.out.println("");
			

			System.out.println("Informar data de Loca��o do ve�culo: (YYYY/MM/DD)");
			System.out.print("Ano:");
			int ano = lerInt(console);
			System.out.print("M�s:");
			int mes = lerInt(console);
			System.out.print("Dia:");
			int dia = lerInt(console);
			LocalDate dado = LocalDate.of(ano, mes, dia);

			Locacao locacao = new Locacao(clienteEscolhido, veiculoEscolhido, dado);
			System.out.println(locacao);
			CadastroLocacoes cadastro = CadastroLocacoes.criar();
			cadastro.adicionar(locacao);

			System.out.println("deseja cadastrar outra loca��o?");
			simOuNao = console.nextLine();

		} while (simOuNao.equalsIgnoreCase("sim"));
	}
	
	private void encerrarLocacoes(Scanner console) {
		CadastroLocacoes cadastro = CadastroLocacoes.criar();
		List<Locacao> locacoes = cadastro.getLocacao();
		
		for (int i = 1; i <= locacoes.size(); i++) {
			Locacao locacao = locacoes.get(i - 1);
			System.out.println("(" + i + ")" + locacao);
		}
		
		System.out.println("Informar loca��o para encerrar");
		Integer i = lerInt(console);
		Locacao locacaoEscolhida = locacoes.get(i);
		System.out.println(locacaoEscolhida);
		System.out.println("");
		
		System.out.println("Informar a kilometragem atual do ve�culo.");
		Float kmAtual = lerFloat(console);
		
		System.out.println("Informar data de entrega do ve�culo: (YYYY/MM/DD)");
		System.out.print("Ano:");
		int ano = lerInt(console);
		System.out.print("M�s:");
		int mes = lerInt(console);
		System.out.print("Dia:");
		int dia = lerInt(console);
		LocalDate dado = LocalDate.of(ano, mes, dia);
		
		locacaoEscolhida.encerrar(dado, kmAtual);
		System.out.println(locacaoEscolhida);
	}

	private void listarLocacoes(Scanner console) {
		CadastroLocacoes cadastro = CadastroLocacoes.criar();
		List<Locacao> locacoes = cadastro.getLocacao();

		if (locacoes.isEmpty()) {
			System.out.println("Ainda n�o foram adicionados loca��es � lista");
		} else {

			for (int i = 1; i <= locacoes.size(); i++) {
				Locacao locacao = locacoes.get(i - 1);
				System.out.println("(" + i + ")" + locacao);
			}
		}
	}

	public TipoVeiculo lerTipoVeiculo(Scanner console) {
		while (true) {
			try {
				String tipo = console.nextLine();
				return TipoVeiculo.valueOf(tipo.toUpperCase());
			} catch (IllegalArgumentException excecao) {
				System.out.println("Tipo de ve�culo inv�lido");
			}
		}
	}

	public TipoDocumento lerTipoDocumento(Scanner console) {
		while (true) {
			try {
				String tipo = console.nextLine();
				return TipoDocumento.valueOf(tipo.toUpperCase());
			} catch (IllegalArgumentException excecao) {
				System.out.println("Tipo de documento inv�lido.");
			}
		}
	}

	public TipoPessoa lerTipoPessoa(Scanner console) {
		while (true) {
			try {
				String tipo = console.nextLine();
				return TipoPessoa.valueOf(tipo.toUpperCase());
			} catch (IllegalArgumentException excecao) {
				System.out.println("Tipo de pessoa inv�lido");
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
				System.out.println("Por favor informar apenas n�meros.");
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
				System.out.println("Por favor informar apenas n�meros.");
				console.nextLine();
			}
		}
	}

	public Double lerDouble(Scanner console) {
		while (true) {
			try {
				Double a = console.nextDouble();
				console.nextLine();
				return a;
			} catch (InputMismatchException excecao) {
				System.out.println("Por favor informar apenas n�meros");
				console.nextLine();
			}
		}
	}

	public Float lerFloat(Scanner console) {
		while (true) {
			try {
				Float a = console.nextFloat();
				console.nextLine();
				return a;
			} catch (InputMismatchException excecao) {
				System.out.println("por favor informar apenas n�meros");
				console.nextLine();
			}
		}
	}
}
