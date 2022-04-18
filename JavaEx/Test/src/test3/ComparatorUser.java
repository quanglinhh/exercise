package test3;

import test3.User;

import java.util.Comparator;

public class ComparatorUser implements Comparator<User> {


    @Override
    public int compare(User p1, User p2) {
        return Integer.compare(p1.age,p2.age);
    }
}
