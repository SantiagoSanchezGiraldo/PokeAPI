package com.pokeapi;

import com.pokeapi.model.pokemonResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("pokemon")
    Call<pokemonResponse> obtenerListaPokemon();
}
