package Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Financeiro implements IFinanceiro {
	protected int quantidadeCompra;
	protected  String descricao;
	protected double valorTotal;

	protected double preco;
	LocalDateTime dataVenda = LocalDateTime.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

	public String getDataVenda() {
		return dataVenda.format(formatter);
	}

	public void setDataVenda(LocalDateTime dataVenda) {
		this.dataVenda = dataVenda;
	}
	public int getQuantidadeCompra() {
		return quantidadeCompra;
	}

	public void setQuantidadeCompra(int quantidadeCompra) {
		this.quantidadeCompra = quantidadeCompra;
	}


	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
}
