package com.projetopokedex.inatel.pokedex.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Pâmela on 23/01/2018.
 */

class GetStats {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("baseStat")
    @Expose
    private String baseStat;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GetStats withName(String name) {
        this.name = name;
        return this;
    }

    public String getBaseStat() {
        return baseStat;
    }

    public void setBaseStat(String baseStat) {
        this.baseStat = baseStat;
    }

    public GetStats withBaseStat(String baseStat) {
        this.baseStat = baseStat;
        return this;
    }

}
