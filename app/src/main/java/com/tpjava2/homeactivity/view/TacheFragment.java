package com.tpjava2.homeactivity.view;

import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.tpjava2.homeactivity.R;
import com.tpjava2.homeactivity.controller.ConnexionLocalController;
import com.tpjava2.homeactivity.dao.BddLocale;
import com.tpjava2.homeactivity.models.Tache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class TacheFragment extends Fragment {

    private BottomAppBar bottomAppBarTache;
    List<Tache> tacheList = new ArrayList<>();
    //BddLocale bddLocale;
    private EditText editTextDemontage, editTextNettoyage, editTextExpertise, editTextMontage,
            editTextEssai, editTextSablage, editTextcontrole, editTextcolisage;


    public TacheFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tache, container, false);
        init(view);

        bottomAppBarTache.setOnMenuItemClickListener(itemMenu -> {
            if (itemMenu.getItemId() == R.id.item_save) {

                BddLocale bddLocale = ConnexionLocalController.getInstance(this.getContext());
                if (bddLocale.getAllTache().size() == 0) {
                    bddLocale.insertionTache(ajouterTache(1, "Démontage", editTextDemontage.getText().toString()));
                    bddLocale.insertionTache(ajouterTache(2, "Nettoyage", editTextNettoyage.getText().toString()));
                    bddLocale.insertionTache(ajouterTache(3, "Expertise-Etudes", editTextExpertise.getText().toString()));
                    bddLocale.insertionTache(ajouterTache(4, "Montage", editTextMontage.getText().toString()));
                    bddLocale.insertionTache(ajouterTache(5, "Essai", editTextEssai.getText().toString()));
                    bddLocale.insertionTache(ajouterTache(6, "Sablage-Peinture", editTextSablage.getText().toString()));
                    bddLocale.insertionTache(ajouterTache(7, "Contrôle final", editTextcontrole.getText().toString()));
                    bddLocale.insertionTache(ajouterTache(8, "Colisage-Chassis", editTextcolisage.getText().toString()));

                } else {

                    bddLocale.updateTache(ajouterTache(1, "Démontage", editTextDemontage.getText().toString()));
                    bddLocale.updateTache(ajouterTache(2, "Nettoyage", editTextNettoyage.getText().toString()));
                    bddLocale.updateTache(ajouterTache(3, "Expertise-Etudes", editTextExpertise.getText().toString()));
                    bddLocale.updateTache(ajouterTache(4, "Montage", editTextMontage.getText().toString()));
                    bddLocale.updateTache(ajouterTache(5, "Essai", editTextEssai.getText().toString()));
                    bddLocale.updateTache(ajouterTache(6, "Sablage-Peinture", editTextSablage.getText().toString()));
                    bddLocale.updateTache(ajouterTache(7, "Contrôle final", editTextcontrole.getText().toString()));
                    bddLocale.updateTache(ajouterTache(8, "Colisage-Chassis", editTextcolisage.getText().toString()));

                }
                       bddLocale.close();
                return true;
            }
            return false;
        });
        return view;
    }

    private Tache ajouterTache(Integer id, String nom, String temps) {
        Tache tache = new Tache();
        tache.setId(id);
        tache.setDesignation(nom);
        tache.setTemps(temps);
        return tache;

    }

    private void init(View view) {

        BddLocale bddLocale = ConnexionLocalController.getInstance(this.getContext());
        bottomAppBarTache = view.findViewById(R.id.bottomAppBar_edition_controle);
        editTextDemontage = view.findViewById(R.id.editText_tache_demontage);
        editTextNettoyage = view.findViewById(R.id.editText_tache_nettoyage);
        editTextExpertise = view.findViewById(R.id.editText_tache_expertise);
        editTextMontage = view.findViewById(R.id.editText_tache_montage);
        editTextEssai = view.findViewById(R.id.editText_tache_essai);
        editTextSablage = view.findViewById(R.id.editText_tache_sablage);
        editTextcontrole = view.findViewById(R.id.editText_tache_controle);
        editTextcolisage = view.findViewById(R.id.editText_tache_colisage);

        tacheList = bddLocale.getAllTache();
        System.out.println(tacheList.size());
        if (tacheList.size() != 0) {

            editTextDemontage.setText(tacheList.get(0).getTemps());
            editTextNettoyage.setText(tacheList.get(1).getTemps());
            editTextExpertise.setText(tacheList.get(2).getTemps());
            editTextMontage.setText(tacheList.get(3).getTemps());
            editTextEssai.setText(tacheList.get(4).getTemps());
            editTextSablage.setText(tacheList.get(5).getTemps());
            editTextcontrole.setText(tacheList.get(6).getTemps());
            editTextcolisage.setText(tacheList.get(7).getTemps());
        }
           bddLocale.close();

    }
}