package com.fundamental.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class DetailFragment extends Fragment implements View.OnClickListener {

    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_DESC = "extra_desc";

    TextView tvName, tvDescription;
    Button btnProfile, btnShowDialog;

    String description;

    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvName = view.findViewById(R.id.tv_name);
        tvDescription = view.findViewById(R.id.tv_description);
        btnProfile = view.findViewById(R.id.btn_profile);
        btnShowDialog = view.findViewById(R.id.btn_show_dialog);

        btnProfile.setOnClickListener(this);
        btnShowDialog.setOnClickListener(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String name = getArguments().getString(EXTRA_NAME); // use method "Bundle"

        tvName.setText(name);
        tvDescription.setText(getDescription()); // use methode "Getter and Setter"

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_profile) {
            Intent intent = new Intent(getActivity(), ProfileActivity.class);
            startActivity(intent);
        }
        else if (view.getId() == R.id.btn_show_dialog) {
            OptionDialogFragment optionDialogFragment = new OptionDialogFragment();

            FragmentManager fragmentManager = getChildFragmentManager();
            optionDialogFragment.show(fragmentManager, OptionDialogFragment.class.getSimpleName());

        }
    }


    public void setDescription(String value) {
        this.description = value;
    }

    public String getDescription() {
        return this.description;
    }

    OptionDialogFragment.OnOptionDialogListener optionDialogListener = new OptionDialogFragment.OnOptionDialogListener() {
        @Override
        public void onOptionChosen(String text) {
            Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
            tvName.setText(text);
        }
    };
}
