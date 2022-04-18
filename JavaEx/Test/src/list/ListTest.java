package list;

import java.util.ArrayList;

public class ListTest {
    public static void main(String[] args) {
        var list1 = new ArrayList<Integer>();
        var list2 = new ArrayList<Integer>();

        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);

        list2.add(10);
        list2.add(11);
        list2.add(12);
        list2.add(3);
        list1.addAll(list2);

//        list1.removeIf(integer -> integer %2 ==0);
//        System.out.println(list1);
//        list1.clear();
//        System.out.println(list1);

//        var iterate = list1.listIterator();
//
//        while (iterate.hasNext()){
//           System.out.println(iterate.next());
//        }
//        System.out.println(list1);

        var iterate1 = list1.spliterator();

//        iterate1.forEachRemaining(i->System.out.println(i));
        while (iterate1.tryAdvance(i->System.out.println(i)));

    }
}
