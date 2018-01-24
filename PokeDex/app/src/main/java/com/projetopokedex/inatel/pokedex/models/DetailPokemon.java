package com.projetopokedex.inatel.pokedex.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pâmela on 23/01/2018.
 */

public class DetailPokemon implements Serializable{

    @SerializedName("name")
    private String name;
    @SerializedName("weight")
    @Expose
    private String weight;
    @SerializedName("height")
    @Expose
    private String height;
    @SerializedName("base_experience")
    @Expose
    private String baseExperience;
    @SerializedName("abilities")
    @Expose
    private List<GetAbility> getAbilities =  new ArrayList<>();
    @SerializedName("getMoves")
    @Expose
    private List<GetMoves> getMoves = new ArrayList<>();
    @Expose
    @SerializedName("getStats")
    private List<GetStats> getStats = new ArrayList<>();



    public DetailPokemon(String name, String weight, String height, String baseExperience,
                         List<GetAbility> getAbilities, List<GetMoves> getMoves, List<GetStats> getStats)  {

        this.baseExperience = baseExperience;
        this.weight = height;
        this.weight = weight;
        this.getAbilities = getAbilities;
        this.getMoves = getMoves;
        this.getStats = getStats;
        this.name = name;


    }

    public String abilitiesToString () {
        String pokeAbilities = "";
        for (int i = 0; i < getAbilities.size(); i++) {
            if(i > 0)
                pokeAbilities += ", ";
            pokeAbilities += getAbilities.get(i).getName();
        }

        return  pokeAbilities;
    }

    public String movesToString () {
        String pokeMoves = "";
        for (int i = 0; i < getMoves.size(); i++) {
            if(i > 0)
                pokeMoves += ", ";
            pokeMoves += getMoves.get(i).getName();
        }

        return  pokeMoves;
    }

    public String statsToString () {
        String pokeStats = "";
        for (int i = 0; i < getStats.size(); i++) {
            if(i > 0)
                pokeStats += ", ";
            pokeStats += getStats.get(i).getName();
        }

        return  pokeStats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getBaseExperience() {
        return baseExperience;
    }

    public void setBaseExperience(String baseExperience) {
        this.baseExperience = baseExperience;
    }

    public List<GetAbility> getGetAbilities() {
        return getAbilities;
    }

    public void setGetAbilities(List<GetAbility> getAbilities) {
        this.getAbilities = getAbilities;
    }

    public List<GetMoves> getGetMoves() {
        return getMoves;
    }

    public void setGetMoves(List<GetMoves> getMoves) {
        this.getMoves = getMoves;
    }

    public List<GetStats> getGetStats() {
        return getStats;
    }

    public void setGetStats(List<GetStats> getStats) {
        this.getStats = getStats;
    }
}
