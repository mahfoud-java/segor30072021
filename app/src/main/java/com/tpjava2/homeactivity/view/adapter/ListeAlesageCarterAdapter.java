package com.tpjava2.homeactivity.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tpjava2.homeactivity.R;
import com.tpjava2.homeactivity.databinding.ItemAlesageCarterBinding;
import com.tpjava2.homeactivity.models.AlesageCarter;

import java.util.ArrayList;
import java.util.List;

public class ListeAlesageCarterAdapter extends    RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<AlesageCarter> alesageCarterList = new ArrayList<>();
    private Context context;
    private  final int VIEW_TYPE_CARTER = 0;
    private  final int VIEW_TYPE_BOUTON = 1;


    public ListeAlesageCarterAdapter(List<AlesageCarter> alesageCarterList, Context context) {
        this.alesageCarterList = alesageCarterList;
        this.context = context;
    }

    public ListeAlesageCarterAdapter(List<AlesageCarter> alesageCarterList) {
    }


    static class AlesageCarterViewHolder extends RecyclerView.ViewHolder{
                ItemAlesageCarterBinding binding;
                ImageButton buttonSupprimerAlesageCarter;


                public AlesageCarterViewHolder(ItemAlesageCarterBinding binding) {
                    super(binding.getRoot());
                    buttonSupprimerAlesageCarter = binding.getRoot().findViewById(R.id.button_supprimer_alesage_carter);
                    this.binding = binding;
                }
        public void bind(AlesageCarter alesageCarter){
            binding.setAlesage(alesageCarter);
            binding.executePendingBindings();
        }

        }


    static  class BoutonAjouterAlesageCarterViewHolder extends  RecyclerView.ViewHolder {
        Button buttonAjouterAlesageCarter;

        public BoutonAjouterAlesageCarterViewHolder(@NonNull View itemView) {
            super(itemView);
            this.buttonAjouterAlesageCarter = itemView.findViewById(R.id.button_ajouter_alesage);
        }
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == VIEW_TYPE_BOUTON){
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.items_button_ajouter_alesage_carter, parent, false);
            return  new BoutonAjouterAlesageCarterViewHolder(view);
        }else {
            LayoutInflater layoutInflater =  LayoutInflater.from(parent.getContext());
            ItemAlesageCarterBinding binding =
                    ItemAlesageCarterBinding.inflate(layoutInflater, parent,false);
            return  new AlesageCarterViewHolder(binding);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position) == VIEW_TYPE_BOUTON){
            BoutonAjouterAlesageCarterViewHolder boutonViewHolder = (BoutonAjouterAlesageCarterViewHolder) holder;
            boutonViewHolder.buttonAjouterAlesageCarter.setOnClickListener(v -> {
                alesageCarterList.add(new AlesageCarter());
                notifyDataSetChanged();
            });
        }else {
            AlesageCarterViewHolder alesageCarterViewHolder = (AlesageCarterViewHolder) holder;
            alesageCarterViewHolder.bind(alesageCarterList.get(position));
            alesageCarterViewHolder.buttonSupprimerAlesageCarter.setOnClickListener(v -> {
                alesageCarterList.remove(position);

                notifyDataSetChanged();
            });

        }}

    @Override
    public int getItemCount() {
        return (alesageCarterList.size())+1;
    }
    @Override
    public int getItemViewType(int position) {
        return  (position == alesageCarterList.size())? VIEW_TYPE_BOUTON : VIEW_TYPE_CARTER;
    }
}
