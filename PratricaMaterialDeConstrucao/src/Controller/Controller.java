package Controller;

import Model.*;
import View.EntradaSaida;

import javax.swing.*;
import java.time.LocalDateTime;

public class Controller {
    MaterialDeConstrucao  matConstr = null;

    public void start(){
        this.matConstr = new MaterialDeConstrucao();
        int escolha;
        int opcao;
        int qtdCompras = 0;
        String login;


        this.matConstr.preCadastroDeProdutoNoEstoque();

        do {
            opcao = EntradaSaida.solicitaUsarioOuComprador();
            switch (opcao) {
                case 0:

                    //check de senha do usuario do sistema

                    System.out.println(this.matConstr.getSenha());
                    login = EntradaSaida.loginDeEntrada();
                    if(login.equalsIgnoreCase(this.matConstr.getSenha())) {

                        do {
                            escolha = EntradaSaida.solicitaEscolha();
                            switch (escolha) {
                                case 0:

                                    //cadastro de produto>>

                                    Material novoMaterial = new Material();

                                    String descricao = EntradaSaida.gerarNovaDescricao();
                                    while(this.matConstr.validaProduto(descricao)) {
                                        EntradaSaida.msgGeral("Produto já em estoque!", -1 );
                                        descricao = EntradaSaida.gerarNovaDescricao();
                                    }
                                    novoMaterial.setDescricao(descricao);

                                    int addCodigo = EntradaSaida.gerarNovoCodigo();

                                    while (this.matConstr.validaCodigo(addCodigo)) {
                                        EntradaSaida.msgGeral("O código digitado já foi cadastrado!", -1 );
                                        addCodigo = EntradaSaida.gerarNovoCodigo();
                                    }
                                    novoMaterial.setCodigo(addCodigo);
                                    novoMaterial.setPreco(EntradaSaida.gerarNovoPreco());
                                    novoMaterial.setQtdMaterial(EntradaSaida.quantidadeDeProdutos());
                                    novoMaterial.setDataEntrada(LocalDateTime.now());
                                    this.matConstr.adicionaMaterial(novoMaterial);

                                    //cadastro de produto<<
                                    break;
                                case 1:

                                    //Entrada de estoque de produto no estoque>>
                                    if (this.matConstr.getListaDeMateriais().isEmpty()) {

                                        EntradaSaida.msgGeral("Sem Produtos em estoque para dar Entrada", JOptionPane.WARNING_MESSAGE);

                                    } else {

                                        int codigoEstoque = EntradaSaida.solicitarCodigo(this.matConstr.gerarListaDeEstoque());
                                        while (!this.matConstr.validaCodigo(codigoEstoque)) {
                                            EntradaSaida.msgGeral("Codigo Inexistente!!!",JOptionPane.WARNING_MESSAGE);
                                            codigoEstoque = EntradaSaida.solicitarCodigo(this.matConstr.gerarListaDeEstoque());
                                        }
                                        int qntdeEstoque = EntradaSaida.solicitarQtdeProdutos();
                                        this.matConstr.retornaEstoque(qntdeEstoque, codigoEstoque);
                                    }
                                    //Entrada de estoque de produto no estoque<<

                                    break;

                                case 2:
                                    //verificar lista do estoque
                                    int escolhaDeLista;
                                    escolhaDeLista = EntradaSaida.solicitaEscolhaDeLista();
                                    if(escolhaDeLista==0){
                                        EntradaSaida.exibirListaDeEstoque(this.matConstr.gerarListaDeEstoque());
                                    } else if (escolhaDeLista == 1 ){
                                        if(this.matConstr.getListaDeNotasFiscais().isEmpty()){
                                            EntradaSaida.msgGeral("nao há Notas Fiscais ", JOptionPane.WARNING_MESSAGE);
                                        }else {
                                            EntradaSaida.exibirListaDeCuponsFiscais(this.matConstr.gerarListaDeNotas());
                                        }
                                    }else {
                                        if (qtdCompras == 0) {
                                            EntradaSaida.msgGeral("Não há Vendas ", JOptionPane.WARNING_MESSAGE);
                                        } else {
                                            EntradaSaida.exibeTotalVendido(matConstr.retornaTotalComprado(), qtdCompras);
                                        }
                                    }

                                    break;

                            }
                        } while (escolha != 3);
                    }else{
                        EntradaSaida.msgGeral("Senha Incorreta!!!", 2);
                    }
                    break;
                case 1:
                    //compras
                    EntradaSaida.msgGeral("Seja Bem Vindo a Loja do material de Construçao", JOptionPane.PLAIN_MESSAGE);
                    if(this.matConstr.getListaDeMateriais().isEmpty()){
                        EntradaSaida.msgGeral("Sem Produtos em estoque para dar Entrada", JOptionPane.WARNING_MESSAGE);
                    }else{
                        int codigo = EntradaSaida.solicitarCodigoCompra(this.matConstr.gerarListaparaCompra());
                        int qtdParaVender = EntradaSaida.solicitarQtdComprar();
                        Material materialCompra = this.matConstr.retornaProduto(codigo);
                        if (materialCompra.getQtdMaterial() - qtdParaVender < 0) {
                            EntradaSaida.msgGeral("Estoque zerado", JOptionPane.WARNING_MESSAGE);
                        }
                        this.matConstr.venderProduto(codigo, qtdParaVender);
                        Financeiro nota = new Financeiro();
                        nota.setDataVenda(LocalDateTime.now());
                        nota.setDescricao(materialCompra.getDescricao());
                        nota.setQuantidadeCompra(qtdParaVender);
                        nota.setPreco(materialCompra.getPreco());
                        nota.setValorTotal(materialCompra.getPreco() * qtdParaVender);
                        this.matConstr.gerarNota(nota);
                        qtdCompras++;
                    }
                    break;
            }
        }while(opcao!=2);
        EntradaSaida.msgGeral("Encerrando...", 1);

    }
}
