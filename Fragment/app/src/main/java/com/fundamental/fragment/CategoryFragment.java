package com.fundamental.fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment implements View.OnClickListener {


    Button btnToDetail;

    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnToDetail = view.findViewById(R.id.btn_to_detail);
        btnToDetail.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_to_detail) {
            FragmentManager fragmentManager = getFragmentManager();
            DetailFragment detailFragment = new DetailFragment();

            //1. cara kirim data menggunakan "Bundle"
            Bundle bundle = new Bundle();
            bundle.putString(DetailFragment.EXTRA_NAME, "Category name");
            detailFragment.setArguments(bundle);

            //2. cara kirim data menggunakan "Getter Setter"
            detailFragment.setDescription("this is description category from category");

            if (fragmentManager != null) {
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_container, detailFragment, DetailFragment.class.getSimpleName())
                        .addToBackStack(null)
                        .commit();
            }


        }
    }
}
