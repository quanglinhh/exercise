package collectiondemo.queue;

import java.util.PriorityQueue;
//PriorityQueue la hang dong khong rang buoc
//Thứ tự sắp xếp theo thứ tự tự nhiên
public class PriorityQeueExample {
    public static void demoPriorityQueue(){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        //Add elements
        //Them vao cuoi danh sach(mac dinh)
        priorityQueue.add(40);
        priorityQueue.add(60);
        priorityQueue.add(10);
        priorityQueue.add(15);
        priorityQueue.add(50);
        priorityQueue.add(35);

        System.out.println(priorityQueue);

        //Top of Queue
        System.out.println(priorityQueue.peek());

        //Top of queue nhung sau do xoa no di
        System.out.println(priorityQueue.poll());

        System.out.println(priorityQueue.peek());
        //PriorityQueue String
        PriorityQueue<String> priorityQueue1 = new PriorityQueue<>();
        priorityQueue1.add("Java");
        priorityQueue1.add("C#");
        priorityQueue1.add("Python");
        priorityQueue1.add("HTML");

        System.out.println(priorityQueue1);
    }
}
