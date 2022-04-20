public class Persion {
    private String name;
    private int age;

    public Persion(String name, int age) {
        this.name = name;
        this.age = age;
    }




    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public static int compareByName(Persion p1, Persion p2){
        return p1.getName().compareTo(p2.getName());
    }

    @Override
    public String toString() {
        return name + " - "+ age;
    }
}
