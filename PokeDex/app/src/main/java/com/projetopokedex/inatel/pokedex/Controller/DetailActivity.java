package com.projetopokedex.inatel.pokedex.Controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.projetopokedex.inatel.pokedex.R;
import com.projetopokedex.inatel.pokedex.apiPoke.ApiClient;
import com.projetopokedex.inatel.pokedex.apiPoke.ApiPokeService;
import com.projetopokedex.inatel.pokedex.models.DetailPokemon;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by hepr9 on 21/01/2018.
 */

public class DetailActivity  extends Activity{

    List<DetailPokemon> detailList = new ArrayList<>();
    RecyclerView recyclerView;
    PokemonListAdapter pokemonListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pokemon);

        recyclerView = (RecyclerView) findViewById(R.id.rv_details);

        pokemonListAdapter = new PokemonListAdapter(getApplicationContext());

        RecyclerView.LayoutManager layoutManager;
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(pokemonListAdapter);

        recyclerView.addOnItemTouchListener( new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(DetailActivity.this, DetailPokemonActivity.class);
                intent.putExtra("ID, ", detailList.get(position).getName());
                startActivity(intent);

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }

        ));


    }

    private void addData() {
        ApiPokeService apiPokeService = ApiClient.getClient().create(ApiPokeService.class);

        for (int i = 1; i <= 30; i++) {
            Call<DetailPokemon> call = apiPokeService.getDetailPokemon(i);
            call.enqueue(new Callback<DetailPokemon>() {
                @Override
                public void onResponse(Call<DetailPokemon> call, Response<DetailPokemon> response) {
                    if (response.isSuccessful()) {
                        DetailPokemon detail = response.body();

                        detailList.add(detail);
                        pokemonListAdapter.notifyDataSetChanged();

                        Log.i("Pokemon", "Name: " + detail.getName());
                /*       Log.i("Pokemon", "Attack: " + detail.getAttack());
                       Log.i("Pokemon", "Defense: " + detail.getDefense());
                       Log.i("Pokemon", "Speed: " + detail.getSpeed());
                       Log.i("Pokemon", "Health: " + detail.getHealth());
                       Log.i("Pokemon", "Base Experience: " + detail.getBase_experience());
                       Log.i("Pokemon", "Height: " + detail.getHeight());
                       Log.i("Pokemon", "Weight: " + detail.getWeight());
                       Log.i("Pokemon", "Abilities: " + detail.getPokeAbilities());
                       Log.i("Pokemon", "Moves: " + detail.getPokeMoves());
                       Log.i("Pokemon", "Types: " + detail.getPokeTypes());
*/
                    }
                }

                @Override
                public void onFailure(Call<DetailPokemon> call, Throwable t) {

                }
            });
        }

    }

}
