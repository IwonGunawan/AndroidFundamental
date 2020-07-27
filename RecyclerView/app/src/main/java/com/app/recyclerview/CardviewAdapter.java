package com.app.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardviewAdapter extends RecyclerView.Adapter<CardviewAdapter.CardviewHolder> {
    private ArrayList<Hero> listHero;
    private OnItemClickCallback onItemClickCallback;

    CardviewAdapter(ArrayList<Hero> list) {
        listHero = list;
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public CardviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_hero, parent, false);
        return new CardviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardviewHolder holder, int position) {
        Hero hero = listHero.get(position);

        Glide.with(holder.itemView.getContext())
                .load(hero.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgview);

        holder.tvName.setText(hero.getName());
        holder.tvDesc.setText(hero.getDescription());

        holder.btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(holder.itemView.getContext(), "btn favorite from adapter", Toast.LENGTH_SHORT).show();
            }
        });

        holder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked2(listHero.get(holder.getAdapterPosition()), "btn share from mainAct");
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(listHero.get(holder.getAdapterPosition()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return listHero.size();
    }

    public class CardviewHolder extends RecyclerView.ViewHolder {

        ImageView imgview;
        TextView tvName, tvDesc;
        Button btnFavorite, btnShare;

        public CardviewHolder(@NonNull View itemView) {
            super(itemView);

            imgview = itemView.findViewById(R.id.img_photo_cardview);
            tvName = itemView.findViewById(R.id.tv_name);
            tvDesc = itemView.findViewById(R.id.tv_description);
            btnFavorite = itemView.findViewById(R.id.btn_favorite);
            btnShare = itemView.findViewById(R.id.btn_share);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Hero data);
        void onItemClicked2(Hero data, String string);
    }
}
