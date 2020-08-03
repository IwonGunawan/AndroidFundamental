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


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {

    Button btnLifestyle;
    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_DESC = "extra_desc";


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

        btnLifestyle = view.findViewById(R.id.btn_category_lifestyle);
        btnLifestyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* send data with : Bundle
                Bundle bundle = new Bundle();
                bundle.putString(EXTRA_NAME, "this value name from bundle");
                bundle.putLong(EXTRA_DESC, 10);

                Navigation.findNavController(view).navigate(R.id.action_categoryFragment_to_lifestyleFragment, bundle);
                 */

                CategoryFragmentDirections.ActionCategoryFragmentToLifestyleFragment toLifestyleFragment = CategoryFragmentDirections.actionCategoryFragmentToLifestyleFragment();
                toLifestyleFragment.setName("this value name from safeargs");
                toLifestyleFragment.setDesc(7);
                Navigation.findNavController(view).navigate(toLifestyleFragment);
            }
        });
    }
}
