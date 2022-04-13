package collection.map;

import jdk.jshell.spi.SPIResolutionException;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void demoMap(){
        Map<Integer, String> persion = new HashMap<Integer, String>();
        persion.put(1,"Chi Pu");
        persion.put(2,"Ngoc Trinh");
        persion.put(3,"Ho Ngoc Ha");
        persion.put(4,"Loki Laufeyson");
        persion.put(5,"Tony Stark");

        System.out.println(persion);

        persion.put(4,"Peter Parker");

        persion.remove(2);
        System.out.println("After remove: "+ persion);

        for(Map.Entry<Integer,String> entry: persion.entrySet()){
            Integer key = entry.getKey();;
            String value = entry.getValue();
            System.out.println(key+"-"+value);
        }
    }
}
