package collection;

import java.util.HashMap;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String, Float> markStudent = new HashMap<String,Float>();
        markStudent.put("ST01",12.5f);
        markStudent.put("ST02",13.5f);
        markStudent.put("ST03",13.5f);
        markStudent.put("ST04",13.5f);
        markStudent.put("ST05",10.5f);
        markStudent.put("ST06",11.5f);
        markStudent.put("ST07",14.5f);
        markStudent.put("ST08",12.5f);

        Float mark = markStudent.get("ST05");
        System.out.println("Marks of student ST05: "+mark);

        //Sua thong tin cac phan tu
        markStudent.put("ST05",15f);
        System.out.println("Mark of student ST05 = "+ markStudent.get("ST05"));
    }

}

