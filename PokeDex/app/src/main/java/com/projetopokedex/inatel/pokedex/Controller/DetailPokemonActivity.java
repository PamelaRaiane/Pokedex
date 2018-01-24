package com.projetopokedex.inatel.pokedex.Controller;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.projetopokedex.inatel.pokedex.R;
import com.projetopokedex.inatel.pokedex.apiPoke.ApiClient;
import com.projetopokedex.inatel.pokedex.apiPoke.ApiPokeService;
import com.projetopokedex.inatel.pokedex.models.DetailPokemon;

import retrofit2.Callback;
import retrofit2.Response;

public class DetailPokemonActivity extends Activity {

    public TextView tvAttack, tvDefense, tvSpeed, tvName, tvWeight, tvHeight, tvBaseExperience, tvAbilities, tvMoves, tvStats;
    public ImageView ivPokemon;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pokemon);

        tvName = (TextView) findViewById(R.id.tv_detail_name);
        tvAttack = (TextView) findViewById(R.id.tv_detail_attack);
        tvDefense = (TextView) findViewById(R.id.tv_detail_defense);
        tvSpeed = (TextView) findViewById(R.id.tv_detail_speed);
        tvBaseExperience = (TextView) findViewById(R.id.tv_detail_base_experience);
        tvHeight = (TextView) findViewById(R.id.tv_detail_height);
        tvWeight = (TextView) findViewById(R.id.tv_detail_weight);
        tvAbilities = (TextView) findViewById(R.id.tv_detail_abilities);
        tvMoves = (TextView) findViewById(R.id.tv_detail_moves);
        tvStats = (TextView) findViewById(R.id.tv_detail_stats);
        ivPokemon = (ImageView) findViewById(R.id.iv_detail_pokemon);

        String id = getIntent().getStringExtra("name");
        requestData(id);


    }

    private void requestData (String id) {
        final ApiPokeService apiPokeService = ApiClient.getClient().create(ApiPokeService.class);

        retrofit2.Call<DetailPokemon> call = apiPokeService.getDetailPokemon(id);
        call.enqueue(new Callback<DetailPokemon>() {

            @Override
            public void onResponse(retrofit2.Call<DetailPokemon> call, Response<DetailPokemon> response) {
                DetailPokemon detailPokemon;



                if(response.isSuccessful()) {
                    detailPokemon = response.body();



                    tvName.setText("Name: " + detailPokemon.getName());
                    //tvAttack.setText("Attack: " + detailPokemon.);
                    tvBaseExperience.setText("Base Experience: " + detailPokemon.getBaseExperience());
                    tvHeight.setText("Height: " + detailPokemon.getHeight());
                    tvWeight.setText("Weight: " + detailPokemon.getWeight());
                    tvAbilities.setText("Abilities: " + detailPokemon.getGetAbilities());
                    tvMoves.setText("Moves: " + detailPokemon.getGetMoves());


                }

            }

            @Override
            public void onFailure(retrofit2.Call<DetailPokemon> call, Throwable t) {

            }
        });
    }
}
