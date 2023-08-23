package br.com.alura.loja.vo;

import java.time.LocalDate;

//VO (Value Object) representa uma estrutura de dados imut�vel que � identificado pelo seu pr�prio valor (n�o possuem id, por exemplo). Ele � importante para o dom�nio da aplica��o, e n�o apenas para transferir dados, ele ser� utilizado na l�gica de neg�cio.

public class RelatorioDeVendasVo {

	private String nomeProduto;
	private Long quantidadeVendida;
	private LocalDate dataUtimaVenda;

//----------------------- Construtor

	public RelatorioDeVendasVo(String nomeProduto, Long quantidadeVendida, LocalDate dataUtimaVenda) {
		this.nomeProduto = nomeProduto;
		this.quantidadeVendida = quantidadeVendida;
		this.dataUtimaVenda = dataUtimaVenda;
	}

//---------------------- Method	

	@Override
	public String toString() {
		return "RelatorioDeVendasVo [nomeProduto=" + nomeProduto + ", quantidadeVendida=" + quantidadeVendida
				+ ", dataUtimaVenda=" + dataUtimaVenda + "]";
	}

//---------------------- Getters e Setters

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Long getQuantidadeVendida() {
		return quantidadeVendida;
	}

	public void setQuantidadeVendida(Long quantidadeVendida) {
		this.quantidadeVendida = quantidadeVendida;
	}

	public LocalDate getDataUtimaVenda() {
		return dataUtimaVenda;
	}

	public void setDataUtimaVenda(LocalDate dataUtimaVenda) {
		this.dataUtimaVenda = dataUtimaVenda;
	}

}
