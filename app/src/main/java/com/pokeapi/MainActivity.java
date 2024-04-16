package com.pokeapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.gson.Gson;
import com.pokeapi.model.Pokemon;
import com.pokeapi.model.pokemonResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private Retrofit retrofit;
    private static final String BASEURL= "https://pokeapi.co/api/v2/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASEURL)
                .build();
        getPokemonData();
    }

    private void getPokemonData(){
        APIService service = retrofit.create(APIService.class);
        Call<pokemonResponse> respuesta = service.obtenerListaPokemon();

        respuesta.enqueue(new Callback<pokemonResponse>() {
            @Override
            public void onResponse(Call<pokemonResponse> call, Response<pokemonResponse> response) {
                if (response.isSuccessful()){
                    pokemonResponse respuestaAPI = response.body();
                    ArrayList<Pokemon> listaPokemon = respuestaAPI.getResultados();
                    for (int i = 0; i<listaPokemon.size();i++){
                        Pokemon pokemon = listaPokemon.get(i);
                    }
                }
            }

            @Override
            public void onFailure(Call<pokemonResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error de consulta", Toast.LENGTH_SHORT).show();
            }
        });
    }
}