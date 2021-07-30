package com.tpjava2.homeactivity.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tpjava2.homeactivity.R;
import com.tpjava2.homeactivity.controller.ConnexionLocalController;
import com.tpjava2.homeactivity.dao.BddLocale;
import com.tpjava2.homeactivity.models.Accessoire;

import java.util.List;

public class ListeAccessoiresAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Accessoire> listeAccessoires;
    private Context context;

    public ListeAccessoiresAdapter(List<Accessoire> listeAccessoires,Context context) {
        this.listeAccessoires = listeAccessoires;
        this.context = context;
    }

    static class AccessoiresViewHolder extends RecyclerView.ViewHolder{
        private TextView textViewAccessoire;
        private ImageButton imageButtonRetirer;

        public AccessoiresViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewAccessoire = itemView.findViewById(R.id.textView_nom_accessoire);
            imageButtonRetirer = itemView.findViewById(R.id.imageButton_retirer_accessoire);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_accessoires, parent,false);
        return new AccessoiresViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Accessoire accessoire = listeAccessoires.get(position);
        AccessoiresViewHolder accessoiresViewHolder = (AccessoiresViewHolder) holder;
        accessoiresViewHolder.textViewAccessoire.setText(accessoire.getNom_accessoire() );

        accessoiresViewHolder.imageButtonRetirer.setOnClickListener(v -> {

            BddLocale bddLocale = ConnexionLocalController.getInstance(context);
            Integer id = listeAccessoires.get(position).getId();
            bddLocale.deleteAccessoire( id);
            bddLocale.close();
            listeAccessoires.remove(position);
            notifyDataSetChanged();
        });
//        accessoiresViewHolder.imageButtonEditer.setOnClickListener(v->{
//            Dialog dialog = new Dialog(context);
//            dialog.setContentView(R.layout.alerte_editer_accessoires);
//
//            DisplayMetrics metrics = new DisplayMetrics();
//            WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
//            wm.getDefaultDisplay().getMetrics(metrics);
//            dialog.getWindow().setLayout(metrics.widthPixels, metrics.heightPixels*9/10);
//
//            EditText editTextType = dialog.findViewById(R.id.editText_type_accessoire);
//            EditText editTextMarque = dialog.findViewById(R.id.editText_marque_accessoire);
//            EditText editTextCaracteristique = dialog.findViewById(R.id.editText_caracteristique_accessoire);
//            EditText editTextAutreCaracteristique = dialog.findViewById(R.id.editText_autre_caracteristique_accessoire);
//            RadioGroup radioGroupHoraire = dialog.findViewById(R.id.radioGroup_horaire);
//            RadioGroup radioGroupEtatAccessoire = dialog.findViewById(R.id.radioGroup_etat_accessoire);
//          //  TextView textViewCommentaire = dialog.findViewById(R.id.textView_etat_accessoire);
//            EditText editTextCommentaire = dialog.findViewById(R.id.editText_cause_etat_accessoire);
//            Button buttonAjouterInfos = dialog.findViewById(R.id.button_ajouter_info_accessoire);
//
//            if(accessoire.getNom_accessoire().contains("ANTI DERIVEUR")){
//                radioGroupHoraire.setVisibility(View.VISIBLE);
//                radioGroupHoraire.setOnCheckedChangeListener((radio,id) ->{
//                    switch (id) {
//                        case R.id.radioButton_horaire:
//                            accessoire.setNom_accessoire("ANTI DERIVEUR (sens : HORAIRE)");
//                            break;
//                        case R.id.radioButton_antihoraire:
//                            accessoire.setNom_accessoire("ANTI DERIVEUR (sens : ANTI HORAIRE)");
//                            break;
//                    }});
//            }else{
//                radioGroupHoraire.setVisibility(View.INVISIBLE);
//            }
//
//
//
//
//            radioGroupEtatAccessoire.setOnCheckedChangeListener((group, checkedId) -> {
//
//                switch (checkedId){
//
//                    case R.id.radioButton_ok:
//                        accessoire.getEtat().setDesignation("OK");
//                        accessoire.getEtat().setId(1);
//                        break;
//
//                    case R.id.radioButton_hs:
//                        accessoire.getEtat().setDesignation("HS");
//                        accessoire.getEtat().setId(2);
//                        break;
//
//                    case R.id.radioButton_reparer:
//                        accessoire.getEtat().setDesignation("A REPARER");
//                        accessoire.getEtat().setId(3);
//                        break;
//                }
//            });
//            buttonAjouterInfos.setOnClickListener(v1 -> {
//                accessoire.setMarque(editTextMarque.getText().toString());
//                accessoire.setType(editTextType.getText().toString());
//                accessoire.setCaracteristique(editTextCaracteristique.getText().toString());
//                accessoire.setAutreCaracteristique(editTextAutreCaracteristique.getText().toString());
//                accessoire.setCommentaire(editTextCommentaire.getText().toString());
//
//                notifyDataSetChanged();
//                dialog.dismiss();
//            });
//                    dialog.show();
//        });

    }


    @Override
    public int getItemCount() {
        return listeAccessoires.size();
    }
}
