package com.tpjava2.homeactivity.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.tpjava2.homeactivity.R;
import com.tpjava2.homeactivity.controller.ConnexionLocalController;
import com.tpjava2.homeactivity.dao.BddLocale;
import com.tpjava2.homeactivity.models.Controle;
import com.tpjava2.homeactivity.models.Tache;

import java.util.ArrayList;
import java.util.List;

public class ControleFragment extends Fragment {


    private BottomAppBar bottomAppBarControle;
    List<Controle> controleList = new ArrayList<>();
    //BddLocale bddLocale;
    private CheckBox checkBoxMagneto, checkBoxAlesageCarter, checkBoxGeometrieCarter, checkBoxEtanchite,
            checkBoxCarterSabler;


    public ControleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_controle, container, false);
        init(view);

        bottomAppBarControle.setOnMenuItemClickListener(itemMenu -> {
            if (itemMenu.getItemId() == R.id.item_save) {

                BddLocale bddLocale = ConnexionLocalController.getInstance(this.getContext());
                if (bddLocale.getAllControle().size() == 0) {
                    String realise =checkBoxMagneto.isChecked()  ? "true" : "false";
                    bddLocale.insertionControle(ajouterControle(1, "Magnéto",realise));
                    realise =checkBoxAlesageCarter.isChecked()  ? "true" : "false";
                    bddLocale.insertionControle(ajouterControle(2, "Alésages carter",realise));
                    realise =checkBoxGeometrieCarter.isChecked()  ? "true" : "false";
                    bddLocale.insertionControle(ajouterControle(3, "Géométrie carter", realise));
                    realise =checkBoxEtanchite.isChecked()  ? "true" : "false";
                    bddLocale.insertionControle(ajouterControle(4, "Etanchéité circuit", realise));
                    realise =checkBoxCarterSabler.isChecked()  ? "true" : "false";
                    bddLocale.insertionControle(ajouterControle(5, "Carter à sabler",realise));


                } else {
                    String realise =checkBoxMagneto.isChecked()  ? "true" : "false";
                    bddLocale.updateControle(ajouterControle(1, "Magnéto",realise));
                    realise =checkBoxAlesageCarter.isChecked()  ? "true" : "false";
                    bddLocale.updateControle(ajouterControle(2, "Alésages carter",realise));
                    realise =checkBoxGeometrieCarter.isChecked()  ? "true" : "false";
                    bddLocale.updateControle(ajouterControle(3, "Géométrie carter", realise));
                    realise =checkBoxEtanchite.isChecked()  ? "true" : "false";
                    bddLocale.updateControle(ajouterControle(4, "Etanchéité circuit", realise));
                    realise =checkBoxCarterSabler.isChecked()  ? "true" : "false";
                    bddLocale.updateControle(ajouterControle(5, "Carter à sabler",realise));

                }
                bddLocale.close();
                return true;
            }
            return false;
        });
        return view;
    }

    private Controle ajouterControle(Integer id, String denomination , String realise) {
        Controle controle =  new Controle();
        controle.setId(id);
        controle.setDenomination(denomination);
        controle.setRealise(realise);

        return controle;

    }

    private void init(View view) {

        BddLocale bddLocale = ConnexionLocalController.getInstance(this.getContext());
        bottomAppBarControle = view.findViewById(R.id.bottomAppBar_edition_controle);
        checkBoxMagneto = view.findViewById(R.id.checkBox_magneto);
        checkBoxAlesageCarter = view.findViewById(R.id.checkBox_alesage_carter);
        checkBoxGeometrieCarter = view.findViewById(R.id.checkBox_geometrie_carter);
        checkBoxEtanchite = view.findViewById(R.id.checkBox_etancheite);
        checkBoxCarterSabler = view.findViewById(R.id.checkBox_carter_sabler);


        controleList = bddLocale.getAllControle();

        if (controleList.size() != 0) {
            if(controleList.get(0).getRealise().equals("true") )
                checkBoxMagneto.setChecked(true);

            if(controleList.get(1).getRealise().equals("true"))
                checkBoxAlesageCarter.setChecked(true);

            if(controleList.get(2).getRealise().equals("true") )
                checkBoxGeometrieCarter.setChecked(true);

            if(controleList.get(3).getRealise().equals("true"))
                checkBoxEtanchite.setChecked(true);

            if(controleList.get(4).getRealise().equals("true"))
                checkBoxCarterSabler.setChecked(true);

        }
        bddLocale.close();

    }
}