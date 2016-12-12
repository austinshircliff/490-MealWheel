package com.example.austin.mealwheel_490;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.austin.mealwheel_490.model.Restaurants;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.content.Intent;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantSelectionList extends Fragment {

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mRestReference = mRootRef.child("restaurants");

    List<String>listofrest = new ArrayList<String>();
    ArrayList<String>selecteditems= new ArrayList<String>();
    ListView restaurantListView;
    FirebaseListAdapter restaurantListAdapter;
    ImageView checkmark;




    public RestaurantSelectionList(){}

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.restaurant_selection_list_frag,container,false);
        restaurantListView = (ListView) view.findViewById(R.id.restaurantListView);
        Button readytogoBtn = (Button) view.findViewById(R.id.readytospinbtn);

        restaurantListAdapter = new FirebaseListAdapter<Restaurants>(getActivity(),Restaurants.class,R.layout.individual_restaurant_name_main,mRestReference) {
            @Override
            protected void populateView(View v, Restaurants model, int position) {
                TextView restName = (TextView) v.findViewById(R.id.restname);

                restName.setText(model.getName());
                listofrest.add(position,model.getName());


            }
        };

        restaurantListView.setAdapter(restaurantListAdapter);



        restaurantListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (selecteditems.contains(((Restaurants) adapterView.getItemAtPosition(i)).getName()))  {
                    selecteditems.remove(((Restaurants) adapterView.getItemAtPosition(i)).getName());


                }
                else {

                    selecteditems.add(((Restaurants) adapterView.getItemAtPosition(i)).getName());

                }
            }
        });




        readytogoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(),SpinnerActivity.class);
                intent.putStringArrayListExtra("listofselecteditems",selecteditems);
                startActivity(intent);


            }
        });




        return view;



    }






}
