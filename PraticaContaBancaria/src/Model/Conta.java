package Model;

import View.EntradaSaida;

import java.util.ArrayList;

public class Conta {
	private String  titularDaConta;
	private String  tipo ; // (1-conta poupança, 2-conta corrente.)
	private int saldo;
	private ArrayList<Movimentacao> listaDeMovimentacao = new ArrayList<Movimentacao>();
	private ArrayList<Conta> tiposDeConta = new ArrayList<Conta>();
	private  ArrayList<Cofre> listaCorrente = new ArrayList<Cofre>();
	private ArrayList<Cofre> listaPoupanca = new ArrayList<Cofre>();
	private ArrayList<Movimentacao> listaDeDepositos = new ArrayList<Movimentacao>();
	private ArrayList<Movimentacao> listaDeSaques = new ArrayList<Movimentacao>();
	private ArrayList<Movimentacao> correnteTipoTrans = new ArrayList<Movimentacao>();
	private ArrayList<Movimentacao> poupancaTipoTrans = new ArrayList<Movimentacao>();
	private ArrayList<Movimentacao> tipoDeTransacaoGeral = new ArrayList<Movimentacao>();
	private ArrayList<Movimentacao> dataDeMovimentacao = new ArrayList<Movimentacao>();


	//Operraçoes

	public int depositar( int  valor ){
		return  this.saldo+= valor;
	}
	public int sacar( int valor ){
		return   this.saldo -= valor;
	}

	public int  gerarSaldo(int saldoTotal){
		return saldoTotal;
	}
	public String  gerarDadosDaConta(String nome, String endereco, String documento){
		return "Dados da Conta\n"+"Nome - "+ nome+"\nEndereço - "+endereco+"\nDocuemnto - "+documento+ "\nSenha - ********";
	}
	public void gerarExtrato(ArrayList<Movimentacao> listaDeMovimentacao, ArrayList<Conta> tiposDeConta, ArrayList<Movimentacao> tipoDeTransacaoGeral, ArrayList<Movimentacao> dataDeMovimentacao ){
		StringBuilder extratoCompleto = new StringBuilder();
		for (int i = 0; i < listaDeMovimentacao.size(); i++) {
			extratoCompleto.append((i+1)+"º "+tipoDeTransacaoGeral.get(i).getTipo() +  " - " + tiposDeConta.get(i).getTipo()+ " : " +listaDeMovimentacao.get(i).getValor()+ " | Data - "+ dataDeMovimentacao.get(i).getData());
			if(i< listaDeMovimentacao.size()){
				extratoCompleto.append("\n");
			}
		}
		EntradaSaida.exibirExtratoCompleto(extratoCompleto);

	}
	public  void gerarExtratoDepositos(ArrayList<Movimentacao> listaDeDepositos,ArrayList<Conta> tiposDeConta) {
		StringBuilder extratoDepositos = new StringBuilder();
		for (int i = 0; i < listaDeDepositos.size(); i++) {
			extratoDepositos.append((i+1)+"º "+"Deposito"+  " - " + tiposDeConta.get(i).getTipo()+ " : " +listaDeDepositos.get(i).getValor());
			if(i<listaDeDepositos.size()){
				extratoDepositos.append("\n");
			}
		}
		EntradaSaida.exibirExtratoDeDepositos(extratoDepositos);
	}
	public void  gerarExtratoSaques(ArrayList<Movimentacao> listaDeSaques, ArrayList<Conta> tiposDeConta){
		StringBuilder extratoSaques = new StringBuilder();
		for (int i = 0; i < listaDeSaques.size(); i++) {
			extratoSaques.append((i+1)+"º "+"Saque - "+tiposDeConta.get(i).getTipo()+ listaDeSaques.get(i).getValor());
			if (i<listaDeSaques.size()){
				extratoSaques.append("\n");
			}
		}
		EntradaSaida.exibirExtratoDeSaques(extratoSaques);
	}
	public void gerarExtratoPoupanca(ArrayList<Movimentacao> poupancaTipoTrans, ArrayList<Cofre> listaPoupanca ){
		StringBuilder extratoPoupanca = new StringBuilder();
		for(int i = 0; i < poupancaTipoTrans.size(); i++){
			extratoPoupanca.append((i+1)+"º "+poupancaTipoTrans.get(i).getTipo() +  " -  "+"Poupança" +  " : " +listaPoupanca.get(i).getTransferConta());
			if (i<poupancaTipoTrans.size()){
				extratoPoupanca.append("\n");
			}
		}
		EntradaSaida.exibirExtratoPopCorr(extratoPoupanca);
	}
	public void gerarExtratoCorrente(ArrayList<Movimentacao> correnteTipoTrans, ArrayList<Cofre> listaCorrente ){
		StringBuilder extratoCorrente = new StringBuilder();
		for(int i = 0; i < correnteTipoTrans.size(); i++){
			extratoCorrente.append((i+1)+"º "+correnteTipoTrans.get(i).getTipo() +  " -  "+"Corrente" +  " : " +listaCorrente.get(i).getTransferConta());
			if (i<correnteTipoTrans.size()){
				extratoCorrente.append("\n");
			}
		}
		EntradaSaida.exibirExtratoPopCorr(extratoCorrente);
	}

	//setters e getters variaveis


	public String getTitularDaConta() {
		return titularDaConta;
	}

	public void setTitularDaConta(String titularDaConta) {
		this.titularDaConta = titularDaConta;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	//setters e getters de listas


	public ArrayList<Movimentacao> getListaDeMovimentacao() {
		return listaDeMovimentacao;
	}

	public void setListaDeMovimentacao(ArrayList<Movimentacao> listaDeMovimentacao) {
		this.listaDeMovimentacao = listaDeMovimentacao;
	}

	public ArrayList<Conta> getTiposDeConta() {
		return tiposDeConta;
	}

	public void setTiposDeConta(ArrayList<Conta> tiposDeConta) {
		this.tiposDeConta = tiposDeConta;
	}

	public ArrayList<Cofre> getListaCorrente() {
		return listaCorrente;
	}

	public void setListaCorrente(ArrayList<Cofre> listaCorrente) {
		this.listaCorrente = listaCorrente;
	}

	public ArrayList<Cofre> getListaPoupanca() {
		return listaPoupanca;
	}

	public void setListaPoupanca(ArrayList<Cofre> listaPoupanca) {
		this.listaPoupanca = listaPoupanca;
	}

	public ArrayList<Movimentacao> getListaDeDepositos() {
		return listaDeDepositos;
	}

	public void setListaDeDepositos(ArrayList<Movimentacao> listaDeDepositos) {
		this.listaDeDepositos = listaDeDepositos;
	}

	public ArrayList<Movimentacao> getListaDeSaques() {
		return listaDeSaques;
	}

	public void setListaDeSaques(ArrayList<Movimentacao> listaDeSaques) {
		this.listaDeSaques = listaDeSaques;
	}

	public ArrayList<Movimentacao> getCorrenteTipoTrans() {
		return correnteTipoTrans;
	}

	public void setCorrenteTipoTrans(ArrayList<Movimentacao> correnteTipoTrans) {
		this.correnteTipoTrans = correnteTipoTrans;
	}

	public ArrayList<Movimentacao> getPoupancaTipoTrans() {
		return poupancaTipoTrans;
	}

	public void setPoupancaTipoTrans(ArrayList<Movimentacao> poupancaTipoTrans) {
		this.poupancaTipoTrans = poupancaTipoTrans;
	}

	public ArrayList<Movimentacao> getTipoDeTransacaoGeral() {
		return tipoDeTransacaoGeral;
	}

	public void setTipoDeTransacaoGeral(ArrayList<Movimentacao> tipoDeTransacaoGeral) {
		this.tipoDeTransacaoGeral = tipoDeTransacaoGeral;
	}

	public ArrayList<Movimentacao> getDataDeMovimentacao() {
		return dataDeMovimentacao;
	}

	public void setDataDeMovimentacao(ArrayList<Movimentacao> dataDeMovimentacao) {
		this.dataDeMovimentacao = dataDeMovimentacao;
	}
}
