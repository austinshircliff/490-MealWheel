package com.example.austin.mealwheel_490;


import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.austin.mealwheel_490.model.Restaurants;
import com.firebase.client.Firebase;
import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class DeleteChoiceListFragment extends Fragment {

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mRestReference = mRootRef.child("restaurants");

    List<String> listofrest = new ArrayList<String>();
    ListView restaurantListView;
    ListAdapter restaurantListAdapter;
    Firebase itemtoremove;


    public DeleteChoiceListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.restaurant_selection_list_frag, container, false);
        restaurantListView = (ListView) view.findViewById(R.id.restaurantListView);

        restaurantListAdapter = new FirebaseListAdapter<Restaurants>(getActivity(), Restaurants.class, R.layout.individual_restaurant_name_nocheckbox, mRestReference) {
            @Override
            protected void populateView(View v, Restaurants model, final int position) {
                TextView restName = (TextView) v.findViewById(R.id.restname);
                restName.setText(model.getName());

                listofrest.add(position, model.getName());
            }
        };

        restaurantListView.setAdapter(restaurantListAdapter);
        restaurantListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


            }
        });
        return view;

    }


}