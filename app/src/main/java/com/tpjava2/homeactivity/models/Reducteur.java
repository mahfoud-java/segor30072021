package com.tpjava2.homeactivity.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Reducteur implements Serializable {

    Integer id; String constructeur; String type_reducteur; String  N_Serie; String annee_fab;String rapport_i; String type_moteur;
    String client; String date_recu;   String cde_expertise; String code_expertise;  String cde_segor; String nom_demonteur;
    String poids ; String encombrement;  String chassis;  String reducteur_livre; String type_lubrification; String quantite;
    String viscosite; String assecheur ; String quantite_graisse;
    List<Controle> controleList = new ArrayList<>();
    List<AlesageCarter> alesage_carterList = new ArrayList<>();
    List<PetitesFournitures> petitesFournituresList = new ArrayList<>();
    List<Accessoire> accessoireList = new ArrayList<>();


    public Reducteur(Integer id, String constructeur, String type_reducteur, String n_Serie, String annee_fab, String rapport_i,
                     String type_moteur, String client, String date_recu, String cde_expertise, String code_expertise, String cde_segor,
                     String nom_demonteur, String poids, String encombrement, String chassis, String reducteur_livre, String type_lubrification,
                     String quantite, String viscosite, String assecheur, String quantite_graisse) {

        this.id =id;
        this.constructeur = constructeur;
        this.type_reducteur = type_reducteur;
        N_Serie = n_Serie;
        this.annee_fab = annee_fab;
        this.rapport_i = rapport_i;
        this.type_moteur = type_moteur;
        this.client = client;
        this.date_recu = date_recu;
        this.cde_expertise = cde_expertise;
        this.code_expertise = code_expertise;
        this.cde_segor = cde_segor;
        this.nom_demonteur = nom_demonteur;
        this.poids = poids;
        this.encombrement = encombrement;
        this.chassis = chassis;
        this.reducteur_livre = reducteur_livre;
        this.type_lubrification = type_lubrification;
        this.quantite = quantite;
        this.viscosite = viscosite;
        this.assecheur = assecheur;
        this.quantite_graisse = quantite_graisse;
    }


    public JSONObject toJson() throws JSONException {

        JSONObject jsonReducteur = new JSONObject();

        jsonReducteur.put("id", this.getId());
        jsonReducteur.put("constructeur", this.getConstructeur());
        jsonReducteur.put("type_reducteur", this.getType_reducteur());
        jsonReducteur.put("N_Serie", this.getN_Serie());
        jsonReducteur.put("annee_fab", this.getAnnee_fab());
        jsonReducteur.put("rapport_i", this.getRapport_i());
        jsonReducteur.put("type_moteur", this.getType_moteur());
        jsonReducteur.put("client", this.getClient());
        jsonReducteur.put("date_recu", this.getDate_recu());
        jsonReducteur.put("cde_expertise", this.getCde_expertise());
        jsonReducteur.put("code_expertise", this.getCode_expertise());
        jsonReducteur.put("cde_segor", this.getCde_segor());
        jsonReducteur.put("nom_demonteur", this.getNom_demonteur());
        jsonReducteur.put("poids", this.getPoids());
        jsonReducteur.put("encombrement", this.getEncombrement());
        jsonReducteur.put("chassis", this.getChassis());
        jsonReducteur.put("reducteur_livre", this.getReducteur_livre());
        jsonReducteur.put("type_lubrification", this.getType_lubrification());
        jsonReducteur.put("quantite", this.getQuantite());
        jsonReducteur.put("viscosite", this.getViscosite());
        jsonReducteur.put("assecheur", this.getAssecheur());
        jsonReducteur.put("quantite_graisse", this.getQuantite_graisse());


        JSONArray listePetitesFournitures = new JSONArray();
        for (PetitesFournitures petitesFournitures :this.petitesFournituresList){
            listePetitesFournitures.put(petitesFournitures.toJson());
        }
        jsonReducteur.put("listePetitesFournitures", petitesFournituresList);

        JSONArray listeAccessoires = new JSONArray();
        for (Accessoire accessoire :this.accessoireList){
            listeAccessoires.put(accessoire.toJson());
        }
        jsonReducteur.put("listeAccessoires", accessoireList);

        JSONArray listeAlesages_carter = new JSONArray();
        for (AlesageCarter alesage_carter :this.alesage_carterList){
            listeAlesages_carter.put(alesage_carter.toJson());
        }
        jsonReducteur.put("listeAlesages_carter", alesage_carterList);

        JSONArray listeControles = new JSONArray();
        for (Controle controle :this.controleList){
            listeControles.put(controle.toJson());
        }
        jsonReducteur.put("listeControles", controleList);

        /*JSONArray listeMobiles = new JSONArray();
        for (Mobile mobiles :this.mobileList){
            listeMobiles.put(mobiles.toJson());
        }
        jsonReducteur.put("listeMobiles", mobileList);*/


        return jsonReducteur;
    }

    public Reducteur() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public String getConstructeur() {
        return constructeur;
    }

    public void setConstructeur(String constructeur) {
        this.constructeur = constructeur;
    }

    public String getType_reducteur() {
        return type_reducteur;
    }

    public void setType_reducteur(String type_reducteur) {
        this.type_reducteur = type_reducteur;
    }

    public String getN_Serie() {
        return N_Serie;
    }

    public void setN_Serie(String n_Serie) {
        N_Serie = n_Serie;
    }

    public String getAnnee_fab() {
        return annee_fab;
    }

    public void setAnnee_fab(String annee_fab) {
        this.annee_fab = annee_fab;
    }

    public String getRapport_i() {
        return rapport_i;
    }

    public void setRapport_i(String rapport_i) {
        this.rapport_i = rapport_i;
    }

    public String getQuantite() {
        return quantite;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

    public String getViscosite() {
        return viscosite;
    }

    public void setViscosite(String viscosite) {
        this.viscosite = viscosite;
    }

    public String getQuantite_graisse() {
        return quantite_graisse;
    }

    public void setQuantite_graisse(String quantite_graisse) {
        this.quantite_graisse = quantite_graisse;
    }

    public String getType_moteur() {
        return type_moteur;
    }

    public void setType_moteur(String type_moteur) {
        this.type_moteur = type_moteur;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getDate_recu() {
        return date_recu;
    }

    public void setDate_recu(String date_recu) {
        this.date_recu = date_recu;
    }

    public String getCde_expertise() {
        return cde_expertise;
    }

    public void setCde_expertise(String cde_expertise) {
        this.cde_expertise = cde_expertise;
    }

    public String getCode_expertise() {
        return code_expertise;
    }

    public void setCode_expertise(String code_expertise) {
        this.code_expertise = code_expertise;
    }

    public String getCde_segor() {
        return cde_segor;
    }

    public void setCde_segor(String cde_segor) {
        this.cde_segor = cde_segor;
    }

    public String getNom_demonteur() {
        return nom_demonteur;
    }

    public void setNom_demonteur(String nom_demonteur) {
        this.nom_demonteur = nom_demonteur;
    }

    public String getPoids() {
        return poids;
    }

    public void setPoids(String poids) {
        this.poids = poids;
    }

    public String getEncombrement() {
        return encombrement;
    }

    public void setEncombrement(String encombrement) {
        this.encombrement = encombrement;
    }

    public String getChassis()

    {if(chassis == null){
        return "null";
    }
        return chassis;
    }

    public void setChassis(String chassis) {

        this.chassis = chassis;
    }

    public String getReducteur_livre() {
        if(reducteur_livre == null) {
            return "null";
        }
        return reducteur_livre;
    }

    public void setReducteur_livre(String reducteur_livre) {
        this.reducteur_livre = reducteur_livre;
    }

    public String getType_lubrification() {
        if(type_lubrification == null) {
            return "null";
        }

        return type_lubrification;
    }

    public void setType_lubrification(String type_lubrification) {
        this.type_lubrification = type_lubrification;
    }

    public List<Controle> getControleList() {
        return controleList;
    }

    public void setControleList(List<Controle> controleList) {
        this.controleList = controleList;
    }

    public List<AlesageCarter> getAlesage_carterList() {
        return alesage_carterList;
    }

    public void setAlesage_carterList(List<AlesageCarter> alesage_carterList) {
        this.alesage_carterList = alesage_carterList;
    }

    public List<PetitesFournitures> getPetitesFournituresList() {
        return petitesFournituresList;
    }

    public void setPetitesFournituresList(List<PetitesFournitures> petitesFournituresList) {
        this.petitesFournituresList = petitesFournituresList;
    }

    public List<Accessoire> getAccessoireList() {
        return accessoireList;
    }

    public void setAccessoireList(List<Accessoire> accessoireList) {
        this.accessoireList = accessoireList;
    }


    public String getAssecheur() {

        if(assecheur == null) {
            return "null";
        }
        return assecheur;
    }

    public void setAssecheur(String assecheur) {
        this.assecheur = assecheur;
    }




}
