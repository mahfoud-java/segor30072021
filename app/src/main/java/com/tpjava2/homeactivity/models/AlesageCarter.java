package com.tpjava2.homeactivity.models;

import org.json.JSONException;
import org.json.JSONObject;

public class AlesageCarter {
    private Integer id;
    private Float diametreAlesageCarter;
    private String nomAlesageCarter;
    private  String type;
    private  String norme;
    Reducteur reducteur =  new Reducteur();


    public JSONObject toJson() throws JSONException {

        JSONObject JsonAlesageCarter = new JSONObject();

        JsonAlesageCarter.put("id", this.getId());
        JsonAlesageCarter.put("diametre_alesage_carter", this.getDiametreAlesageCarter());
        JsonAlesageCarter.put("type",this.getType());
        JsonAlesageCarter.put("reducteur",reducteur.toJson());
        return JsonAlesageCarter;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Reducteur getReducteur() {
        return reducteur;
    }

    public void setReducteur(Reducteur reducteur) {
        this.reducteur = reducteur;
    }

    public Float getDiametreAlesageCarter() {
        return diametreAlesageCarter;
    }

    public void setDiametreAlesageCarter(Float diametreAlesageCarter) {
        this.diametreAlesageCarter = diametreAlesageCarter;
    }

    public String getNorme() {
        return norme;
    }

    public void setNorme(String norme) {
        this.norme = norme;
    }

    public String getNomAlesageCarter() {
        return nomAlesageCarter;
    }

    public void setNomAlesageCarter(String nomAlesageCarter) {
        this.nomAlesageCarter = nomAlesageCarter;
    }
}
