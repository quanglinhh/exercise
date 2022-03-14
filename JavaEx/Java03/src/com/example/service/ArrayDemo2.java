package com.example.service;

import java.util.Arrays;
import java.util.List;
public class ArrayDemo2 {
    public static void main(String[] args) {
        int[] classes = new int[]{2110,2108,2109,2111};

        //sort sap xep
        //Array la 1 class
        Arrays.sort(classes);

        for(int class1:classes){
            System.out.println("Class ar FPT T"+class1+"A1");
        }
        //Convert to string
        String classString = Arrays.toString(classes);
        System.out.println("Class"+classString);

        //Tạo List:Collection
        List<String> names = Arrays.asList(classString);
        for (String className:names){
            System.out.println("Name of class: "+className);
        }
    }
}
