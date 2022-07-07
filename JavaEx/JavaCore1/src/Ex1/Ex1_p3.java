package Ex1;

import java.sql.Array;
import java.util.Arrays;

public class Ex1_p3 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        //bubbleSort(array);
        //selectionSort(array);
        //insertionSort(array);
        mergeSort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }
    //Cách1
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
    //Cách 2
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
    //Cách 3
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
    //Cach4
    public static void mergeSort(int[] arr, int l, int r){
        if(l<r){
            int m = (r+l)/2;
            mergeSort(arr,l,m);
            mergeSort(arr,m+1,r);
            merge(arr,l,m,r);
        }
    }
    public static void merge(int arr[], int l, int m, int r){
        int n1 = m - l +1;
        int n2 = r - m;

        int[] tempL = new int[n1];
        int[] tempR = new int[n2];

        for(int i = 0 ; i < n1; i++){
            tempL[i] = arr[i+l];
        }
        for(int j = 0 ; j < n2; j++){
            tempR[j] = arr[j+1+m];
        }

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2){
            if(tempL[i] > tempR[j]){
                arr[k] = tempL[i];
                i++;
            }else {
                arr[k] = tempR[j];
                j++;
            }
            k++;
        }
        while (i < n1){
            arr[k] = tempL[i];
            i++;
            k++;
        }
        while (j < n2){
            arr[k] = tempR[j];
            j++;
            k++;
        }
    }
}
