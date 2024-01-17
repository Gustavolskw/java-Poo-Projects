package Model;

import View.EntradaSaida;

import javax.swing.*;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public class MaterialDeConstrucao {
	private ArrayList<Material> listaDeMateriais= new ArrayList<Material>();
	private ArrayList<Financeiro> listaDeNotasFiscais = new ArrayList<Financeiro>();
	DecimalFormat df = new DecimalFormat("#0.00");

	//metodos de operaçao


	public void adicionaMaterial(Material mat){
		listaDeMateriais.add(mat);
	}

	public Material retornaProduto(int codigo) {

		Material materialSolicitado = null;

		for (int i = 0; i<listaDeMateriais.size(); i++){

			Material materialProcurado = listaDeMateriais.get(i);

			if(materialProcurado .getCodigo() == codigo){
				materialSolicitado = materialProcurado;
			}
		}
		return materialSolicitado;
	}

	public void venderProduto(int codigo, int quantidadeVend ){
		boolean produtoVendido = false;

		for (int i = 0; i<listaDeMateriais.size(); i++){
			Material produto = listaDeMateriais.get(i);
			if(produto.getCodigo() == codigo){
				produtoVendido = true;
				EntradaSaida.exibirVendaProduto(quantidadeVend, produto);
				int qntd = produto.getQtdMaterial() - quantidadeVend;
				produto.setQtdMaterial(qntd);

			}
		}
		if (!produtoVendido){
			EntradaSaida.msgGeral("Produto Não Esncontrado ", JOptionPane.WARNING_MESSAGE);
		}

	}
	public boolean validaCodigo(int addCodigo) {

		for (int i = 0; i < listaDeMateriais.size(); i++) {

			Material material = listaDeMateriais.get(i);

			if (material.getCodigo() == addCodigo) {

				return true;

			}
		}

		return false;
	}
	public boolean validaProduto(String descricao) {

		for (int i = 0; i < listaDeMateriais.size(); i++) {

			Material material = listaDeMateriais.get(i);

			if (material.getDescricao().equalsIgnoreCase(descricao)) {

				return true;

			}
		}

		return false;
	}
	public void gerarNota(Financeiro notaFiscal) {

		listaDeNotasFiscais.add(notaFiscal);
	}

	public String gerarListaDeEstoque() {
		String info = "Lista de Estoque\n\n";
		for(Material material : listaDeMateriais){
			info+="Descriçao - "+material.getDescricao()+" | Codigo - "+material.getCodigo()+" | Valor - R$"+df.format(material.getPreco())+" Und | Quantidade Em estoque - "+material.getQtdMaterial()+" | Data de Entrada - "+material.getDataEntrada()+"\n";
		}
		return info;
	}
	public String gerarListaparaCompra() {
		String info = "Lista de Produtos\n\n";
		for(Material material : listaDeMateriais){
			info+="Descriçao - "+material.getDescricao()+" | Codigo - "+material.getCodigo()+" | Valor - R$"+df.format(material.getPreco())+"\n";
		}
		return info;
	}
	public void retornaEstoque(int qntdeEstoque, int codigoEstoque) {
		for (int i = 0; i < listaDeMateriais.size(); i++) {

			Material produto = listaDeMateriais.get(i);

			if (produto.getCodigo() == codigoEstoque) {
				produto.setQtdMaterial(produto.getQtdMaterial() + qntdeEstoque);
				EntradaSaida.msgGeral("Item(ns) Adicionado ao estoque", JOptionPane.INFORMATION_MESSAGE);

			}
		}
	}
	public String gerarListaDeNotas() {
		String info = "Notas Fiscais\n";
		for(Financeiro notaFiscal : listaDeNotasFiscais){
			info+="Descriçao - "+ notaFiscal.getDescricao()+" || quantidade Comprada - "+notaFiscal.getQuantidadeCompra()+" || Preço Unitario - R$"+df.format(notaFiscal.getPreco())+"\n Valor Total: R$"+df.format(notaFiscal.getValorTotal())+"Data - "+notaFiscal.getDataVenda()+"\n\n";
		}
		return info;
	}

	public Material preCadastroDeProdutoInteriror(String descricao){
		ProdutosParaInterior interior = new ProdutosParaInterior();
		int codigoGerado;
		float preco;
		int quantidade;
		Random random = new Random();
		codigoGerado = random.nextInt(1,99);
		while(validaCodigo(codigoGerado)){
			codigoGerado = random.nextInt(1,99);
		}
		preco = random.nextFloat(1, 150);
		quantidade = random.nextInt(0, 500);


		interior.setCodigo(codigoGerado);
		interior.setDescricao(descricao);
		interior.setPreco(preco);
		interior.setQtdMaterial(quantidade);
		interior.setDataEntrada(LocalDateTime.now());

		return interior;
	}
	public Material preCadastroDeProdutoObra(String descricao){
		int codigoGerado;
		float preco;
		int quantidade;
		Random random = new Random();
		codigoGerado = random.nextInt(1,99);
		while(validaCodigo(codigoGerado)){
			codigoGerado = random.nextInt(1,99);
		}
		preco = random.nextFloat(1, 150);
		quantidade = random.nextInt(0, 500);
		ProdutosParaObra obra = new ProdutosParaObra();

		obra.setCodigo(codigoGerado);
		obra.setDescricao(descricao);
		obra.setPreco(preco);
		obra.setQtdMaterial(quantidade);
		obra.setDataEntrada(LocalDateTime.now());

		return obra;
	}
	public Material preCadastroDeFerramentas(String descricao){
		int codigoGerado;
		float preco;
		int quantidade;
		Random random = new Random();
		codigoGerado = random.nextInt(1,99);
		while(validaCodigo(codigoGerado)){
			codigoGerado = random.nextInt(1,99);
		}
		preco = random.nextFloat(1, 250);
		quantidade = random.nextInt(0, 500);
		Ferramentas ferramentas = new Ferramentas();

		ferramentas.setCodigo(codigoGerado);
		ferramentas.setDescricao(descricao);
		ferramentas.setPreco(preco);
		ferramentas.setQtdMaterial(quantidade);
		ferramentas.setDataEntrada(LocalDateTime.now());

		return ferramentas;
	}

	public void preCadastroDeProdutoNoEstoque(){
		adicionaMaterial(preCadastroDeProdutoInteriror("Abajur"));
		adicionaMaterial(preCadastroDeProdutoObra("Tijolo"));
		adicionaMaterial(preCadastroDeProdutoObra("Madeira"));
		adicionaMaterial(preCadastroDeProdutoObra("Ferro"));
		adicionaMaterial(preCadastroDeProdutoObra("Cimento"));
		adicionaMaterial(preCadastroDeProdutoInteriror("Espelho"));
		adicionaMaterial(preCadastroDeFerramentas("Martelo"));
		adicionaMaterial(preCadastroDeFerramentas("Furadeira"));
		adicionaMaterial(preCadastroDeFerramentas("Pá"));
	}

	public String retornaTotalComprado(){
		double valorTotal = 0;

		for (Financeiro notasFiscais : this.listaDeNotasFiscais) {

			valorTotal += notasFiscais.getValorTotal();

		}
	return df.format(valorTotal);
	}

	//getters e setters de variaveis



	public String getSenha() {
        return "mat0123";
	}



	//getters e seetters de listas


	public ArrayList<Material> getListaDeMateriais() {
		return listaDeMateriais;
	}



	public ArrayList<Financeiro> getListaDeNotasFiscais() {
		return listaDeNotasFiscais;
	}

}
