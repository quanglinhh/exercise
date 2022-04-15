package test1;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class HasMap {
    public static void main(String[] args) {
        var hasmap = new LinkedHashMap<Integer,Integer>();

        hasmap.put(1,355);
        hasmap.put(22,422);
        hasmap.put(12,500);
        hasmap.put(10,663);
        hasmap.put(17,823);

        System.out.println(hasmap);

//        /*Compute*/
//        hasmap.compute(1,(key,v)-> key *100);
//        System.out.println(hasmap);
//
//        /*Merge*/
//        /*If the key doesn't exist =>Create a new element*/
//        hasmap.merge(22, 211, (oldValue,newValue)->oldValue+newValue);
//        System.out.println(hasmap);
//
//        /*ContainKey/value*/
//        var result = hasmap.containsKey(22);
//        var result2 = hasmap.containsValue(500);
//        System.out.println(result2);
//        /*Clear*/
//        hasmap.clear();
//        /*isEmty*/
//        System.out.println(hasmap.isEmpty());
}


}
