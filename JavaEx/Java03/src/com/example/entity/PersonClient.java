package com.example.entity;

public class PersonClient {
    public static void main(String[] args) {
        //OOP: Tạo ra object , nhấc object ra khỏi class, đặt vào 1 class khác mà n vẫn chạy đc.
        Person p1 = new Person();
        Person t2108A1  = new Person("T2108A1 Fpt Aptech",2021);
        Person p2 = new Person("Fpt", 1989, "Hanoi");//du cac thuoc tinh
        p1.setName("Linh");

        System.out.println("Name of p2: "+p2.getName());
        System.out.println("Name of p1: "+p1.getName());

    }
}
