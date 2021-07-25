package com.example.liste_person;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.security.identity.PersonalizationData;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    Button btn_adds, btn_abc, btn_123;

    ListView lv_friendslist;

    PersonAdapter adapter;

    Friends  myFriends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_123 = findViewById(R.id.btn_mix_123);
        btn_abc = findViewById(R.id.btn_mix_abc);
        btn_adds = findViewById(R.id.btn_add);
        lv_friendslist = findViewById(R.id.lv_listofnames);

        myFriends = new Friends();

        adapter = new PersonAdapter(MainActivity.this, myFriends);

        lv_friendslist.setAdapter(adapter);

        //listen for incoming messages
        Bundle incomingMessages = getIntent().getExtras();

        if (incomingMessages != null){
            //capture incoming data
            String nom = incomingMessages.getString("nom");
            int age = Integer.parseInt( incomingMessages.getString("age"));
            int photo = Integer.parseInt(incomingMessages.getString("photo"));
            int positionToEdit = incomingMessages.getInt("modifier");

            //create new persons object
            Person p = new Person(nom, age, photo);

            //add person to the list and update adapter
            if (positionToEdit > -1){
                myFriends.getFriendsList().remove(positionToEdit);
            }
            myFriends.getFriendsList().add(p);
            adapter.notifyDataSetChanged();

        }

        btn_adds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), NewPersonForm.class);
                startActivity(i);
            }
        });

        btn_123.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Collections.sort(myFriends.getFriendsList(), new Comparator<Person>() {
                @Override
                public int compare(Person p1, Person p2) {
                    return p1.getAge() - p2.getAge();
                }
            });

            adapter.notifyDataSetChanged();

            }
        });

        btn_abc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(myFriends.FriendsList);
                adapter.notifyDataSetChanged();

            }
        });

        lv_friendslist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             editPerson(position);
            }
        });
    }

    public void editPerson(int position){
        Intent i = new Intent(getApplicationContext(), NewPersonForm.class);

        //get the contents of person at position
        Person p = myFriends.getFriendsList().get(position);

        i.putExtra("nom", p.getNom());
        i.putExtra("age", p.getAge());
        i.putExtra("photo", p.getPictureNumber());
        i.putExtra("modifier", position);

        startActivity(i);

    }
}