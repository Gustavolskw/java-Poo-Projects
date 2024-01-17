package View;

import javax.swing.*;

public class EntradaSaida {
	 public static int solicitarInformacoesDeposito(){
		  return Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o valor a ser Depositado", "<<Depósito>>", JOptionPane.PLAIN_MESSAGE ));
	 }
	 public static int solicitarInformacoesSaque(){
		  return Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o valor a ser Sacado", "<<Saque>>", JOptionPane.PLAIN_MESSAGE ));
	 }
	 public static void exibirSaldo(int saldoAtual){
		  JOptionPane.showMessageDialog(null, "Saldo Total é de: "+ saldoAtual, "Banco da Somália", JOptionPane.INFORMATION_MESSAGE);
	 }
	 public static void exibirDadosDaConta(String dados) {
		  JOptionPane.showMessageDialog(null, dados, "Dados da Conta", JOptionPane.INFORMATION_MESSAGE);
		  
	 }
	 public static void exibirExtratoCompleto(StringBuilder extrato){
		 JOptionPane.showMessageDialog(null,"<<<Extrato Completo>>>\n"+extrato);
	 }
	 public static void exibirExtratoDeDepositos(StringBuilder depositos) {
		 JOptionPane.showMessageDialog(null,"<<<Extrato de Depositos>>> \n"+depositos);
	 }
	 public static void exibirExtratoDeSaques(StringBuilder saques) {
		 JOptionPane.showMessageDialog(null,"<<<Extrato de Saques>>> \n"+saques);
	 }
	 public static String solicitaOpcaoDeMovimentacao(){
		  String[] opcoes= {"Deposito", "Saque"};
		  int escolha  =  JOptionPane.showOptionDialog(null, "Selecione entre as movimentaçoes Disponiveis", "Banco da Somalia", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
		  if(escolha== 0 ){
			   return "Deposito";
		  }else {
			   return "Saque";
		  }
	 }
	 public static int escolha(){
		  String[] opcoes = {"Opcoes de Movimentação", "Detalhes do Extrato", "Detalhes da Conta", "Sair"};
		  JComboBox<String> menu = new JComboBox<>(opcoes);
		  JOptionPane.showConfirmDialog(null, menu, "Selecione a opcao que deseja executar.", JOptionPane.DEFAULT_OPTION);
		  return menu.getSelectedIndex();
		  
	 }
	 public static int escolhaEntrada(){
		  String[] opcoes = {"Entrar Em conta", "Sair"};
		  return JOptionPane.showOptionDialog(null,"Selecione a opcao que deseja executar", "B.S.", JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
	 }
	 public static String solicitaNome(String opcao){
		  return JOptionPane.showInputDialog(null, "escreva o nome do "+opcao+" da conta", "Banco da Somália", JOptionPane.PLAIN_MESSAGE);
	 }
	 public static String solicitacaoAoUsuario(String dado, String tipo){
		  return JOptionPane.showInputDialog(null, "Digite o seu "+dado , tipo, JOptionPane.INFORMATION_MESSAGE);
	 }
	 public static int login(){
		  return Integer.parseInt(JOptionPane.showInputDialog(null, "Digite seu Passe de Login para entrar "));
	 }
	 public static void msgEncerraPrograma(){
		  JOptionPane.showMessageDialog(null, "O programa será encerrado");
	 }
	 public static int passeDeLogin(){
		  return Integer.parseInt(JOptionPane.showInputDialog(null, "Digite Seu passe de Login"));
	 }
	 public static String solicitaTipoDeConta(){
		  String[] opcoes = {"Corrente", "Poupança"};
		  int escolha = JOptionPane.showOptionDialog(null, "Escolha o tipo de conta que deseja abrir", "B.S", JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[1]);
		  if(escolha==0){
			   return "Corrente";
		  }else {
			   return "Poupança";
		  }
	 }
	 public static void mensagemGeral(String mensagem){
		  JOptionPane.showMessageDialog(null, mensagem, "Banco da Somália", JOptionPane.INFORMATION_MESSAGE);
	 }
	public static void exibirExtratoPopCorr(StringBuilder extratoPopCorr) {
		JOptionPane.showMessageDialog(null, "<<<Extrato de Conta>>> \n"+ extratoPopCorr);
	}

	public static int solicitaOpcoesDeExtrato() {
		 String []opcoes = {"Completo", "Depositos", "Saques", "Conta Poupança", "Conta Corrente", "Saldo"};
		JComboBox<String> menu = new JComboBox<>(opcoes);
		JOptionPane.showConfirmDialog(null, menu, "Selecione a opçao de vizualizaçao de extrato", JOptionPane.DEFAULT_OPTION);
		return menu.getSelectedIndex();
	}
	public static String solicitaData(){
		 return JOptionPane.showInputDialog(null, "Digite a data da Transaçao");
	}
}
