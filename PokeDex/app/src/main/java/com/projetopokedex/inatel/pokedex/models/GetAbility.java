package com.projetopokedex.inatel.pokedex.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Pâmela on 23/01/2018.
 */

class GetAbility {

    @SerializedName("name")
    @Expose
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GetAbility withName(String name) {
        this.name = name;
        return this;
    }
}
