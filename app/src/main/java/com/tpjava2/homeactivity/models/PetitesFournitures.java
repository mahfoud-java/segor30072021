package com.tpjava2.homeactivity.models;

import org.json.JSONException;
import org.json.JSONObject;

public class PetitesFournitures {
    Integer id;
    String nomPetiteFourniture;
    String quantite;
    String reference;
    String matiere;

    public JSONObject toJson() throws JSONException {

        JSONObject JsonPetitesFourniture = new JSONObject();

        JsonPetitesFourniture.put("id", this.getId());
        JsonPetitesFourniture.put("quantite", this.getQuantite());
        JsonPetitesFourniture.put("reference", this.getReference());


        return JsonPetitesFourniture;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuantite() {
        return quantite;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }



    public String getMatiere()
    {
        return matiere == null ?  "Matière"  : this.matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public String getNomPetiteFourniture() {
        return nomPetiteFourniture;
    }

    public void setNomPetiteFourniture(String nomPetiteFourniture) {
        this.nomPetiteFourniture = nomPetiteFourniture;
    }
}
