package com.tpjava2.homeactivity.view;


import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tpjava2.homeactivity.R;
import com.tpjava2.homeactivity.models.Arbre;
import com.tpjava2.homeactivity.models.Engrenage;

import com.tpjava2.homeactivity.models.Mobile;
import com.tpjava2.homeactivity.view.adapter.ListeMobilesAdapter;

import java.util.ArrayList;
import java.util.List;

public class MobilesFragment extends Fragment implements View.OnClickListener {

    private ImageButton imageButtonPlanetaire, imageButtonCylDroit, imageButtonCylHel,
            imageButtonSpiroDroit, imageButtonSpiroConique, imageButtonVis,
            imageButtonArbre, imageButtonChevron,imageButtonAutreEngrenage;
    private List<Mobile> listeMobiles = new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_mobiles, container, false);
        imageButtonPlanetaire = root.findViewById(R.id.imageButton_planetaire);
        imageButtonCylDroit = root.findViewById(R.id.imageButton_cyl_droit);
        imageButtonCylHel= root.findViewById(R.id.imageButton_cyl_helicoidal);
        imageButtonAutreEngrenage = root.findViewById(R.id.imageButton_autre_engrenage);

        imageButtonVis = root.findViewById(R.id.imageButton_vis_sans_fin);
        imageButtonArbre = root.findViewById(R.id.imageButton_arbre);

        imageButtonSpiroDroit = root.findViewById(R.id.imageButton_spiro_droit);
        imageButtonSpiroConique = root.findViewById(R.id.imageButton_spiro_conique);

        imageButtonChevron = root.findViewById(R.id.imageButton_engrenage_chevron);


        recyclerView = root.findViewById(R.id.recyclerView_mobiles);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        imageButtonPlanetaire.setOnClickListener(this::onClick);
        imageButtonCylDroit.setOnClickListener(this::onClick);
        imageButtonCylHel.setOnClickListener(this::onClick);
        imageButtonSpiroDroit.setOnClickListener(this::onClick);
        imageButtonSpiroConique.setOnClickListener(this::onClick);
        imageButtonVis.setOnClickListener(this::onClick);
        imageButtonArbre.setOnClickListener(this::onClick);
        imageButtonChevron.setOnClickListener(this::onClick);
        imageButtonAutreEngrenage.setOnClickListener(this::onClick);


        return root;
    }

    @Override
    public void onClick(View v) {

        Engrenage engrenage = new Engrenage();
        Arbre arbre = new Arbre();


        Dialog alerteAutreEngrenage = new Dialog(this.getContext());
        alerteAutreEngrenage.setContentView(R.layout.alerte_autre_engrenage);
        Button buttonAjouterEngrenage = alerteAutreEngrenage.findViewById(R.id.button_ajouter_autre_engrenage);
        EditText editTextAjouterNomEngrenage  = alerteAutreEngrenage.findViewById(R.id.editText_ajouter_nom_autre_engrenage);
        RadioGroup radioGroupTypeEngrenage  = alerteAutreEngrenage.findViewById(R.id.radioGroup_editer_type_autre_engrenage);
        EditText editTextNumeroTypeEngrenage = alerteAutreEngrenage.findViewById(R.id.editText_numero_autre_engrenage);

        EditText editTextModulePignon  = alerteAutreEngrenage.findViewById(R.id.editText_module_pignon_autre);
        EditText editTextDentsPignon  = alerteAutreEngrenage.findViewById(R.id.editText_dents_pignon_autre);
        EditText editTextModuleRoue  = alerteAutreEngrenage.findViewById(R.id.editText_module_roue_autre);
        EditText editTextDentsRoue = alerteAutreEngrenage.findViewById(R.id.editText_dents_roue_autre);








        Dialog alerteArbre = new Dialog(this.getContext());
        alerteArbre.setContentView(R.layout.alerte_editer_type_arbre);

        Dialog alerteEngrenage = new Dialog(this.getContext());
        alerteEngrenage.setContentView(R.layout.alerte_editer_type_engrenage);





        Button buttonAjouterTypeArbre = alerteArbre.findViewById(R.id.button_ajouter_type_arbre);
        Button buttonAjouterTypeEngrenage= alerteEngrenage.findViewById(R.id.button_ajouter_type_engrenage);

//        EditText editTextAjouterMobile = alerteAutreMobile.findViewById(R.id.editText_ajouter_mobile);
//        TextView textViewTitreAlerteMobile = alerteAutreMobile.findViewById(R.id.textView_titre_alerte_mobile);


        RadioGroup radioGroupArbre = alerteArbre.findViewById(R.id.radioGroup_editer_type_arbre);
        EditText editTextNumeroArbre = alerteArbre.findViewById(R.id.editText_numero_arbre);
        EditText editTextNumeroEngrenage = alerteEngrenage.findViewById(R.id.editText_numero_engrenage);

        RadioGroup radioGroupEngrenage = alerteEngrenage.findViewById(R.id.radioGroup_editer_type_engrenage);


        radioGroupArbre.setOnCheckedChangeListener((radio, id) ->
        {
            switch (id) {

                case R.id.radioButton_pv:
                    arbre.setNom_arbre("ARBRE");
                    arbre.setType("PV");
                    break;
                case R.id.radioButton_mv:
                    arbre.setNom_arbre("ARBRE");
                    arbre.setType("MV");
                    break;
                case R.id.radioButton_gv:
                    arbre.setNom_arbre("ARBRE");
                    arbre.setType("GV");
                    break;
            }});

        radioGroupEngrenage.setOnCheckedChangeListener((radio, id) ->
        {
            switch (id) {

                case R.id.radioButton_pv:

                    engrenage.setType("PV");
                    break;
                case R.id.radioButton_mv:

                    engrenage.setType("MV");
                    break;
                case R.id.radioButton_gv:

                    engrenage.setType("GV");
                    break;
            }});




        switch (v.getId()){

            case R.id.imageButton_arbre:

                alerteArbre.show();
                buttonAjouterTypeArbre.setOnClickListener(v1 -> {
                    arbre.setType(arbre.getType()+editTextNumeroArbre.getText());
                    listeMobiles.add(arbre);
                    recyclerView.setAdapter(new ListeMobilesAdapter(listeMobiles,this.getContext()));
                    alerteArbre.dismiss();
                });


                break;

            case R.id.imageButton_planetaire:
                alerteEngrenage.show();
                buttonAjouterTypeEngrenage.setOnClickListener(v1 -> {
                    engrenage.setNom("ENGRENAGE PLANETAIRE");
                    engrenage.setType(engrenage.getType()+editTextNumeroEngrenage.getText());
                    listeMobiles.add(engrenage);
                    recyclerView.setAdapter(new ListeMobilesAdapter(listeMobiles,this.getContext()));
                    alerteEngrenage.dismiss();
                });
                break;

            case R.id.imageButton_cyl_droit:
                alerteEngrenage.show();
                buttonAjouterTypeEngrenage.setOnClickListener(v1 -> {
                    engrenage.setNom("ENGRENAGE CYLINDRIQUE DROIT");
                    engrenage.setType(engrenage.getType()+editTextNumeroEngrenage.getText());
                    listeMobiles.add(engrenage);
                    recyclerView.setAdapter(new ListeMobilesAdapter(listeMobiles,this.getContext()));
                    alerteEngrenage.dismiss();
                });
                break;

            case R.id.imageButton_cyl_helicoidal:
                alerteEngrenage.show();

                buttonAjouterTypeEngrenage.setOnClickListener(v1 -> {
                    engrenage.setNom("ENGRENAGE CYLINDRIQUE HELICOIDAL");
                    engrenage.setType(engrenage.getType()+editTextNumeroEngrenage.getText());
                    listeMobiles.add(engrenage);
                    recyclerView.setAdapter(new ListeMobilesAdapter(listeMobiles,this.getContext()));
                    alerteEngrenage.dismiss();
                });
                break;

            case R.id.imageButton_vis_sans_fin:
                alerteEngrenage.show();

                buttonAjouterTypeEngrenage.setOnClickListener(v1 -> {
                    engrenage.setNom("ENGRENAGE VIS SANS FIN");
                    engrenage.setType(engrenage.getType()+editTextNumeroEngrenage.getText());
                    listeMobiles.add(engrenage);
                    recyclerView.setAdapter(new ListeMobilesAdapter(listeMobiles,this.getContext()));
                    alerteEngrenage.dismiss();
                });
                break;

            case R.id.imageButton_spiro_droit:
                alerteEngrenage.show();

                buttonAjouterTypeEngrenage.setOnClickListener(v1 -> {
                    engrenage.setNom("ENGRENAGE CONIQUE DROIT");
                    engrenage.setType(engrenage.getType()+editTextNumeroEngrenage.getText());
                    listeMobiles.add(engrenage);
                    recyclerView.setAdapter(new ListeMobilesAdapter(listeMobiles,this.getContext()));
                    alerteEngrenage.dismiss();
                });
                break;

            case R.id.imageButton_spiro_conique:
                alerteEngrenage.show();

                buttonAjouterTypeEngrenage.setOnClickListener(v1 -> {
                    engrenage.setNom("ENGRENAGE SPIRO CONIQUE");
                    engrenage.setType(engrenage.getType()+editTextNumeroEngrenage.getText());
                    listeMobiles.add(engrenage);
                    recyclerView.setAdapter(new ListeMobilesAdapter(listeMobiles,this.getContext()));
                    alerteEngrenage.dismiss();
                });
                break;

            case R.id.imageButton_engrenage_chevron:
                alerteEngrenage.show();

                buttonAjouterTypeEngrenage.setOnClickListener(v1 -> {
                    engrenage.setNom("ENGRENAGE CHEVRON");
                    engrenage.setType(engrenage.getType()+editTextNumeroEngrenage.getText());
                    listeMobiles.add(engrenage);
                    recyclerView.setAdapter(new ListeMobilesAdapter(listeMobiles,this.getContext()));
                    alerteEngrenage.dismiss();
                });
                break;


            case R.id.imageButton_autre_engrenage:


                buttonAjouterEngrenage.setOnClickListener(v1 -> {
                    if(!editTextAjouterNomEngrenage.getText().toString().equals("")) {

                        engrenage.setNom(editTextAjouterNomEngrenage.getText().toString());
                        engrenage.setModulePignon(editTextModulePignon.getText().toString());
                        engrenage.setModuleRoue(editTextModuleRoue.getText().toString());
                        engrenage.setNombreDentPignon(editTextDentsPignon.getText().toString());
                        engrenage.setNombreDentRoue(editTextDentsRoue.getText().toString());
                        engrenage.setType(engrenage.getType() + editTextNumeroTypeEngrenage.getText().toString());

                        listeMobiles.add(engrenage);
                        recyclerView.setAdapter(new ListeMobilesAdapter(listeMobiles,this.getContext()));
                        alerteAutreEngrenage.dismiss();
                    }
                });
                radioGroupTypeEngrenage.setOnCheckedChangeListener((radio, id) ->
                {
                    switch (id) {

                        case R.id.radioButton_autre_pv:

                            engrenage.setType("PV ");
                            break;
                        case R.id.radioButton_autre_mv:

                            engrenage.setType("MV ");
                            break;
                        case R.id.radioButton_autre_gv:

                            engrenage.setType("GV ");
                            break;
                    }});
                alerteAutreEngrenage.show();

                break;


        }


    }
}
