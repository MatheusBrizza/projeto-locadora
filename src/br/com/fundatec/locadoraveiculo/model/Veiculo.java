package br.com.fundatec.locadoraveiculo.model;

import br.com.fundatec.locadoraveiculo.enums.TipoVeiculo;

public class Veiculo {

	private String marca;
	private String modelo;
	private String placa;
	private TipoVeiculo tipoVeiculo;
	private Float kilometragem;
	private Double valorKmRodado;
	private Double valorDiaria;

	public Veiculo(String marca, String modelo, String placa, TipoVeiculo tipoVeiculo, Float kilometragem,
			Double valorKmRodado, Double valorDiaria) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
		this.tipoVeiculo = tipoVeiculo;
		this.kilometragem = kilometragem;
		this.valorKmRodado = valorKmRodado;
		this.valorDiaria = valorDiaria;
	}
	

	public TipoVeiculo getTipoVeiculo() {
		return tipoVeiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Float getKilometragem() {
		return kilometragem;
	}

	public void setKilometragem(Float kilometragem) {
		this.kilometragem = kilometragem;
	}

	public Double getValorKmRodado() {
		return valorKmRodado;
	}

	public void setValorKmRodado(Double valorKmRodado) {
		this.valorKmRodado = valorKmRodado;
	}

	public Double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(Double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}

	@Override
	public String toString() {
		return "Veiculo [marca=" + marca + ", modelo=" + modelo + ", placa=" + placa + ", tipoVeiculo=" + tipoVeiculo
				+ ", kilometragem=" + kilometragem + ", valorKmRodado=" + valorKmRodado + ", valorDiaria=" + valorDiaria
				+ "]";
	}

}
