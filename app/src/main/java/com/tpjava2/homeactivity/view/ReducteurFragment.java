package com.tpjava2.homeactivity.view;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.Intent;
import android.hardware.camera2.CameraOfflineSession;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.tpjava2.homeactivity.R;
import com.tpjava2.homeactivity.controller.ConnexionLocalController;
import com.tpjava2.homeactivity.dao.BddLocale;
import com.tpjava2.homeactivity.models.Reducteur;

public class ReducteurFragment extends Fragment {

    private BottomAppBar bottomAppBarReducteur;
    Reducteur reducteur = new Reducteur();
    Reducteur  reducteurAvecID = new Reducteur();
    BddLocale bddLocale ;
    boolean choix;
    Uri uri;
    EditText editText_n_offre,editText_constructeur, editText_type, editText_n_serie, editText_annee_de_fab, editText_rapport, editText_type_moteur, editText_client, editText_recu_le,
            editText_cde_expertise, editText_code_expertise, editText_cde_segor, editText_nom_demonteur, editText_poids_sans_huile, editText_encombrement, editText_quantite, editText_viscosite, editText_quantite_graisse;
//     RadioButton radioButton_oui_chassis, radioButton_non_chassis, radioButton_reducteur_monte, radioButton_reducteur_demonte, radioButton_type_huile, radioButton_type_graisse,
//            radioButton_assecheur_oui, radioButton_assecheur_non;
    RadioGroup radioGroup_chassis , radioGroup_reducteur_livre , radioGroup_type_inspection, radioGroup_assecheur;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_reducteur, container, false);
        bddLocale =  ConnexionLocalController.getInstance(this.getContext());
        init(rootView);

        editText_n_offre.getText();
        System.out.println(editText_n_offre.getText());
        if(!editText_n_offre.getText().toString().equals("") ){
                editText_n_offre.setEnabled(false);
        }

        //creer et recupere la vue avec le fragment xml

        //methode recupere la totalité des elements du fragment


        //ecouter les differents items de la barre de menu
        bottomAppBarReducteur.setOnMenuItemClickListener(itemMenu -> {
            if (itemMenu.getItemId() == R.id.item_photo) {

                ContentValues cv = new ContentValues();
                cv.put(MediaStore.Images.Media.TITLE, "titreImage");
                cv.put(MediaStore.Images.Media.DESCRIPTION, "DescriptionImage");
                uri = this.getContext().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, cv);
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                startActivity(intent);
                return true;
            }
            if (itemMenu.getItemId() == R.id.item_save) {

                     if (!(editText_n_offre.getText().toString()).equals(""))
                         reducteur.setId(Integer.parseInt(editText_n_offre.getText().toString()));
                     //recupere l'ensemble des champs renseignés et charge le model Reducteur
                     reducteur.setRapport_i(editText_rapport.getText().toString());
                     reducteur.setCde_expertise(editText_cde_expertise.getText().toString());
                     reducteur.setCode_expertise(editText_code_expertise.getText().toString());
                     reducteur.setPoids(editText_poids_sans_huile.getText().toString());
                     reducteur.setCde_segor(editText_cde_segor.getText().toString());
                     reducteur.setQuantite(editText_quantite.getText().toString());
                     reducteur.setViscosite(editText_viscosite.getText().toString());
                     reducteur.setQuantite_graisse(editText_quantite_graisse.getText().toString());
                     reducteur.setConstructeur(editText_constructeur.getText().toString());
                     reducteur.setType_reducteur(editText_type.getText().toString());
                     reducteur.setN_Serie(editText_n_serie.getText().toString());
                     reducteur.setAnnee_fab(editText_annee_de_fab.getText().toString());
                     reducteur.setType_moteur(editText_type_moteur.getText().toString());
                     reducteur.setClient(editText_client.getText().toString());
                     reducteur.setDate_recu(editText_recu_le.getText().toString());
                     reducteur.setNom_demonteur(editText_nom_demonteur.getText().toString());
                     reducteur.setEncombrement(editText_encombrement.getText().toString());
                if(bddLocale.getReducteurById(Integer.parseInt(editText_n_offre.getText().toString())) == null) {
                   boolean insertData = bddLocale.insertInformationReducteur(reducteur);

                    if(insertData == true){
                        Toast.makeText(this.getActivity(), "Successfully Entered Data",Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(this.getActivity(), "Erreur",Toast.LENGTH_LONG).show();
                    }

                }else{

                    boolean updateData =bddLocale.updateInformationReducteur(reducteur);

                    if(updateData == true){
                        Toast.makeText(this.getActivity(), "Successfully Entered Data",Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(this.getActivity(), "Erreur",Toast.LENGTH_LONG).show();
                    }
                }
                      editText_n_offre.setEnabled(false);
                     return true;
                 }
            return false;
        });

        radioGroup_reducteur_livre.setOnCheckedChangeListener((radio, id) ->
        {
            switch (id) {

                case R.id.radioButton_monte_reducteur_livre:
                    reducteur.setReducteur_livre("true");
                    break;
                case R.id.radioButton_demonte_reducteur_livre:
                    reducteur.setReducteur_livre("false");
                    break;
            }});


        radioGroup_type_inspection.setOnCheckedChangeListener((radio , id) -> {
            switch (id) {
                case R.id.radioButton_type_huile:

                    reducteur.setType_lubrification("huile");
                    break;
                case R.id.radioButton_type_graisse:
                    reducteur.setType_lubrification("graisse");
                    break;
            }

        });


        radioGroup_assecheur.setOnCheckedChangeListener((radio, id) ->
        {
            switch (id) {

                case R.id.radioButton_oui_assecheur:
                    reducteur.setAssecheur("true");
                    break;
                case R.id.radioButton_non_assecheur:
                    reducteur.setAssecheur("false");
                    break;
            }});

        radioGroup_chassis.setOnCheckedChangeListener((radio, id) ->
        {
            switch (id) {

                case R.id.radioButton_oui_chassis:

                    reducteur.setChassis("true");
                    break;
                case R.id.radioButton_non_chassis:
                    reducteur.setChassis("false");
                    break;
            }
    });
    return rootView;}

    private void init(View view) {


        bddLocale =  ConnexionLocalController.getInstance(this.getContext());
        bottomAppBarReducteur = view.findViewById(R.id.bottomAppBar_reducteur);
        editText_n_offre =  view.findViewById(R.id.editText_numero_offre);
        bottomAppBarReducteur = view.findViewById(R.id.bottomAppBar_reducteur);
        editText_constructeur = view.findViewById(R.id.editText_constructeur);
        editText_type = view.findViewById(R.id.editText_type_reducteur);
        editText_n_serie =  view.findViewById(R.id.editText_numero_serie);
        editText_annee_de_fab = view.findViewById(R.id.editText_annee_fab);
        editText_rapport = view.findViewById(R.id.editText_rapport);
        editText_type_moteur =  view.findViewById(R.id.editText_type_moteur);
        editText_client =  view.findViewById(R.id.editText_client);
        editText_recu_le =  view.findViewById(R.id.editTextr_date_reception);
        editText_cde_expertise = view.findViewById(R.id.editText_cde_expertise);
        editText_code_expertise =  view.findViewById(R.id.editText_code_expertise);
        editText_cde_segor =  view.findViewById(R.id.editText_cde_SEGOR);
        editText_nom_demonteur =  view.findViewById(R.id.editText_nom_demonteur);
        editText_poids_sans_huile =  view.findViewById(R.id.editText_poids);
        editText_encombrement = view.findViewById(R.id.editText_encombrement);
        editText_quantite = view.findViewById(R.id.editText_quantite);
        editText_viscosite = view.findViewById(R.id.editText_viscosite);
        editText_quantite_graisse = view.findViewById(R.id.editText_quantite_graisse);
        RadioButton   radioButton_oui_chassis = view.findViewById(R.id.radioButton_oui_chassis);
        RadioButton  radioButton_non_chassis  = view.findViewById(R.id.radioButton_non_chassis);
        RadioButton radioButton_reducteur_monte = view.findViewById(R.id.radioButton_monte_reducteur_livre);
        RadioButton  radioButton_reducteur_demonte = view.findViewById(R.id.radioButton_demonte_reducteur_livre);
        RadioButton  radioButton_type_huile = view.findViewById(R.id.radioButton_type_huile);
        RadioButton  radioButton_type_graisse = view.findViewById(R.id.radioButton_type_graisse);
        RadioButton radioButton_assecheur_oui = view.findViewById(R.id.radioButton_oui_assecheur);
        RadioButton  radioButton_assecheur_non = view.findViewById(R.id.radioButton_non_assecheur);
        radioGroup_chassis =  view.findViewById(R.id.radioGroup_chassis);
        radioGroup_reducteur_livre =  view.findViewById(R.id.radioGrop_reducteur_livre);
        radioGroup_type_inspection = view.findViewById(R.id.radioGroup_type_inspection);
        radioGroup_assecheur  = view.findViewById(R.id.radioGroup_Assecheur);


            Reducteur reducteurRec = bddLocale.getReducteur();
            if (reducteurRec != null) {
                editText_n_offre.setText(""+reducteurRec.getId());
                editText_constructeur.setText(reducteurRec.getConstructeur());
                editText_type.setText(reducteurRec.getType_reducteur());
                editText_n_serie.setText(reducteurRec.getN_Serie());
                editText_annee_de_fab.setText(reducteurRec.getAnnee_fab());
                editText_rapport.setText(reducteurRec.getRapport_i());
                editText_type_moteur.setText(reducteurRec.getType_moteur());
                editText_client.setText(reducteurRec.getClient());
                editText_recu_le.setText(reducteurRec.getDate_recu());
                editText_cde_expertise.setText(reducteurRec.getCde_expertise());
                editText_code_expertise.setText(reducteurRec.getCode_expertise());
                editText_cde_segor.setText(reducteurRec.getCde_segor());
                editText_nom_demonteur.setText(reducteurRec.getNom_demonteur());
                editText_poids_sans_huile.setText(reducteurRec.getPoids());
                editText_encombrement.setText(reducteurRec.getEncombrement());
                editText_quantite.setText(reducteurRec.getQuantite());
                editText_viscosite.setText(reducteurRec.getViscosite());


                if(reducteurRec.getChassis().equals("true") ){
                    radioButton_oui_chassis.setChecked(true);
                    //radioGroup_chassis.check(R.id.radioButton_oui_chassis);
                }else if(reducteurRec.getChassis().equals("false")){
                    radioButton_non_chassis.setChecked(true);
                    //radioGroup_chassis.check(R.id.radioButton_non_chassis);
                }
                if(reducteurRec.getReducteur_livre().equals("true")){
                    radioButton_reducteur_monte.setChecked(true);
                    //radioGroup_chassis.check(R.id.radioButton_oui_chassis);
                }else if(reducteurRec.getReducteur_livre().equals("false")){
                    radioButton_reducteur_demonte.setChecked(true);
                    //radioGroup_chassis.check(R.id.radioButton_non_chassis);
                }

                if(reducteurRec.getType_lubrification().equals("huile")){
                    radioButton_type_huile.setChecked(true);
                    //radioGroup_chassis.check(R.id.radioButton_oui_chassis);
                }else if(reducteurRec.getType_lubrification().equals("graisse")){
                    radioButton_type_graisse.setChecked(true);
                    //radioGroup_chassis.check(R.id.radioButton_non_chassis);
                }


                if(reducteurRec.getAssecheur().equals("true")){
                    radioButton_assecheur_oui.setChecked(true);
                    //radioGroup_chassis.check(R.id.radioButton_oui_chassis);
                }else if(reducteurRec.getAssecheur().equals("false")){
                    radioButton_assecheur_non.setChecked(true);
                    //radioGroup_chassis.check(R.id.radioButton_non_chassis);
                }
                editText_quantite_graisse.setText(reducteurRec.getQuantite_graisse());

            }else{
                afficherDial();
            }
        }

    private void afficherDial() {
        Dialog dialog = new Dialog(this.getContext());
        dialog.setContentView(R.layout.alerte_photo_reducteur);
        Button button = dialog.findViewById(R.id.button_confirmer_alerte_nouveau_devis_reducteur);
        button.setOnClickListener(v -> {
            //BddLocale bddLocale = ConnexionLocalController.getInstance(this.getContext());
            dialog.dismiss();
        });
        dialog.show();
    }
}

