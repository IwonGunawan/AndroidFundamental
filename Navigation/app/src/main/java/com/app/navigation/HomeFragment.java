package com.app.navigation;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


//2. NavController
public class HomeFragment extends Fragment {

    Button btnToCategory, btnToProfile;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnToCategory = view.findViewById(R.id.btn_to_category);
        btnToProfile = view.findViewById(R.id.btn_to_profile);

        btnToCategory.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_categoryFragment));

        btnToProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_profileActivity);
            }
        });
    }
}
