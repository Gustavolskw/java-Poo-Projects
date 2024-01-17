package Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Material implements IMaterial {
    protected float  preco;
    protected int codigo;
    protected String descricao;
    protected int qtdMaterial;
    LocalDateTime dataEntrada = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public String getDataEntrada() {
        return dataEntrada.format(formatter);
    }

    public void setDataEntrada(LocalDateTime dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setQtdMaterial(int qtdMaterial) {
        this.qtdMaterial = qtdMaterial;
    }

    public float getPreco() {
        return preco;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQtdMaterial() {
        return qtdMaterial;
    }
}
