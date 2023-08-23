package br.com.alura.loja.vo;

import java.time.LocalDate;

//VO (Value Object) representa uma estrutura de dados imutável que é identificado pelo seu próprio valor (não possuem id, por exemplo). Ele é importante para o domínio da aplicação, e não apenas para transferir dados, ele será utilizado na lógica de negócio.

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
