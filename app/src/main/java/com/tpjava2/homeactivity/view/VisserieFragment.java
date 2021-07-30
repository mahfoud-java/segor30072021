package com.tpjava2.homeactivity.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.tpjava2.homeactivity.R;
import com.tpjava2.homeactivity.controller.ConnexionLocalController;
import com.tpjava2.homeactivity.dao.BddLocale;
import com.tpjava2.homeactivity.models.PetitesFournitures;
import com.tpjava2.homeactivity.models.Reducteur;
import com.tpjava2.homeactivity.view.adapter.VisserieAdapter;

import java.util.ArrayList;
import java.util.List;

public class VisserieFragment extends Fragment {

    List<PetitesFournitures> petitesFournituresList = new ArrayList<>();
    private RecyclerView recyclerView;

    Reducteur reducteur =  new Reducteur();
    BottomAppBar bottomAppBar;
    ImageButton buttonAjouterVisserie;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_visserie, container, false);
        recyclerView = root.findViewById(R.id.recyclerView_liste_petites_fournitures);
        bottomAppBar = root.findViewById(R.id.bottomAppBar_petites_fournitures);
        buttonAjouterVisserie = root.findViewById(R.id.imageButton_ajouter_visserie);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        BddLocale bddLocale = ConnexionLocalController.getInstance(this.getContext());
        petitesFournituresList = bddLocale.getAllPetitesFournitures();
        bddLocale.close();
        recyclerView.setAdapter(new VisserieAdapter(petitesFournituresList, this.getContext()));

        buttonAjouterVisserie.setOnClickListener(v->{
            BddLocale bddLocale1 = ConnexionLocalController.getInstance(this.getContext());
            boolean insertData = bddLocale1.insertionPetitesFourniture(new PetitesFournitures());
            petitesFournituresList = bddLocale1.getAllPetitesFournitures();
            recyclerView.setAdapter(new VisserieAdapter(petitesFournituresList,this.getContext()));
            bddLocale1.close();
        });

/*
        bottomAppBar.setOnMenuItemClickListener(itemMenu -> {

            if (itemMenu.getItemId() == R.id.item_save) {
                    BddLocale bddLocale2 = ConnexionLocalController.getInstance(this.getContext());
                    boolean insertData = bddLocale2.updatePetitesFourniture(petitesFournituresList.get(0));
                    bddLocale2.close();
                    if(insertData == true){
                        Toast.makeText(this.getContext(), "Successfully Entered Data",Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(this.getContext(), "Erreur",Toast.LENGTH_LONG).show();
                    }


                return true;

            }
            return false;
        });
*/
        return root;

    }





}