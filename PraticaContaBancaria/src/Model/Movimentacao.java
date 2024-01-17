package Model;

public class Movimentacao implements IMovimentao{
	 private String tipo; // (considerar: 1- saque e 2- depósito)
	 private int  valor;
	 private String data;


	 public String getTipo() {
		  return tipo;
	 }
	 public void setTipo(String tipo) {
		  this.tipo = tipo;
	 }
	 public int getValor() {
		  return valor;
	 }
	 public void setValor(int valor) {
		  this.valor = valor;
	 }
	 public String getData() {
		  return data;
	 }
	 public void setData(String data) {
		  this.data = data;
	 }
}
