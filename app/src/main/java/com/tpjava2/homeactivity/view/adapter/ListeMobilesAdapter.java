package com.tpjava2.homeactivity.view.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tpjava2.homeactivity.AlesageActivity;
import com.tpjava2.homeactivity.R;
import com.tpjava2.homeactivity.models.Arbre;
import com.tpjava2.homeactivity.models.Engrenage;
import com.tpjava2.homeactivity.models.Mobile;

import java.util.List;

public class ListeMobilesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
private List<Mobile> listeMobiles;
    private Context context;
   private int VIEWTYPE_ARBRE = 1;
    private int VIEWTYPE_ENGRENAGE = 2;

    public ListeMobilesAdapter(List<Mobile> listeMobiles, Context context) {
        this.listeMobiles = listeMobiles;
        this.context = context;
    }

    static class MobileViewHolder extends RecyclerView.ViewHolder{
        private TextView textViewMobile;
        private TextView textViewMobileType;
        private ImageButton imageButtonRetirerMobile;

        public MobileViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewMobile = itemView.findViewById(R.id.textView_nom_mobile);
            textViewMobileType = itemView.findViewById(R.id.textView_type_mobile);
            imageButtonRetirerMobile = itemView.findViewById(R.id.imageButton_retirer_mobile);
        }
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_mobile, parent, false);
            return new MobileViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if(holder.getItemViewType() == VIEWTYPE_ARBRE){
            Arbre mobile = (Arbre) listeMobiles.get(position);

            MobileViewHolder arbreViewHolder = (MobileViewHolder) holder;
            arbreViewHolder.textViewMobile.setText(mobile.getNom_arbre());
            arbreViewHolder.textViewMobileType.setText(mobile.getType());


            arbreViewHolder.imageButtonRetirerMobile.setOnClickListener(v -> {
                listeMobiles.remove(position);
                notifyDataSetChanged();
            });


        }else{
            Engrenage mobile = (Engrenage) listeMobiles.get(position);
            MobileViewHolder engrenageViewHolder = (MobileViewHolder) holder;
            engrenageViewHolder.textViewMobile.setText(mobile.getNom());
            engrenageViewHolder.textViewMobileType.setText(mobile.getType());


            engrenageViewHolder.imageButtonRetirerMobile.setOnClickListener(v -> {
                listeMobiles.remove(position);
                notifyDataSetChanged();
            });


        }





    }

    @Override
    public int getItemCount() {
        return listeMobiles.size();
    }

    @Override
    public int getItemViewType(int position) {
        return listeMobiles.get(position) instanceof Arbre ? VIEWTYPE_ARBRE : VIEWTYPE_ENGRENAGE;
    }
}
