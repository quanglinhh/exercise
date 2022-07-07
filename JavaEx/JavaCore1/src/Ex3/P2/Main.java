package Ex3.P2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer,String> tinh = new HashMap<>();
        tinh.put(49,"Thành phố Hồ Chí Minh");
        tinh.put(02,"Đà Nẵng");
        tinh.put(11,"Cà Mau");
        tinh.put(22,"Nha Trang");
        tinh.put(100,"Hà Nội");

        System.out.println(tinh);
        System.out.println("----- Sau khi sắp xếp -----");
        TreeMap<Integer, String> sorted = new TreeMap<Integer, String>(tinh);
        Set<Map.Entry<Integer, String>> mappings = sorted.entrySet();
        for (Map.Entry<Integer, String> mapping : mappings) {
            System.out.print( mapping.getValue()+", ");
        }
    }
}
