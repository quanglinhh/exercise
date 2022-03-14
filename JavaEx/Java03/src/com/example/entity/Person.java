package com.example.entity;

public class Person {
    //Firelds ake property: ĐN đối tượng
    private String name;
    private int year;
    private String place;
    //Constructor
    public Person(){

    }
    public Person(String name){
        this.name = name;//This là đối tượng hiện tại trong lớp person

    }
    public Person(String name, int year){
        this.name = name;
        this.year = year;
    }
    public Person(String name, int year, String place){
        this.name = name;
        this.year = year;
        this.place = place;
    }
    //getter
    public String getName(){
        return name;
    }
    public int getYear(){
        return year;
    }
    public String getPlace(){
        return place;
    }
    //setter
    public void setName(String name){
        this.name = name;
    }
    public void setYear(int year){
        this.year =year;
    }
    public void setPlace(String place){
        this.place = place;
    }

}


