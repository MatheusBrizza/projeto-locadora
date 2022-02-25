package br.com.fundatec.locadoraveiculo.tela;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import br.com.fundatec.locadoraveiculo.bancodedados.CadastroVeiculos;
import br.com.fundatec.locadoraveiculo.enums.TipoVeiculo;
import br.com.fundatec.locadoraveiculo.model.Veiculo;

public class TelaVeiculos {

	public void imprimirMenuVeiculos() {
		Scanner console = new Scanner(System.in);

		do {
			System.out.println("digite a opção que deseja:");
			System.out.println("Opção 1 - cadastrar Veículos (Carro, Moto ou Caminhão)");
			System.out.println("Opção 2 - listar Veículos");
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
				this.cadastrarVeiculo(console);
				break;
			case 2:
				this.listarVeiculos(console);
				break;
			case 0:
				System.out.println("Voltando ao Menu Principal...");
				return;
			default:
				System.out.println("Opção inválida.");
			}
		} while (true);

	}

	private void cadastrarVeiculo(Scanner console) {

		String simOuNao = "";
		do {
			
			System.out.println("Informar a marca do veículo:");
			String marca = console.nextLine();
			
			System.out.println("Informar o modelo do veículo:");
			String modelo = console.nextLine();
			
			System.out.println("Informar o tipo do veículo: (hatch, suv, sedan, pickup)");
			TipoVeiculo tipoV = lerTipoVeiculo(console);
			
			System.out.println("Informar a placa do veículo:");
			String placa = console.nextLine();
			
			System.out.println("Informar a kilometragem do veículo:");
			float kilometragem = lerFloat(console);
			
			System.out.println("informar o valor do KM rodado:");
			double valorKmRodado = lerDouble(console);
			
			System.out.println("Informar o valor da diária:");
			double valorDiaria = lerDouble(console);
			
			Veiculo veiculo = new Veiculo(marca, modelo, placa, tipoV, kilometragem, valorKmRodado, valorDiaria);

			
			CadastroVeiculos cadastro = CadastroVeiculos.criar();
			cadastro.adicionar(veiculo);

			System.out.println("deseja cadastrar outro veículo?");
			simOuNao = console.nextLine();
		} while (simOuNao.equalsIgnoreCase("sim"));
	}

	private void listarVeiculos(Scanner console) {
		CadastroVeiculos cadastro = CadastroVeiculos.criar();
		List<Veiculo> veiculos = cadastro.getVeiculos();

		if (veiculos.isEmpty()) {
			System.out.println("Ainda não foram adicionados veículos à lista");
		} else {

			for (int i = 1; i <= veiculos.size(); i++) {
				Veiculo veiculo = veiculos.get(i - 1);
				System.out.println("(" + i + ")" + veiculo);
			}
		}
	}
	public TipoVeiculo lerTipoVeiculo(Scanner console) {
		while (true) {
			try {
				String tipo = console.nextLine();
				return TipoVeiculo.valueOf(tipo.toUpperCase());
			} catch (IllegalArgumentException excecao) {
				System.out.println("Tipo de veículo inválido");
			}
		}
	}
		
	public Double lerDouble(Scanner console) {
		while(true) {
			try {
				Double a = console.nextDouble();
				console.nextLine();
				return a;
			} catch (InputMismatchException excecao) {
				System.out.println("Por favor informar apenas números");
				console.nextLine();
			}
		}
	}
	
	public Float lerFloat(Scanner console) {
		while(true) {
			try {
				Float a = console.nextFloat();
				console.nextLine();
				return a;
			} catch (InputMismatchException excecao) {
				System.out.println("por favor informar apenas números");
				console.nextLine();
			}
		}
	}
}
