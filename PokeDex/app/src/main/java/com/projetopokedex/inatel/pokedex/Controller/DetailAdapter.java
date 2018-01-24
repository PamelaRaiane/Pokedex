package com.projetopokedex.inatel.pokedex.Controller;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.projetopokedex.inatel.pokedex.models.DetailPokemon;

import java.util.List;

/**
 * Created by hepr9 on 21/01/2018.
 */

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.DetailViewHolder> {

    private List<DetailPokemon> detailPokemonList;


    @Override
    public DetailAdapter.DetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(DetailAdapter.DetailViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class DetailViewHolder extends RecyclerView.ViewHolder {
        public DetailViewHolder(View itemView) {
            super(itemView);
        }
    }
}

