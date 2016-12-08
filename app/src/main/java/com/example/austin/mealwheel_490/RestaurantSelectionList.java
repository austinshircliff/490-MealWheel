package com.example.austin.mealwheel_490;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantSelectionList extends Fragment {

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mRestReference = mRootRef.child("restaurants");

    List<String>listofrest = new ArrayList<String>();
    ListView restaurantListView;
    ListAdapter restaurantListAdapter;


    public RestaurantSelectionList(){}

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.restaurant_selection_list_frag,container,false);
        restaurantListView = (ListView) view.findViewById(R.id.restaurantListView);
        restaurantListAdapter = new FirebaseListAdapter<Restaurants>(getActivity(),Restaurants.class,R.layout.individual_restaurant_name,mRestReference) {
            @Override
            protected void populateView(View v, Restaurants model, int position) {
                TextView restName = (TextView) v.findViewById(R.id.restname);
                restName.setText(model.getName());


                listofrest.add(position,model.getName());

            }
        };



        Collections.sort(listofrest);
        restaurantListView.setAdapter(restaurantListAdapter);

        restaurantListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(), "test", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

}
