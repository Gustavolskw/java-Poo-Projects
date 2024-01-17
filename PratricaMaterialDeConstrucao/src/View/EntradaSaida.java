package View;

import Model.*;

import javax.swing.*;
import java.util.Random;

public class EntradaSaida {
    public static int solicitaUsarioOuComprador() {
        String[]opcoes = {"Usuario", "Cliente","Desconectar"};
        return JOptionPane.showOptionDialog(null, "Escolha a opcao de serviços do material de construçao", "Material de Construçao ", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
    }
    public static int solicitaEscolha() {
        String []opcoes = {"Cadastrar Novo Produto", "Entrada de produto", "Controle de Estoque", "Sair"};
        JComboBox<String>menu = new JComboBox<>(opcoes);
        JOptionPane.showConfirmDialog(null,menu,  "Escolha a opcao que deseja executar", JOptionPane.DEFAULT_OPTION );
        return menu.getSelectedIndex();
    }

    public static int solicitaEscolhaDeLista(){
        String [] option = {"Estoque geral ", "Notas Fiscais", "Total Vendido"};
        return JOptionPane.showOptionDialog(null,"Escolha a Lista de Controle ", "Material de construção", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null , option, option[0] );

    }

    public static int gerarNovoCodigo(){
        int codigoGerado;
        String[] opcoes = {"Gerar", "Digitar"};
        int  escolha = JOptionPane.showOptionDialog(null, "Opcoes de criação de codigo novo", "Material de Construçao ", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
        if (escolha == 0 ){
            Random random = new Random();
            return random.nextInt(1,99);
        }else{
            codigoGerado= Integer.parseInt(JOptionPane.showInputDialog(null, "Digite Um valor com (2) digitos para cadastrar como o codigo do produto "));
            while(codigoGerado>99){
                codigoGerado= Integer.parseInt(JOptionPane.showInputDialog(null, "Digite Novamente  o codigo do novo Produto"));
            }
            return codigoGerado;
        }
    }
    public static float gerarNovoPreco() {
        return Float.parseFloat(JOptionPane.showInputDialog(null,"Digite o preço Unitario do produto cadastrado"));
    }
    public static String gerarNovaDescricao(){
        return JOptionPane.showInputDialog(null,"Digite a descriçao do produto");
    }
    public static int quantidadeDeProdutos(){
        return Integer.parseInt(JOptionPane.showInputDialog(null,"Digite a quantdade para adicionar ao estoque"));
    }

    public static String loginDeEntrada(){
        return JOptionPane.showInputDialog(null, "Login : ./User_Material_Construcao ", "Login de acesso de usuario", JOptionPane.QUESTION_MESSAGE);
    }

    public static void msgGeral(String mensagem, int tipoDeMenagem  ){
        JOptionPane.showMessageDialog(null, mensagem, "Material de Construçao", tipoDeMenagem);
    }


    public static void exibirListaDeEstoque(String listaDeEstoque) {
        JOptionPane.showMessageDialog(null, listaDeEstoque, "Material de Construção", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void exibirListaDeCuponsFiscais(String listaDeCupons) {
        JOptionPane.showMessageDialog(null, listaDeCupons +"\n", "Material de Construção", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void exibirVendaProduto(int qtd , Material produto){
        JOptionPane.showMessageDialog(null, "Venda de " + qtd + " " + produto.getDescricao()+"(s) Bem sucedida ");
    }

    public static int solicitarCodigo(String listaDeMateriais) {
        return Integer.parseInt(JOptionPane.showInputDialog(null, listaDeMateriais, "Digite o Codigo do produto que deseja dar Entrada ao estoque", JOptionPane.PLAIN_MESSAGE));
    }
    public static int solicitarCodigoCompra(String listaDeMateriais) {
        return Integer.parseInt(JOptionPane.showInputDialog(null, listaDeMateriais, "Digite o Codigo do produto que deseja Comprar", JOptionPane.PLAIN_MESSAGE));
    }

    public static int solicitarQtdeProdutos() {
        return Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a Quantidade que deseja dar entrada ao estoque "));
    }
    public static int solicitarQtdComprar() {
        return Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a Quantidade que deseja Comprar"));
    }
    public static void exibeTotalVendido(String valor, int qtdVendas){
        JOptionPane.showMessageDialog(null, "Foi vendido um total de: R$"+valor+ " em "+ qtdVendas+" vendas");
    }
}
