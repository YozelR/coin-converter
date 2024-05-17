import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.InputMismatchException;

public class Request extends Main{


    public RecordRequest request(String baseCoin, String targetCoin, double baseQuantity) throws IOException, InterruptedException {

        try {
            String URL = "https://v6.exchangerate-api.com/v6/789067c7d7e26de599cb26b4/pair/" + baseCoin + "/" + targetCoin + "/" + baseQuantity;

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            Gson gson = new GsonBuilder().create();
            RecordRequest myRequest = gson.fromJson(json, RecordRequest.class);



            DocGenerator myDocGenerated = new DocGenerator(myRequest);
            System.out.println(myDocGenerated);
            FileWriter writedDoc = new FileWriter("Hystory.txt");
            writedDoc.write(myDocGenerated.toString());
            writedDoc.close();

        }catch (NumberFormatException | IllegalFormatException e) {
            System.out.println("Ocurrio un error");
            System.out.println(e.getMessage());
        }catch (IllegalArgumentException | IllegalStateException | InputMismatchException e) {
            System.out.println("Formato no valido");
        }
        return null;
    }
}
