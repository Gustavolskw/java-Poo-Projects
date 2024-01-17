package Model;

import View.EntradaSaida;

public class Usuario implements IUsuario{
	 protected String nome;
	 protected String endereco;
	 protected String cpf;
	 protected int pin;
	 
	 public String getEndereco() {
		  return endereco;
	 }
	 
	 public void setEndereco(String endereco) {
		  this.endereco = endereco;
	 }
	 
	 public String getNome() {
		  return nome;
	 }
	 
	 public void setNome(String nome) {
		  this.nome = nome;
	 }
	 
	 public String getCpf() {
		  return cpf;
	 }
	 
	 public void setCpf(String cpf) {
		  this.cpf = cpf;
	 }
	 
	 public int getPing() {
		  return pin;
	 }
	 
	 public void setPin(int pin) {
		  this.pin = pin;
	 }
	 public void cadastro(){
		  setNome(EntradaSaida.solicitaNome("Titular"));
		  setCpf(EntradaSaida.solicitacaoAoUsuario("CPF", "Documento"));
		  setEndereco(EntradaSaida.solicitacaoAoUsuario("Endereço", "Endereço"));
		  setPin(EntradaSaida.passeDeLogin());
		  Conta conta = new Conta();
		  conta.setTitularDaConta(getNome());
		  
		  
	 }
}
