package com.example.lockit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lockit.models.Charm;

import java.util.List;

public class CharmAdapter extends RecyclerView.Adapter<CharmAdapter.ViewHolder> {

    private Context context;
    private List<Charm> charmsList;

    public CharmAdapter(Context context, List<Charm> charms) {
        this.context = context;
        this.charmsList = charms;
    }

    // Creates one individual row in the recyclerView
    @NonNull
    @Override
    public CharmAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_charm, parent, false);
        return new ViewHolder(view);
    }

    // With the data at the given position, bind it to the holder
    @Override
    public void onBindViewHolder(@NonNull CharmAdapter.ViewHolder holder, int position) {
        Charm charm = charmsList.get(position);
        holder.bind(charm);
    }

    @Override
    public int getItemCount() {
        return charmsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tvOrgName;
        private TextView tvUsername;
        private ImageView ivOrgLogo;

        public ViewHolder(@NonNull View view) {
            super(view);

            tvOrgName = view.findViewById(R.id.tvOrgName);
            tvUsername = view.findViewById(R.id.tvUsername);
            ivOrgLogo = view.findViewById(R.id.ivOrgLogo);

            view.setOnClickListener((View.OnClickListener)this);
        }

        public void bind(Charm charm) {
            tvOrgName.setText(charm.getOrgName());
            tvUsername.setText(charm.getUserName());
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(context, "CLICKED!", Toast.LENGTH_SHORT).show();
            // should have option of viewing the password for the selected item
        }
    }
}