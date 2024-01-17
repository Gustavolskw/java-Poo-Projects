package Model;

import java.util.ArrayList;

public abstract class Carros implements ICarros{
    protected String tipoDeCarro;
    protected String marcha;
    protected int qtdPortas;
    protected String cor;
    protected String modelo;


    public String getMarcha() {
        return marcha;
    }

    public void setMarcha(String marcha) {
        this.marcha = marcha;
    }

    public int getQtdPortas() {
        return qtdPortas;
    }

    public void setQtdPortas(int qtdPortas) {
        this.qtdPortas = qtdPortas;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipoDeCarro() {
        return tipoDeCarro;
    }

    public void setTipoDeCarro(String tipoDeCarro) {
        this.tipoDeCarro = tipoDeCarro;
    }

    public String getTipoDeMotor() {
        Combustao combustao = new Combustao();
        return combustao.tipoDeMotor;
    }

    public int getQtdBaterias() {
        Eletrico eletrico =new Eletrico();
        return eletrico.qtdBaterias;
    }
}

