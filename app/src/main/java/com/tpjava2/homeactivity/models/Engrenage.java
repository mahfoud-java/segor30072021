package com.tpjava2.homeactivity.models;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Engrenage  extends Mobile  implements Serializable {

    String nom;
    String fonction;
    String type;
    String nombreDentPignon;
    String modulePignon;
    String nombreDentRoue;
    String moduleRoue;
    String inclinaison;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNombreDentPignon() {
        return nombreDentPignon;
    }

    public void setNombreDentPignon(String nombreDentPignon) {
        this.nombreDentPignon = nombreDentPignon;
    }

    public String getModulePignon() {
        return modulePignon;
    }

    public void setModulePignon(String modulePignon) {
        this.modulePignon = modulePignon;
    }

    public String getNombreDentRoue() {
        return nombreDentRoue;
    }

    public void setNombreDentRoue(String nombreDentRoue) {
        this.nombreDentRoue = nombreDentRoue;
    }

    public String getModuleRoue() {
        return moduleRoue;
    }

    public void setModuleRoue(String moduleRoue) {
        this.moduleRoue = moduleRoue;
    }

    public String getInclinaison() {
        return inclinaison;
    }

    public void setInclinaison(String inclinaison) {
        this.inclinaison = inclinaison;
    }

//    public JSONObject toJson() throws JSONException {
//
//        JSONObject JsonEngrenage = new JSONObject();
//
//        JsonEngrenage.put("id", this.getId());
//        JsonEngrenage.put("fonction", this.getFonction());
//        JsonEngrenage.put("nombre_dent", this.getNombre_dent());
//        JsonEngrenage.put("module", this.getModule());
//        JsonEngrenage.put("inclinaison", this.getInclinaison());
//                return JsonEngrenage;
//    }
}
