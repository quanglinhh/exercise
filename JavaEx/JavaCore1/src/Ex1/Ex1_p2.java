package Ex1;

import java.lang.reflect.Array;
import java.util.*;

public class Ex1_p2 {
    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        nhapMang((ArrayList<Integer>) A,"nhất");
        nhapMang((ArrayList<Integer>) B,"hai");
        /*
        A.sort(Comparator.naturalOrder());
        B.sort(Comparator.reverseOrder());
        System.out.println("Mảng sau khi được săp xếp là");
        System.out.println(A);
        System.out.println(B);
        System.out.println(A + " " + B);
         */
        //sortA((ArrayList<Integer>) A,0,A.size()-1);
        //Chuyển 2 arrayLít thành 2 mảng
        int[] arrA = new int[A.size()];
        int[] arrB = new int[B.size()];
        //Nhập vào giá trị 2 mảng
        for (int i = 0 ; i < B.size(); i++){
            arrB[i] = B.get(i);
        }for (int i = 0 ; i < A.size(); i++){
            arrA[i] = A.get(i);
        }
        //Sắp xếp
        sortB(arrB,0,B.size()-1);
        sortA(arrA,0,A.size()-1);
        //Gán lại giá trị 2 arrlayLít
        A.clear();
        B.clear();
        for(int i = 0; i < arrA.length; i++){
            A.add(arrA[i]);
        }
        for(int i = 0; i < arrB.length; i++){
            B.add(arrB[i]);
        }
        System.out.println("Mảng A sau khi được săp xếp là");
        System.out.println(A);
        System.out.println("Mảng B sau khi được săp xếp là");
        System.out.println(B);
        for(int i = 0; i < arrB.length; i++){
            A.add(arrB[i]);
        }
        System.out.println("Nối 2 mảng");
        System.out.println(A);
        /*In ra các phần từ mà A và B đều có (Viết phương thức intersection())*/
        HashSet<Integer> set = new HashSet<>();
       for(int val: arrA){
           set.add(val);
       }
        System.out.println("Các phần tử trùng nhau: ");
       for(int val : arrB){
           if(set.contains(val)){
               System.out.print(val+", ");
           }
       }
    }
    public static void mergeA(int[] arr, int l,int m, int r ){
        int n1 = m - l+1;
        int n2 = r - m;
        //Chuyen arrayList sang array

        int[] tempL = new int[n1];
        int[] tempR = new int[n2];
        for(int i = 0 ; i <= tempL.length-1; i++){
            tempL[i] = arr[l+i];
        }
        for(int i = 0 ; i <= tempL.length-1; i++){
            tempR[i] = arr[m+1+i];
        }
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2){
            if(tempL[i] <= tempR[j]){
                arr[k] = tempL[i];
                i++;
            }
            else{
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
    public static void mergeB(int[] arr, int l,int m, int r ){
        int n1 = m - l+1;
        int n2 = r - m;


        ///
        int[] tempL = new int[n1];
        int[] tempR = new int[n2];
        //Add gia tri vao 2 bang
        for(int i = 0; i < n1; i++){
            tempL[i] = arr[l+i];
        }
        for(int i = 0; i < n2; i++){
            tempR[i] = arr[m+1+i];
        }
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2){
            if(tempL[i] >= tempR[j]){
                arr[k] = tempL[i];
                i++;
            }else {
                arr[k] = tempR[j];
                j++;
            }
            k++;
        }
        while(i < n1){
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

    public static void sortA(int[] arr, int l, int r){
        if(l<r){
            int m = (l+r)/2;
            sortA( arr, l, m);
            sortA( arr, m+1, r);
            mergeA(arr,l,m,r);

        }
    }
    public static void sortB(int[] arr, int l, int r){
        if(l<r){
            int m = (l+r)/2;
            sortB( arr, l, m);
            sortB( arr, m+1, r);
            mergeB(arr,l,m,r);

        }
    }
    public static void nhapMang(ArrayList<Integer> arr,String a){
        Scanner scanner = new Scanner(System.in);
        String continues = "y";
        while (continues.equals("y")||continues.equals("Y") ){
            System.out.println("Nhập vào bàn phím danh sách mảng thứ "+a);
            int element = scanner.nextInt();
            arr.add(element);
            System.out.println("Continues?(Y/N)");
            scanner.nextLine();
            continues = scanner.nextLine();
        }
        System.out.println(arr);
    }

}
