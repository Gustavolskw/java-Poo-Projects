package Control;

import Model.Cep;
import Model.CepOmdb;
import Model.Listas;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner leitura = new Scanner(System.in);
        String cepGetter = "";
        Listas listas = new Listas();
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();
        while(!cepGetter.equalsIgnoreCase("sair")){
            System.out.println("Digite um Cep");
            cepGetter = leitura.nextLine();
            if(cepGetter.equalsIgnoreCase("sair")){
                break;
            }
            try{

                Cep cepCadas = new Cep(cepOmdb);
                System.out.println("cep convertido");
                System.out.println(cepCadas);
                listas.addLista(cepCadas);












        }


















    }
}
