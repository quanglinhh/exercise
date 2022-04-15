package test1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var list = new ArrayList<>(List.of(3,10,4,34,19,7));
//        //Sắp xếp từ bé đến lớn
//        Collections.sort(list);
        //Đảo ngược
        Collections.reverse(list);
        System.out.println(list);
    }
}
