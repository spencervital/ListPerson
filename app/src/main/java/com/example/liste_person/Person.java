package com.example.liste_person;


public class Person implements Comparable<Person> {

    private String nom;
    private int age;
    private int pictureNumber;

    public Person(String nom, int age, int pictureNumber) {
        this.nom = nom;
        this.age = age;
        this.pictureNumber = pictureNumber;
    }

    // CompareTo for sorting
    @Override
    public int compareTo(Person other) {
        return this.nom.compareTo(other.nom);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPictureNumber() {
        return pictureNumber;
    }

    public void setPictureNumber(int pictureNumber) {
        this.pictureNumber = pictureNumber;
    }


}
