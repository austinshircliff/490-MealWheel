package com.example.austin.mealwheel_490.Navigation;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.austin.mealwheel_490.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NavigationFragment extends Fragment {


    public NavigationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.restaurant_selection_list_frag,container,false);
        return view;
    }

}
