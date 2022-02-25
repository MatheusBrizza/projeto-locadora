package br.com.fundatec.locadoraveiculo.tela;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuPrincipal {

	public void imprimirMenu() {
		Scanner console = new Scanner(System.in);

		do {
		System.out.println("digite a op��o que deseja:");
		System.out.println("Op��o 1 - apresentar Tela de Ve�culos");
		System.out.println("Op��o 2 - apresentar Tela de Clientes");
		System.out.println("Op��o 3 - apresentar Tela de Loca��es");
		System.out.println("Op��o 0 - Encerrar Programa");

		int opcao;

		try {
			opcao = console.nextInt();
			console.nextLine();
		} catch (InputMismatchException excecao) {
			opcao = -1;
		}
			switch (opcao) {
			case 1:
				System.out.println("Indo para Tela de Ve�culos...");
				TelaVeiculos tela1 = new TelaVeiculos();
				tela1.imprimirMenuVeiculos();
				break;
			case 2:
				System.out.println("Indo para Tela de Clientes...");
				TelaCliente tela2 = new TelaCliente();
				tela2.imprimirMenuCliente();
				break;
			case 3:
				System.out.println("Indo para Tela de Loca��es...");
				TelaLocacao tela3 = new TelaLocacao();
				tela3.imprimirMenulocacao();
				break;
			case 0:
				System.out.println("Programa encarrado...");
				console.close();
				return;
			default:
				System.out.println("Op��o inv�lida");
			}
		} while (true);
	}
}
