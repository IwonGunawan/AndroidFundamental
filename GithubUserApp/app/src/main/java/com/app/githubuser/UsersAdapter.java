package com.app.githubuser;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class UsersAdapter extends BaseAdapter {

    private final Context context;
    private ArrayList<Users> users = new ArrayList<>();

    public UsersAdapter(Context context) {
        this.context = context;
    }

    public void setUsers(ArrayList<Users> users) {
        this.users = users;
    }





    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int i) {
        return users.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemview = view;
        if (itemview == null) {
            itemview = LayoutInflater.from(context).inflate(R.layout.item_user, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(itemview);

        Users users = (Users) getItem(i);
        viewHolder.bind(users);


        return itemview;
    }

    private class ViewHolder {
        private TextView tvName, tvCompany, tvLocation;
        private CircleImageView imgAvatar;

        public ViewHolder(View view) {
            tvName = view.findViewById(R.id.tv_name);
            tvCompany = view.findViewById(R.id.tv_company);
            tvLocation = view.findViewById(R.id.tv_location);
            imgAvatar = view.findViewById(R.id.img_avatar);
        }

        void bind(Users users){
            tvName.setText(users.getName());
            tvCompany.setText(users.getCompany());
            tvLocation.setText(users.getLocation());
            imgAvatar.setImageResource(users.getAvatar());
        }
    }
}
