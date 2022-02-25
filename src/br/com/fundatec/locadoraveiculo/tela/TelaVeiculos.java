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
			System.out.println("digite a op��o que deseja:");
			System.out.println("Op��o 1 - cadastrar Ve�culos (Carro, Moto ou Caminh�o)");
			System.out.println("Op��o 2 - listar Ve�culos");
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
				this.cadastrarVeiculo(console);
				break;
			case 2:
				this.listarVeiculos(console);
				break;
			case 0:
				System.out.println("Voltando ao Menu Principal...");
				return;
			default:
				System.out.println("Op��o inv�lida.");
			}
		} while (true);

	}

	private void cadastrarVeiculo(Scanner console) {

		String simOuNao = "";
		do {
			
			System.out.println("Informar a marca do ve�culo:");
			String marca = console.nextLine();
			
			System.out.println("Informar o modelo do ve�culo:");
			String modelo = console.nextLine();
			
			System.out.println("Informar o tipo do ve�culo: (hatch, suv, sedan, pickup)");
			TipoVeiculo tipoV = lerTipoVeiculo(console);
			
			System.out.println("Informar a placa do ve�culo:");
			String placa = console.nextLine();
			
			System.out.println("Informar a kilometragem do ve�culo:");
			float kilometragem = lerFloat(console);
			
			System.out.println("informar o valor do KM rodado:");
			double valorKmRodado = lerDouble(console);
			
			System.out.println("Informar o valor da di�ria:");
			double valorDiaria = lerDouble(console);
			
			Veiculo veiculo = new Veiculo(marca, modelo, placa, tipoV, kilometragem, valorKmRodado, valorDiaria);

			
			CadastroVeiculos cadastro = CadastroVeiculos.criar();
			cadastro.adicionar(veiculo);

			System.out.println("deseja cadastrar outro ve�culo?");
			simOuNao = console.nextLine();
		} while (simOuNao.equalsIgnoreCase("sim"));
	}

	private void listarVeiculos(Scanner console) {
		CadastroVeiculos cadastro = CadastroVeiculos.criar();
		List<Veiculo> veiculos = cadastro.getVeiculos();

		if (veiculos.isEmpty()) {
			System.out.println("Ainda n�o foram adicionados ve�culos � lista");
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
				System.out.println("Tipo de ve�culo inv�lido");
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
				System.out.println("Por favor informar apenas n�meros");
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
				System.out.println("por favor informar apenas n�meros");
				console.nextLine();
			}
		}
	}
}
