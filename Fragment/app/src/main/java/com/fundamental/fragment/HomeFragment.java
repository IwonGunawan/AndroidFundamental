package com.fundamental.fragment;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = HomeFragment.class.getSimpleName();
    Button btnToCategory;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnToCategory = view.findViewById(R.id.btn_to_category);

        btnToCategory.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_to_category) {

            FragmentManager fragmentManager = getFragmentManager();
            CategoryFragment categoryFragment = new CategoryFragment();
            if (fragmentManager != null) {

                fragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_container, categoryFragment, CategoryFragment.class.getSimpleName())
                        .addToBackStack(null)
                        .commit();
            }
        }
    }
}
