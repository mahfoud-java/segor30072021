package com.tpjava2.homeactivity.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.tpjava2.homeactivity.R;
import com.tpjava2.homeactivity.controller.ConnexionLocalController;
import com.tpjava2.homeactivity.dao.BddLocale;
import com.tpjava2.homeactivity.models.Accessoire;
import com.tpjava2.homeactivity.models.AlesageCarter;
import com.tpjava2.homeactivity.models.Carter;
import com.tpjava2.homeactivity.models.Reducteur;
import com.tpjava2.homeactivity.view.adapter.ListeAlesageCarterAdapter;


import java.util.ArrayList;
import java.util.List;

public class CarterFragment extends Fragment {

    RecyclerView recyclerView;
    AlesageCarter alesageCarter = new AlesageCarter();
    List<AlesageCarter> alesageCarterList = new ArrayList<>();


    Carter carter = new Carter();
    private BottomAppBar bottomAppBarCarter;
    EditText editText_hauteur, editText_longueur, editText_largeur;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_carter, container, false);
        editText_hauteur = rootView.findViewById(R.id.editText_hauteur);
        editText_longueur = rootView.findViewById(R.id.editText_longueur);
        editText_largeur = rootView.findViewById(R.id.editText_largeur);
        bottomAppBarCarter = rootView.findViewById(R.id.bottomAppBar2);

        recyclerView = rootView.findViewById(R.id.recyclerView_alesage_carter);



        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        recyclerView.setAdapter(new ListeAlesageCarterAdapter(alesageCarterList));

        bottomAppBarCarter.setOnMenuItemClickListener(itemMenu -> {
            if (itemMenu.getItemId() == R.id.item_save) {
                BddLocale bddLocale = ConnexionLocalController.getInstance(this.getContext());
                carter.setLongueur(Float.parseFloat(editText_longueur.getText().toString()));
                carter.setLargeur(Float.parseFloat(editText_largeur.getText().toString()));
                carter.setHauteur(Float.parseFloat(editText_hauteur.getText().toString()));

                for (AlesageCarter alesageCarter :this.alesageCarterList) {
                    boolean insertDataAlesage = bddLocale.insertionAlesageCarter(alesageCarter);

                }

                boolean insertData = bddLocale.insertionCarter(carter);
                if(insertData == true){
                    Toast.makeText(this.getActivity(), "Successfully Entered Data",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this.getActivity(), "Erreur",Toast.LENGTH_LONG).show();
                }


                return true;
            }
            return false;
        });

        return rootView;
    }
}
