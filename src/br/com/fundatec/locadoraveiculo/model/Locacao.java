package br.com.fundatec.locadoraveiculo.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import br.com.fundatec.locadoraveiculo.enums.Situacaolocacao;

public class Locacao {

	private Cliente cliente;
	private Veiculo veiculo;
	private LocalDate dataLocacao;
	private LocalDate dataEntrega;
	private BigDecimal valor;
	private Situacaolocacao situacao;

	public Locacao(Cliente cliente, Veiculo veiculo, LocalDate dataLocacao) {
		this.cliente = cliente;
		this.veiculo = veiculo;
		this.dataLocacao = dataLocacao;
		this.situacao = Situacaolocacao.ATIVA;
	}

	public void encerrar(LocalDate dataEntrega, Float kmAtual) {
		this.situacao = Situacaolocacao.ENCERRADA;
		
		long numeroDias = ChronoUnit.DAYS.between(dataLocacao, dataEntrega);
		Float diferencaKm = kmAtual.floatValue() - veiculo.getKilometragem().floatValue();
		
		BigDecimal diarias = new BigDecimal(numeroDias);
		BigDecimal valorDiaria = new BigDecimal(veiculo.getValorDiaria().toString());
		BigDecimal km = new BigDecimal(diferencaKm.toString());
		BigDecimal valorKm = new BigDecimal(veiculo.getValorKmRodado());
		
		BigDecimal mult1 = diarias.multiply(valorDiaria);
		BigDecimal mult2 = km.multiply(valorKm);
		BigDecimal result = mult1.add(mult2);
		veiculo.setKilometragem(kmAtual);
		this.dataEntrega = dataEntrega;
		this.valor = result;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public LocalDate getDataLocacao() {
		return dataLocacao;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public Situacaolocacao getSituacao() {
		return situacao;
	}

	@Override
	public String toString() {
		return "Locacao [cliente=" + cliente + ", veiculo=" + veiculo + ", dataLocacao=" + dataLocacao
				+ ", dataEntrega=" + dataEntrega + ", valor=" + valor + ", situacao=" + situacao + "]";
	}

}
