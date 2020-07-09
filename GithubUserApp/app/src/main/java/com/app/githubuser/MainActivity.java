package com.app.githubuser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private UsersAdapter usersAdapter;

    ListView lvList;
    private String[] dataUsername;
    private String[] dataName;
    private String[] dataLocation;
    private String[] dataRepository;
    private String[] dataCompany;
    private int[] dataFollowers;
    private int[] dataFollowing;
    private TypedArray dataAvatar;

    private ArrayList<Users> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvList = findViewById(R.id.lv_list);

        usersAdapter = new UsersAdapter(this);
        lvList.setAdapter(usersAdapter);

        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Users user = new Users();
                user.setUsername(dataUsername[i]);
                user.setName(dataName[i]);
                user.setLocation(dataLocation[i]);
                user.setRepository(dataRepository[i]);
                user.setCompany(dataCompany[i]);
                user.setFollowers(dataFollowers[i]);
                user.setFollowing(dataFollowing[i]);
                user.setAvatar(dataAvatar.getResourceId(i, -1));


                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(DetailActivity.USER, user);
                startActivity(intent);

            }
        });

        prepare();
        addItem();
    }

    public void prepare() {
        dataUsername    = getResources().getStringArray(R.array.username);
        dataName        = getResources().getStringArray(R.array.name);
        dataLocation    = getResources().getStringArray(R.array.location);
        dataRepository  = getResources().getStringArray(R.array.repository);
        dataCompany     = getResources().getStringArray(R.array.company);
        dataFollowers   = getResources().getIntArray(R.array.followers);
        dataFollowing   = getResources().getIntArray(R.array.following);
        dataAvatar = getResources().obtainTypedArray(R.array.avatar);
    }

    public void addItem() {
        if (dataName.length > 0) {
            users = new ArrayList<>();

            for (int i=0; i < dataName.length; i++) {
                Users user = new Users();
                user.setName(dataName[i]);
                user.setCompany(dataCompany[i]);
                user.setLocation(dataLocation[i]);
                user.setAvatar(dataAvatar.getResourceId(i, -1));

                users.add(user);
            }

            usersAdapter.setUsers(users);
        }
    }
}
