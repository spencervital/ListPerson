package com.example.liste_person;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Friends {
    List<Person>FriendsList;

    public Friends(List<Person> FriendsList) {
        this.FriendsList = FriendsList;
    }

    public Friends(){
        String[] startingNames = {"Daveau", "Beatrice", "Carl"};
        this.FriendsList = new ArrayList<>();

        Random rng = new Random();
        for (int i=0; i<startingNames.length; i++){
            Person p = new Person(startingNames[i],  rng.nextInt(50) + 15, rng.nextInt(30));
            FriendsList.add(p);
        }
    }

    public List<Person> getFriendsList() {
        return FriendsList;
    }

    public void setFriendsList(List<Person> friendsList) {
        FriendsList = friendsList;
    }
}
