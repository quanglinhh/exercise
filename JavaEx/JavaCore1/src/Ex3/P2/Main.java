package Ex3.P2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer,String> tinh = new HashMap<>();
        tinh.put(49,"Thành phố Hồ Chí Minh");
        tinh.put(2,"Đà Nẵng");
        tinh.put(11,"Cà Mau");
        tinh.put(22,"Nha Trang");
        tinh.put(100,"Hà Nội");

        System.out.println(tinh);
        System.out.println("----- Sau khi sắp xếp -----");
        TreeMap<Integer, String> sorted = new TreeMap<>(tinh);
        Set<Map.Entry<Integer, String>> mappings = sorted.entrySet();
        for (Map.Entry<Integer, String> mapping : mappings) {
            System.out.print( mapping.getValue()+", ");
        }
        System.out.println("\n-------------------------------");
        mappings.removeIf(mapping->mapping.getKey()%2!=0);
        for (Map.Entry<Integer, String> mapping : mappings){
            System.out.print( mapping.getValue()+", ");
        }
    }
}
