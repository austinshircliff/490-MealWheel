package com.example.austin.mealwheel_490;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantSelectionList extends Fragment {


    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://mealwheel-5c43d.firebaseio.com/restaurants");
    DatabaseReference restReference = databaseReference.child("https://mealwheel-5c43d.firebaseio.com/restaurants");
    List<String> listofrest = new ArrayList<String>();
    ListView restaurantListView;
    ListAdapter restaurantListAdapter;

    public RestaurantSelectionList() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.restaurant_selection_list_frag, container, false);
        restaurantListView = (ListView) view.findViewById(R.id.restaurantListView);
        restaurantListAdapter = new FirebaseListAdapter<Restaurants>(getActivity(), Restaurants.class, R.layout.individual_restaurant_name, databaseReference) {
            @Override
            protected void populateView(View v, Restaurants model, int position) {
                TextView restaurantName = (TextView) v.findViewById(R.id.restname);
                restaurantName.setText(model.getRestaurant());

                listofrest.add(position, model.getRestaurant());
            }
        };
        restaurantListView.setAdapter(restaurantListAdapter);
        return view;
    }
}
