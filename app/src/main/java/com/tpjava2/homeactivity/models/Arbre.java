package com.tpjava2.homeactivity.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Arbre extends Mobile implements Serializable {

    private String nom_arbre;
    String type;
    String durete;




    List<Portee> porteeList = new ArrayList<>();
    List<AlesageArbre> alesage_arbreList = new ArrayList<>();

    public String getNom_arbre() {
        return nom_arbre;
    }

    public void setNom_arbre(String nom_arbre) {
        this.nom_arbre = nom_arbre;
    }

    public JSONObject toJson() throws JSONException {

        JSONObject JsonArbre = new JSONObject();

        JsonArbre.put("id", this.getId());
        JsonArbre.put("nom_arbre", this.getNom_arbre());
        JSONArray listePortee = new JSONArray();

        for (Portee portee :this.porteeList){
            listePortee.put(portee.toJson());
        }
        JsonArbre.put("listePortee",porteeList);
        JSONArray listeAlesage_arbre = new JSONArray();

        for (AlesageArbre alesage_arbre :this.alesage_arbreList){
            listeAlesage_arbre.put(alesage_arbre.toJson());
        }
        JsonArbre.put("listeAlesage_arbre",alesage_arbreList);

        return JsonArbre;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Portee> getPorteeList() {
        return porteeList;
    }

    public void setPorteeList(List<Portee> porteeList) {
        this.porteeList = porteeList;
    }

    public List<AlesageArbre> getAlesage_arbreList() {
        return alesage_arbreList;
    }

    public void setAlesage_arbreList(List<AlesageArbre> alesage_arbreList) {
        this.alesage_arbreList = alesage_arbreList;
    }

    public String getDurete() {
        return durete;
    }

    public void setDurete(String durete) {
        this.durete = durete;
    }
}
