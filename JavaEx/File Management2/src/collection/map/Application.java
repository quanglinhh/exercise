package collection.map;

import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        MapExample.demoMap();

        Employee employee1 = new Employee(1,"Ngo Phương Lan","lan@gmail.com","099999999");
        Employee employee2 = new Employee(2,"Doan Du","du@gmail.com","099999999");
        Employee employee3 = new Employee(3,"Truong Gia Binh","huy@gmail.com","099999999");
        Employee employee4 = new Employee(4,"Nguyen Phu Trong","trong@gmail.com","099999999");

        //Khoi tao map
        Map<Integer,Employee> map = new HashMap<Integer, Employee>();
        map.put(employee1.getId(),employee1);
        map.put(employee2.getId(),employee2);
        map.put(employee3.getId(),employee3);
        map.put(employee4.getId(),employee4);

        //Hien thi thong tin cua map su dung keySet()
        for(Integer key: map.keySet()){
            Employee values = map.get(key);
            System.out.println(key+" = "+ values);
        }
        System.out.println("==============================");
        for (Map.Entry<Integer, Employee> entry : map.entrySet()){
            Integer key = entry.getKey();
            Employee value = entry.getValue();
            System.out.println(key + " = "+value);
        }
    }
}
