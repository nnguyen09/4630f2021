package com.example.localhangout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class FindYourGroup extends AppCompatActivity {
    private ImageView imgOfGroup;
    private String selectedState, selectedCity;
    private Spinner stateSpinner, citySpinner, interestSpinner;
    private ArrayAdapter<CharSequence> stateAdapter , cityAdapter, interestAdapter;
    private Button chatButton, logoutButton;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_your_group);

        imgOfGroup = findViewById(R.id.imgGroupHangout);
        imgOfGroup.setImageResource(R.drawable.img_group_2);

        // spinner initialization
        stateSpinner = findViewById(R.id.spinnerState);
        stateAdapter = ArrayAdapter.createFromResource(this, R.array.array_us_states, R.layout.spinner_layout);

        //specified the layout to use when the list of choices appear
        stateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //set adapter to spinner to populate state
        stateSpinner.setAdapter(stateAdapter);

        //when  any item of the state is selected
        stateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //define city spinner but we will populate the options through the selected state
                citySpinner = findViewById(R.id.spinnerCity);

                //obtain the selected state
                selectedState = stateSpinner.getSelectedItem().toString();

                int parentID = adapterView.getId();

                if(parentID == R.id.spinnerState){
                    switch(selectedState){
                        case "Select your state": cityAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_state_city, R.layout.spinner_layout);
                        break;

                        case "Alabama": cityAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_alabama_city, R.layout.spinner_layout);
                        break;

                        case "Alaska": cityAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_alaska_city, R.layout.spinner_layout);
                        break;

                        case "Arizona": cityAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_arizona_city, R.layout.spinner_layout);
                        break;

                        case "Arkansas": cityAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_arkansas_city, R.layout.spinner_layout);
                            break;

                        case "California": cityAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_california_city, R.layout.spinner_layout);
                            break;
                        case "Colorado": cityAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_colorado_city, R.layout.spinner_layout);
                            break;
                        case "Connecticut": cityAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_connecticut_city, R.layout.spinner_layout);
                            break;
                        case "Delaware": cityAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_delaware_city, R.layout.spinner_layout);
                            break;
                        case "Florida": cityAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_florida_city, R.layout.spinner_layout);
                            break;
                        case "Georgia": cityAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_georgia_city, R.layout.spinner_layout);
                            break;
                        case "Hawaii": cityAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_hawaii_city, R.layout.spinner_layout);
                            break;
                        case "Idaho": cityAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_idaho_city, R.layout.spinner_layout);
                            break;
                        case "Illinois": cityAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_illinois_city, R.layout.spinner_layout);
                            break;
                        case "Indiana": cityAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_indiana_city, R.layout.spinner_layout);
                            break;
                        case "Iowa": cityAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_iowa_city, R.layout.spinner_layout);
                            break;
                        case "Kansas": cityAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_kansas_city, R.layout.spinner_layout);
                            break;
                        case "Kentucky": cityAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_kentucky_city, R.layout.spinner_layout);
                            break;
                        case "Louisiana": cityAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_louisiana_city, R.layout.spinner_layout);
                            break;
                        case "Maine": cityAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_maine_city, R.layout.spinner_layout);
                            break;
                        case "Maryland": cityAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_maryland_city, R.layout.spinner_layout);
                            break;
                        case "Massachusetts": cityAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_massachusetts_city, R.layout.spinner_layout);
                            break;
                        case "Michigan": cityAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_michigan_city, R.layout.spinner_layout);
                            break;
                        case "Minnesota": cityAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_minnesota_city, R.layout.spinner_layout);
                            break;
                        case "Mississippi": cityAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_mississippi_city, R.layout.spinner_layout);
                            break;
                        case "Missouri": cityAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_missouri_city, R.layout.spinner_layout);
                            break;
                        case "Montana": cityAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_montana_city, R.layout.spinner_layout);
                            break;
                        case "Nebraska": cityAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_nebraska_ciry, R.layout.spinner_layout);
                            break;
                        case "Nevada": cityAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_nevada_city, R.layout.spinner_layout);
                            break;
                        case "New Hampshire": cityAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_newhampshire_city, R.layout.spinner_layout);
                            break;
                        case "New Jersey": cityAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_newjersey_city, R.layout.spinner_layout);
                            break;
                        case "New Mexico": cityAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_newmexico_city, R.layout.spinner_layout);
                            break;
                        case "New York": cityAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_newyork_city, R.layout.spinner_layout);
                            break;
                        case "North Carolina": cityAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_northcarolina_city, R.layout.spinner_layout);
                            break;
                        case "North Dakota": cityAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_northdakota_city, R.layout.spinner_layout);
                            break;
                        case "Ohio": cityAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_ohio_city, R.layout.spinner_layout);
                            break;
                        case "Oklahoma": cityAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_oklahoma_city, R.layout.spinner_layout);
                            break;
                        case "Oregon": cityAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_oregon_city, R.layout.spinner_layout);
                            break;
                        case "Pennsylvania": cityAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_pennsylvania_city, R.layout.spinner_layout);
                            break;
                        case "Rode Island": cityAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_rodeisland_city, R.layout.spinner_layout);
                            break;
                        case "South Dakota": cityAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_southdakota_city, R.layout.spinner_layout);
                            break;
                        case "Tennessee": cityAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_tennessee_city, R.layout.spinner_layout);
                            break;
                        case "Texas": cityAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_texas_city, R.layout.spinner_layout);
                            break;
                        case "Utah": cityAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_utah_city, R.layout.spinner_layout);
                            break;
                        case "Vermont": cityAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_vermont_city, R.layout.spinner_layout);
                            break;
                        case "Virginia": cityAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_virginia_city, R.layout.spinner_layout);
                            break;
                        case "Washington": cityAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_washington_city, R.layout.spinner_layout);
                            break;
                        case "West Virginia": cityAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_westvirginia_city, R.layout.spinner_layout);
                            break;
                        case "Wisconsin": cityAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_wisconsin_city, R.layout.spinner_layout);
                            break;
                        case "Wyoming": cityAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_wyoming_city, R.layout.spinner_layout);
                            break;

                        default:break;
                    }
                    cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                    //populate city according to the selected state
                    citySpinner.setAdapter(cityAdapter);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //interest spinner
        whatYourInterest();

        //chatButton
        letChat();
        logout();

    }
    private void logout(){

        firebaseAuth = FirebaseAuth.getInstance();
        logoutButton = findViewById(R.id.btnLogout);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(FindYourGroup.this, MainActivity.class));
            }
        });
    }

    private void letChat(){
        chatButton = findViewById(R.id.btnChat);
        chatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FindYourGroup.this, "Let's Chat selected", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(FindYourGroup.this, GroupChat.class));

            }
        });
    }

    private void whatYourInterest(){
        //interest spinner initilization
        interestSpinner = findViewById(R.id.spinnerInterest);
        interestAdapter = ArrayAdapter.createFromResource(this,R.array.array_list_of_interest, R.layout.spinner_layout);
        
        //specified layout 
        interestAdapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        interestSpinner.setAdapter(interestAdapter);
        interestSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String interest_selected = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(FindYourGroup.this, interest_selected + " selected", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        
    }
}