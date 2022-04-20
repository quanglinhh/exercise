import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Application {
    public static void main(String[] args) {
        ArrayList<Persion> persions = new ArrayList<>();

        persions.add(new Persion("Khoi",35));
        persions.add(new Persion("Minh",20));
        persions.add(new Persion("Viet Anh",18));
        persions.add(new Persion("Hoang",40));
        persions.add(new Persion("Ngoc",30));
        persions.add(new Persion("My",30));

        show(persions);

        //Sử dụng Comparator
        Collections.sort(persions, new Comparator<Persion>(){
            @Override
            public int compare(Persion o1, Persion o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        //Sử dụng lambda
        Collections.sort(persions,((o1, o2) -> {
            return o1.getName().compareTo(o2.getName());
        }));

        //Sử dụng lambda để xắp xếp theo tên với phương thức comparaByName
        Collections.sort(persions,((o1,o2)->Persion.compareByName(o1,o2)));
        show(persions);
        //Liệt kê những người trên 30 tuổi, không sử dụng lambda expresstion
        System.out.println("Danh sách những người  trên 30 tuổi là: ");
        for (Persion persion: persions){
            if(persion.getAge()>30){
                System.out.println(persion);
            }
        }

        //Liệt kê những người trên 30 tuổi sử dụng lambda
        System.out.println("Danh sách những người tên 30 tuổi là: ");
        persions.stream().filter(persion-> persion.getAge()>30).forEach(persion->System.out.println(persion));
    }

    public static void show(ArrayList<Persion> persions){
        persions.forEach(persion -> System.out.println(persion));
    }

}
