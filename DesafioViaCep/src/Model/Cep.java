package Model;

public class Cep {
String cep;
String cidade;
String rua;
String estado;
String bairro;

    public Cep(CepOmdb cepOmdb) {
        this.cep = cepOmdb.cep();
        this.rua = cepOmdb.logradouro();
        this.bairro = cepOmdb.bairro();
        this.cidade = cepOmdb.localidade();
        this.estado = cepOmdb.uf();
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
}
