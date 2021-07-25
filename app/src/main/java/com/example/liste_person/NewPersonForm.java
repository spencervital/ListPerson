package com.example.liste_person;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewPersonForm extends AppCompatActivity {

    Button btn_valide, btn_cancel;
    EditText etname, etage,etpicture;

    int positionToEdit = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_person_form);

        btn_valide = findViewById(R.id.btn_valide);
        etname = findViewById(R.id.Et_name);
        etage = findViewById(R.id.Et_age);
        etpicture = findViewById(R.id.Et_picture);

        //listen for incoming messages
        Bundle incomingMessages = getIntent().getExtras();

        if (incomingMessages != null) {
            //capture incoming data
            String nom = incomingMessages.getString("nom");
            int age = Integer.parseInt(incomingMessages.getString("age"));
            int photo = Integer.parseInt(incomingMessages.getString("photo"));
            positionToEdit = incomingMessages.getInt("modifier");

            //fill in the form
            etname.setText(nom);
            etage.setText(Integer.toString(age));
            etpicture.setText(Integer.toString(photo));

        }

        btn_valide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //get string from et view objects
                String newName = etname.getText().toString();
                String newAge = etage.getText().toString();
                String newPicture = etpicture.getText().toString();

                // put the strings into a message for MainActivity

                //start MainActivity again


                Intent i = new Intent(v.getContext(), MainActivity.class);

                i.putExtra("modifier", positionToEdit);
                i.putExtra("nom", newName);
                i.putExtra("age", newAge);
                i.putExtra("photo", newPicture);
                startActivity(i);
            }
        });
    }
}