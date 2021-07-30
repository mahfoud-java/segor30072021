package com.tpjava2.homeactivity.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tpjava2.homeactivity.R;
import com.tpjava2.homeactivity.models.Portee;

import java.util.ArrayList;
import java.util.List;

public class AnnotationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Portee> annotations;
    int  compteur = 1;

    public AnnotationAdapter(List<Portee> annotations) {
        this.annotations = annotations;

    }

    static class AnnotationViewHolder extends RecyclerView.ViewHolder{

        EditText editTextNumeroPortee;
        EditText editTextNomPortee;
        EditText editTextTypePortee;
        EditText editTextDiametrePortee;

        LinearLayout layout;

        public AnnotationViewHolder(@NonNull View itemView) {
            super(itemView);
            editTextNumeroPortee = itemView.findViewById(R.id.editText_numero_portee);
            editTextNomPortee = itemView.findViewById(R.id.editText_nom_portee);

            editTextTypePortee = itemView.findViewById(R.id.editText_type_portee);
            editTextDiametrePortee = itemView.findViewById(R.id.editText_diametre_portee);
            layout = itemView.findViewById(R.id.layout_item);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler_annotation, parent, false);
        return new AnnotationViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

            AnnotationViewHolder annotationViewHolder = (AnnotationViewHolder) holder;

            annotationViewHolder.editTextNumeroPortee.setText(""+compteur++);


    }

    @Override
    public int getItemCount() {
        return annotations.size();
    }
}
