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
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class LifestyleFragment extends Fragment {

    TextView tvName, tvDesc;
    Button btnBack;


    public LifestyleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lifestyle, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /* use BUNDLE
        String dataName = getArguments().getString(CategoryFragment.EXTRA_NAME);
        long dataDesc = getArguments().getLong(CategoryFragment.EXTRA_DESC, 0);
         */

        String dataName = LifestyleFragmentArgs.fromBundle(getArguments()).getName();
        Long dataDesc = LifestyleFragmentArgs.fromBundle(getArguments()).getDesc();

        tvName = view.findViewById(R.id.tv_lifestyle_name);
        tvDesc = view.findViewById(R.id.tv_lifestyle_desc);
        btnBack = view.findViewById(R.id.btn_lifestyle_back);

        tvName.setText(dataName);
        tvDesc.setText(String.valueOf(dataDesc));

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_lifestyleFragment_to_homeFragment);
            }
        });
    }
}
