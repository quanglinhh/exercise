package Ex1;

import java.util.*;

public class Ex1_p2 {
    public static void main(String[] args) {
        List<Integer> A = new ArrayList<Integer>();
        List<Integer> B = new ArrayList<Integer>();
        nhapMang((ArrayList<Integer>) A,"nhất");
        nhapMang((ArrayList<Integer>) B,"hai");
        A.sort(Comparator.naturalOrder());
        B.sort(Comparator.reverseOrder());
        System.out.println("Mảng sau khi được săp xếp là");
        System.out.println(A);
        System.out.println(B);
        System.out.println(A + " " + B);


    }
    public static void merge(ArrayList<Integer> arr, int l,int m, int r ){
        int n1 = m - l+1;
        int n2 = r - m;

        ArrayList<Integer> tempL = new ArrayList<Integer>(n1);
        ArrayList<Integer> tempR = new ArrayList<Integer>(n2);

        for(int i = 0 ; i <= tempL.size()-1; i++){
            tempL.add(arr.get(l+i));
        }
        for(int i = 0 ; i <= tempL.size()-1; i++){
            tempR.add(arr.get(m+1+i));
        }

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2){
            if(tempL.get(i) <= tempR.get(j)){
                arr.get(k) = tempL.get(i);
            }
        }

        tempL.sort(Comparator.naturalOrder());
        tempR.sort(Comparator.reverseOrder());

        System.out.println(tempL + " " + tempR);
    }
    public static void sort(ArrayList<Integer> arr, int l, int r ){
        if(l<r){
            int m = (l+r)/2;
            sort( arr, l, m);
            sort( arr, m+1, r);
            merge(arr,l,m,r);
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
