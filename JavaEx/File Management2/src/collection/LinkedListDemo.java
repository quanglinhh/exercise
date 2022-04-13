package collection;
import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        //Add phan tu vao danh sach
        list.add("A");
        list.add("B");
        list.add("F");
        list.add("G");
        list.add("H");

        list.add("S");//Them pt cuoi cung vao mang
        list.add(1,"A2");
        list.addFirst("A1");//Them phan tu vao vi tri dau tien

        System.out.println("Original ALL LIST"+ list);

        //loai bo di mot phan tu trong danh sach theo ten
        list.remove("B");

        //Loai bo di mot phan tu theo vi tri
        list.remove(2);

        System.out.println("Content of List after deletion: " + list);

        //Loai bo theo dau va cuoi ban ghi
        list.removeFirst();
        list.removeLast();

        System.out.println("Content of list after delete first and last" +list);

        //Lay ra phan tu chi so 3
        Object list1 = list.get(3);

        //Thiet lap lai vi tri cua phan tu cos chi so 3
//        list.set(5,String.valueOf(list1)+"udated");
        list.set(1,(String) list1+" updated");

        System.out.println("List after update: "+list);

    }
}
