package com.tpjava2.homeactivity.models;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Tache  implements Serializable {
    Integer id;
    String designation;
    String temps;
    //Integer id_reducteur;//
     Reducteur reducteur = new Reducteur();



    public JSONObject toJson() throws JSONException {

        JSONObject JsonTache = new JSONObject();

        JsonTache.put("id", this.getId());
        JsonTache.put("designation", this.getDesignation());
        JsonTache.put("temps", this.getTemps());
        JsonTache.put("reducteur",reducteur.toJson());
        return JsonTache;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getTemps() {
        return temps;
    }

    public void setTemps(String temps) {
        this.temps = temps;
    }

}
