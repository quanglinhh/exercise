package HashMap;
import java.util.HashMap;

public class HashmapGetValue {
    public static  void main(String[] args) {
        //Create a HashMap
        HashMap<Integer, String> hmap = new HashMap<Integer, String>();

        //add element to HashMap
        hmap.put(1,"AA");
        hmap.put(2,"BB");
        hmap.put(3,"CC");
        hmap.put(4,"DD");

        //Getting values from HashMap
        String val = hmap.get(4);
        System.out.println("The value mapped to Key 4 is: "+val);

        /**
         * Here Hey "5" is not mapped to any value so this
         * operation returns null
         */
        String val12 = hmap.get(5);
        System.out.println("The value mapped Key 5 is: "+val12);

    }

}
