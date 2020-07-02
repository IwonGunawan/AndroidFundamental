package com.fundamental.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HeroAdapter extends BaseAdapter {
    private final Context context;
    private ArrayList<Hero> heroes = new ArrayList<>();


    public HeroAdapter(Context context) {
        this.context = context;
    }

    public void setHeroes(ArrayList<Hero> heroes) {
        this.heroes = heroes;
    }

    @Override
    public int getCount() {
        return heroes.size();
    }

    @Override
    public Object getItem(int i) {
        return heroes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemview = view;
        if (itemview == null) {
            itemview = LayoutInflater.from(context).inflate(R.layout.item_hero, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(itemview);

        Hero hero = (Hero) getItem(i); 
        viewHolder.bind(hero);


        return itemview;
    }

    private class ViewHolder {
        private TextView tvName, tvDescription;
        private ImageView imgPhoto;

        public ViewHolder(View view) {

            tvName = view.findViewById(R.id.tv_name);
            tvDescription = view.findViewById(R.id.tv_description);
            imgPhoto = view.findViewById(R.id.img_fhoto);

        }

        void bind(Hero hero){
            tvName.setText(hero.getName());
            tvDescription.setText(hero.getDescription());
            imgPhoto.setImageResource(hero.getphoto());
        }
    }
}
