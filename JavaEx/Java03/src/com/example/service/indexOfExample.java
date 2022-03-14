package com.example.service;

public class indexOfExample {
    public static void main(String[] args) {
        String str = "This is text demo Is is is";

        //Tim vi tri xuat hien cua ky tu
        int idx = str.indexOf('s');
        System.out.println("indexOf('s'):"+idx);

        idx = str.indexOf("is");
        System.out.println("indexOf('is'): " + idx);

        //Thay the voi replace
        String str2 = str.replace('I', 'A');
        System.out.println("Str2: "+ str2);
        String str3 = str.replace("is", "bs");
        System.out.println("Str3: "+ str3);

    }
}
