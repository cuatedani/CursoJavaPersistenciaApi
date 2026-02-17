package Service;


import Entity.PokemonEntity;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class PokemonService {
    OkHttpClient client =  new OkHttpClient();
    Gson gson = new Gson();

    public PokemonEntity findById(int id) {

        String url = "https://pokeapi.co/api/v2/pokemon/" + id;

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {

            if (!response.isSuccessful()) {
                throw new RuntimeException("Error HTTP: " + response.code());
            }

            String jsonString = response.body().string();

            PokemonEntity pokemon = gson.fromJson(jsonString, PokemonEntity.class);

            return pokemon;

        } catch (Exception e) {
            System.out.println("Error al consultar la API: " + e.getMessage());
            return null;
        }
    }
}
