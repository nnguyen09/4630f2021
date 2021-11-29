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

//                        case "Arizona": cityAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
//                                R.array.array_arizona_city, R.layout.spinner_layout);
//                        break;

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
                Toast.makeText(FindYourGroup.this, "Let's Chat selected. Removing this and add chat room soon", Toast.LENGTH_SHORT).show();
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