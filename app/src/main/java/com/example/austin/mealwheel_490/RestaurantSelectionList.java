package com.example.austin.mealwheel_490;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.austin.mealwheel_490.model.Restaurants;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantSelectionList extends Fragment {

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mRestReference = mRootRef.child("restaurants");

    List<String>listofrest = new ArrayList<String>();
    ListView restaurantListView;
    FirebaseListAdapter restaurantListAdapter;
    Button readytogoBtn;
    TextView option1;
    TextView option2;
    TextView option3;
    TextView option4;
    TextView option5;
    TextView option6;
    CheckBox isSelected;





    public RestaurantSelectionList(){}

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.restaurant_selection_list_frag,container,false);
        restaurantListView = (ListView) view.findViewById(R.id.restaurantListView);
        readytogoBtn = (Button) view.findViewById(R.id.readytospinbtn);
        isSelected = (CheckBox) view.findViewById(R.id.checkbox);

        restaurantListAdapter = new FirebaseListAdapter<Restaurants>(getActivity(),Restaurants.class,R.layout.individual_restaurant_name_checkbox,mRestReference) {
            @Override
            protected void populateView(View v, Restaurants model, int position) {
                TextView restName = (TextView) v.findViewById(R.id.restname);
                restName.setText(model.getName());
                listofrest.add(position,model.getName());



            }
        };

        restaurantListView.setAdapter(restaurantListAdapter);
        restaurantListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        restaurantListView.setItemsCanFocus(false);
        return view;



    }

}
