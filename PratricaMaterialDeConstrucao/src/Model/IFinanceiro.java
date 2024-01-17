package Model;

import java.time.LocalDateTime;

public interface IFinanceiro {
    void setDataVenda(LocalDateTime dataVenda);
    void setQuantidadeCompra(int quantidadeCompra);
    void setDescricao(String descricao);
    void setValorTotal(double valorTotal);
    void setPreco(double preco);


}
