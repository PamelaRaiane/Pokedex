package com.projetopokedex.inatel.pokedex.apiPoke;

import com.projetopokedex.inatel.pokedex.models.DetailPokemon;
import com.projetopokedex.inatel.pokedex.models.PokemonAnswer;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by hepr9 on 20/01/2018.
 */

public interface ApiPokeService {

    @GET("pokemon")
    Call<PokemonAnswer> collectListPokemon(@Query("limit") int limit, @Query("offset") int offset);

    @GET("api/v2/pokemon/{id}")
    Call<DetailPokemon> getDetailPokemon(@Path("id") int id);

    @GET("api/v2/pokemon/{name}")
    Call<DetailPokemon> getDetailPokemon(@Path("name") String name);



}
