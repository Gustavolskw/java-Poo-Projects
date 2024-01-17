package Model;

import java.util.ArrayList;
import java.util.List;

public class Listas {
    List<Cep> enderecos = new ArrayList<>();



    public void addLista(Cep cep){
        enderecos.add(cep);
    }

    public List<Cep> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Cep> enderecos) {
        this.enderecos = enderecos;
    }
}
