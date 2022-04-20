package ArrayDeque;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class test {
    public static void main(String[] args) {
        var deQueue = new ArrayList<>(); 
        deQueue.add(20);
        deQueue.add(26);
        deQueue.add(30);
        deQueue.add(11);
        deQueue.add(12);



        deQueue.poll();
        System.out.println(deQueue);
        deQueue.poll();
        System.out.println(deQueue);
        deQueue.poll();
        System.out.println(deQueue);
        deQueue.poll();
        System.out.println(deQueue);
        deQueue.poll();
        System.out.println(deQueue);
        deQueue.poll();
        System.out.println(deQueue);
        deQueue.poll();
        System.out.println(deQueue);


    }
}
