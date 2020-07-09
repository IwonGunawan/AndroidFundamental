package com.app.githubuser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailActivity extends AppCompatActivity {

    public static final String USER = "user";

    TextView tvUsername, tvName, tvLocation, tvRepository, tvCompany, tvFollower, tvFollowing;
    CircleImageView imgAvatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        tvUsername = findViewById(R.id.tv_username);
        tvName = findViewById(R.id.tv_name);
        tvLocation = findViewById(R.id.tv_location);
        tvRepository = findViewById(R.id.tv_repository);
        tvCompany = findViewById(R.id.tv_company);
        tvFollower = findViewById(R.id.tv_follower);
        tvFollowing = findViewById(R.id.tv_following);
        imgAvatar = findViewById(R.id.img_avatar);


        Users user = getIntent().getParcelableExtra(USER);
        tvUsername.setText(user.getUsername());
        tvName.setText(user.getName());
        tvLocation.setText("Location: " + user.getLocation());
        tvRepository.setText("Total Repo: " + user.getRepository());
        tvCompany.setText("Company: " + user.getCompany());
        tvFollower.setText("Follower: " + user.getFollowers());
        tvFollowing.setText("Following: " + user.getFollowing());
        imgAvatar.setImageResource(user.getAvatar());



    }
}
