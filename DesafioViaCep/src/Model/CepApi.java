package Model;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CepApi {

    public void cepApi(){
        String url = "viacep.com.br/ws/"+cepGetter+"/json/";
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            System.out.println(json);

            CepOmdb  cepOmdb =  gson.fromJson(json, CepOmdb.class);
    }
}
