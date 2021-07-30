package com.tpjava2.homeactivity.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.tpjava2.homeactivity.dao.BddLocale;
import com.tpjava2.homeactivity.models.Reducteur;

public class ReducteurController  {

     Context   context;
     BddLocale bddLocale = ConnexionLocalController.getInstance(context);


    public ReducteurController(Context context) {
        this.context = context;
    }

    public boolean insertInformationReducteur(Reducteur reducteur){
        SQLiteDatabase sql =    bddLocale.getWritableDatabase();        //this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("id", reducteur.getId());
        cv.put("constructeur", reducteur.getConstructeur());
        cv.put("type_reducteur", reducteur.getType_reducteur());
        cv.put("N_Serie", reducteur.getN_Serie());
        cv.put("annee_fab", reducteur.getAnnee_fab());
        cv.put("rapport_i", reducteur.getRapport_i());
        cv.put("type_moteur", reducteur.getType_moteur());
        cv.put("client", reducteur.getClient());
        cv.put("date_recu", reducteur.getDate_recu());
        cv.put("cde_expertise", reducteur.getCde_expertise());
        cv.put("code_expertise", reducteur.getCode_expertise());
        cv.put("cde_segor", reducteur.getCde_segor());
        cv.put("nom_demonteur", reducteur.getNom_demonteur());
        cv.put("poid", reducteur.getPoids());
        cv.put("encombrement", reducteur.getEncombrement());
        cv.put("chassis", reducteur.getChassis());
        cv.put("reducteur_livre", reducteur.getReducteur_livre());
        cv.put("type_lubrification", reducteur.getType_lubrification());
        cv.put("quantite", reducteur.getQuantite());
        cv.put("viscosite", reducteur.getViscosite());
        cv.put("assecheur_air", reducteur.getAssecheur());
        cv.put("quantite_graisse", reducteur.getQuantite_graisse());
        long result = sql.insert("Reducteur", null, cv);
        //sql.close();
        if( result == -1){
            return false;
        }else{
            return true;
        }}

    /*public boolean updateInformationReducteur(Reducteur reducteur){
        SQLiteDatabase sql =    bddLocale.getWritableDatabase();        //this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("id", reducteur.getId());
        cv.put("constructeur", reducteur.getConstructeur());
        cv.put("type_reducteur", reducteur.getType_reducteur());
        cv.put("N_Serie", reducteur.getN_Serie());
        cv.put("annee_fab", reducteur.getAnnee_fab());
        cv.put("rapport_i", reducteur.getRapport_i());
        cv.put("type_moteur", reducteur.getType_moteur());
        cv.put("client", reducteur.getClient());
        cv.put("date_recu", reducteur.getDate_recu());
        cv.put("cde_expertise", reducteur.getCde_expertise());
        cv.put("code_expertise", reducteur.getCode_expertise());
        cv.put("cde_segor", reducteur.getCde_segor());
        cv.put("nom_demonteur", reducteur.getNom_demonteur());
        cv.put("poid", reducteur.getPoids());
        cv.put("encombrement", reducteur.getEncombrement());
        cv.put("chassis", reducteur.getChassis());
        cv.put("reducteur_livre", reducteur.getReducteur_livre());
        cv.put("type_lubrification", reducteur.getType_lubrification());
        cv.put("quantite", reducteur.getQuantite());
        cv.put("viscosite", reducteur.getViscosite());
        cv.put("assecheur_air", reducteur.getAssecheur());
        cv.put("quantite_graisse", reducteur.getQuantite_graisse());
        long result = sql.update("Reducteur",  cv,"where id ");
        //sql.close();
        if( result == -1){
            return false;
        }else{
            return true;
        }*/
}
