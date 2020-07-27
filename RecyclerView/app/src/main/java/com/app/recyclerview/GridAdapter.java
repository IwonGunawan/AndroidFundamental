package com.app.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.GridViewHolder> {
    private ArrayList<Hero> gridHero = new ArrayList<>();

    GridAdapter(ArrayList<Hero> list) {
        gridHero = list;
    }


    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_hero,parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext())
                .load(gridHero.get(position).getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgView);
    }

    @Override
    public int getItemCount() {
        return gridHero.size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgView;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);

            imgView = itemView.findViewById(R.id.img_photo_grid);
        }
    }
}
