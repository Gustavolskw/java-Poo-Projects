package model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Loja {
    protected float limiteCompras;
    protected double saldo;
    protected List<Compra> listaCartaoDeCredito = new ArrayList<Compra>();


    public double moviemntaSaldo(double valor){
        return this.saldo += valor;
    }



    public void addToList(Compra compra){
        listaCartaoDeCredito.add(compra);
    }
    public double retornaTotalComprado(){
        double valorTotal = 0;

        for (Compra compras : this.listaCartaoDeCredito) {

            valorTotal -= compras.getValorCompra();

        }
        return valorTotal;
    }

    public String geraLista(){
String listagerada = "";
        Collections.sort(listaCartaoDeCredito);
for(Compra compras : listaCartaoDeCredito){
    listagerada+= "Produto - "+compras.getDescricaoProdt()+" || valor: R$"+compras.getValorCompra()+"\n";
}
return listagerada;
    }









    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public float getLimiteCompras() {
        return limiteCompras;
    }

    public void setLimiteCompras(float limiteCompras) {
        this.limiteCompras = limiteCompras;
    }

    public List<Compra> getListaCartaoDeCredito() {
        return listaCartaoDeCredito;
    }

    public void setListaCartaoDeCredito(List<Compra> listaCartaoDeCredito) {
        this.listaCartaoDeCredito = listaCartaoDeCredito;
    }
}
