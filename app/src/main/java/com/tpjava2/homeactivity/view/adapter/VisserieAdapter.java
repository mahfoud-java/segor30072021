package com.tpjava2.homeactivity.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.google.android.material.bottomappbar.BottomAppBar;
import com.tpjava2.homeactivity.R;
import com.tpjava2.homeactivity.controller.ConnexionLocalController;
import com.tpjava2.homeactivity.dao.BddLocale;
import com.tpjava2.homeactivity.models.Accessoire;
import com.tpjava2.homeactivity.models.PetitesFournitures;

import java.util.ArrayList;
import java.util.List;

public class VisserieAdapter extends    RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private PetitesFournitures petitesFournitures = new PetitesFournitures();
    private List<PetitesFournitures> petitesFournituresList = new ArrayList<>();
    private Context context;


    public VisserieAdapter(List<PetitesFournitures> petitesFournituresList, Context context) {
        this.petitesFournituresList = petitesFournituresList;
        this.context = context;
    }


    static class VisserieViewHolder extends RecyclerView.ViewHolder{

        ImageButton buttonSupprimerPetiteFourniture;
        Spinner spinnerMatiere;
        EditText editTextNomVisserie,editTextQuantite,editTextReference;

        BottomAppBar bottomAppBarTeste;



        public VisserieViewHolder(@NonNull View itemView) {
            super(itemView);
            buttonSupprimerPetiteFourniture = itemView.findViewById(R.id.button_supprimer_petite_fourniture);
            spinnerMatiere = itemView.findViewById(R.id.spinner_matiere);
            editTextNomVisserie =itemView.findViewById(R.id.editText_nom_petite_fourniture);
            editTextQuantite =itemView.findViewById(R.id.editText_quantite_visserie);
            editTextReference = itemView.findViewById(R.id.editTextText_reference_petite_fourniture);

        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_visserie, parent,false);

        return new VisserieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        PetitesFournitures petitesFournitures = petitesFournituresList.get(position);
        VisserieViewHolder visserieViewHolder = (VisserieViewHolder) holder;


        visserieViewHolder.editTextNomVisserie.setText(petitesFournitures.getNomPetiteFourniture());
        visserieViewHolder.editTextQuantite.setText(petitesFournitures.getQuantite());
        visserieViewHolder.editTextReference.setText(petitesFournitures.getReference());

        switch (petitesFournitures.getMatiere()) {
            case "acier 8.8":
                visserieViewHolder.spinnerMatiere.setSelection(1);
                break;
            case "acier 12.9":
                visserieViewHolder.spinnerMatiere.setSelection(2);
                break;
            case "inox":
                visserieViewHolder.spinnerMatiere.setSelection(3);
                break;
            default:
                visserieViewHolder.spinnerMatiere.setSelection(0);
                break;
        }

        visserieViewHolder.buttonSupprimerPetiteFourniture.setOnClickListener(v -> {
            BddLocale bddLocale = ConnexionLocalController.getInstance(context);
            Integer id = petitesFournituresList.get(position).getId();
            bddLocale.deletePetitesFournitures(id);
            bddLocale.close();
            petitesFournituresList.remove(position);
            notifyDataSetChanged();

        });




    }

    @Override
    public int getItemCount() {
        return petitesFournituresList.size();
    }

        }


