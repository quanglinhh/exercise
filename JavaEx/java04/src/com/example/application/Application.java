package com.example.application;

public class Application {
    public static void main(String[] args) {
        //Mang gom 2 hang, 3 cot
        int[][] intArray = new int[2][3];
        for(int row = 0; row < 2;row++){
            for(int col = 0;col < 3; col ++){
                System.out.println("intArray["+row+","+col+"]= "+intArray[row][col]);
            }
        }
    }
}
