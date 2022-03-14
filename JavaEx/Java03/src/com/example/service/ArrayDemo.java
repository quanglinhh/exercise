package com.example.service;

public class ArrayDemo {
    public static void main(String[] args) {
        int[] myArray = new int[10];
        String[] student = new String[]{"Nam","Thao","Linh","Mai"};

        for(int index=0;index < myArray.length; index++){
            System.out.println(index);
        }

        //for-each" lặp trong 1 tập hợn
        for (String name: student){
            System.out.println(name);
        }
    }
}
