package test3;

import java.util.*;

public class Main {
    public static void main(String[] args) {

       var users = new PriorityQueue<User>(new ComparatorUser());

        users.add(new User("Linh",24));
        users.add(new User("Long",30));
        users.add(new User("Long1",50));
        users.add(new User("Long2",1));
        users.add(new User("Long3",45));

        users.peek();
        users.poll();
        System.out.println(users);
        users.poll();
        System.out.println(users);
        users.poll();
        System.out.println(users);




    }
}
