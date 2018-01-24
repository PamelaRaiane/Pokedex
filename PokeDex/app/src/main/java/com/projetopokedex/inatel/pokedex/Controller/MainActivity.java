package com.projetopokedex.inatel.pokedex.Controller;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.projetopokedex.inatel.pokedex.R;
import com.projetopokedex.inatel.pokedex.apiPoke.ApiClient;
import com.projetopokedex.inatel.pokedex.apiPoke.ApiPokeService;
import com.projetopokedex.inatel.pokedex.models.Pokemon;
import com.projetopokedex.inatel.pokedex.models.PokemonAnswer;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends Activity{

    private static final String TAG = "POKEDEX";

    private Retrofit retrofit;

    private RecyclerView recyclerView;
    private PokemonListAdapter pokemonListAdapter;

    private int offset;

    private boolean aptoLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        pokemonListAdapter = new PokemonListAdapter(this);
        recyclerView.setAdapter(pokemonListAdapter);
        recyclerView.setHasFixedSize(true);
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if(dy > 0) {
                    int visibleItemCount = layoutManager.getChildCount();
                    int totalItemCount = layoutManager.getItemCount();
                    int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();

                    if (aptoLoad) {
                        if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                            Log.i(TAG, "Finaly");

                            aptoLoad = false;
                            offset += 10;
                            collectData(offset);
                        }
                    }
                }
            }
        });

        final ApiPokeService apiPokeService = ApiClient.getClient().create(ApiPokeService.class);

       retrofit = new Retrofit.Builder()
               .baseUrl("http://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                 .build();

        aptoLoad = true;
        offset = 0;
        collectData(offset);



    }

    private void collectData(int offset) {

        ApiPokeService service = retrofit.create(ApiPokeService.class);
        Call<PokemonAnswer> pokemonAnswerCall = service.collectListPokemon(18, offset);

        pokemonAnswerCall.enqueue(new Callback<PokemonAnswer>() {
            @Override
            public void onResponse(Call<PokemonAnswer> call, Response<PokemonAnswer> response) {
                aptoLoad = true;
                if (response.isSuccessful()) {

                    PokemonAnswer pokemonAnswer = response.body();
                    ArrayList<Pokemon> listPokemon = pokemonAnswer.getResults();

                    pokemonListAdapter.addPokemonList(listPokemon);

                } else {
                    Log.e(TAG, "onResponse" + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<PokemonAnswer> call, Throwable t) {
                aptoLoad = true;
                Log.e(TAG, "onFailure" + t.getMessage());
            }
        });


    }




}
