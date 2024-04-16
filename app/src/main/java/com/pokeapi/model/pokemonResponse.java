package com.pokeapi.model;

import java.util.ArrayList;

public class pokemonResponse {
    private ArrayList<Pokemon> resultados;

    public ArrayList<Pokemon> getResultados(){
        return resultados;
    }

    public void setResultados(ArrayList<Pokemon> resultados) {
        this.resultados = resultados;
    }
}
