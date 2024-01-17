package model;

public class Compra implements Comparable<Compra>{
    protected double valorCompra;
    protected String descricaoProdt;
    protected double valorTotal;


    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public String getDescricaoProdt() {
        return descricaoProdt;
    }

    public void setDescricaoProdt(String descricaoProdt) {
        this.descricaoProdt = descricaoProdt;
    }

    @Override
    public int compareTo(Compra o) {
        return Double.compare(this.valorCompra, o.valorCompra);
    }
}
