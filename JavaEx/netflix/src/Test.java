import java.util.ArrayList;
import java.util.List;

public class Test {


    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        arr.add(2);
        arr.add(3);

        List<Integer> arr2 = arr;
        System.out.println(arr2);
    }
}
