package com.fundamental.fragment;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class OptionDialogFragment extends DialogFragment implements View.OnClickListener {


    RadioGroup rgCoach;
    RadioButton rbCA, rbJM, rbJG, rbBP, rbAF;
    Button btnClose, btnChoose;

    OnOptionDialogListener optionDialogListener;


    public OptionDialogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_option_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rgCoach = view.findViewById(R.id.rg_coach);
        rbCA = view.findViewById(R.id.rb_ca);
        rbJM = view.findViewById(R.id.rb_jm);
        rbJG = view.findViewById(R.id.rb_jg);
        rbBP = view.findViewById(R.id.rb_bp);
        rbAF = view.findViewById(R.id.rb_af);
        btnClose = view.findViewById(R.id.btn_close);
        btnChoose = view.findViewById(R.id.btn_choose);

        btnClose.setOnClickListener(this);
        btnChoose.setOnClickListener(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Fragment fragment = getParentFragment();
        DetailFragment detailFragment = (DetailFragment) fragment;
        this.optionDialogListener = detailFragment.optionDialogListener;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.optionDialogListener = null;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_close:
                getDialog().cancel();
                break;

            case R.id.btn_choose:
                int rgCoachID = rgCoach.getCheckedRadioButtonId();
                if (rgCoachID > -1) {

                    String coach = "";
                    switch (rgCoachID) {
                        case R.id.rb_ca:
                            coach = rbCA.getText().toString().trim();
                            break;
                        case R.id.rb_jm:
                            coach = rbJM.getText().toString().trim();
                            break;
                        case R.id.rb_jg:
                            coach = rbJG.getText().toString().trim();
                            break;
                        case R.id.rb_bp:
                            coach = rbBP.getText().toString().trim();
                            break;
                        case R.id.rb_af:
                            coach = rbAF.getText().toString().trim();
                            break;
                    }

                    if (optionDialogListener != null) {
                        optionDialogListener.onOptionChosen(coach);
                    }
                    getDialog().dismiss();
                }

                break;
        }
    }

    public interface OnOptionDialogListener {
        void onOptionChosen(String text);
    }
}
