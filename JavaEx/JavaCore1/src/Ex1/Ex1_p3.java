package Ex1;

import java.sql.Array;
import java.util.Arrays;

public class Ex1_p3 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        //bubbleSort(array);
        //System.out.println(Arrays.toString(array));
        //selectionSort(array);
        //System.out.println(Arrays.toString(array));
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }
    public static void bubbleSort(int [] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = i+1; j < arr.length; j++){
                if(arr[i] < arr[j]){

                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

    }
    public static void selectionSort(int[] arr){
        int maxIdx;
        for(int i = 0; i < arr.length; i++){
            maxIdx = i;
           for(int j = i+1; j < arr.length; j++){
               if(arr[j] > arr[i]){
                   maxIdx = j;
                   int temp = arr[maxIdx];
                   arr[maxIdx] = arr[i];
                   arr[i] = temp;
               }
           }
        }
    }
    public static void insertionSort(int[] arr){
        int i , j , key;
        for (i = 1 ; i < arr.length; i++){
            key = arr[i];
            j = i -1;
            while (j >=  0 && arr[j] < key){
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
    }
}
