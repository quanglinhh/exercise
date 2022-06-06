package Personnel.entity;

public class Worker extends Personnel{

    private int lever;

    public Worker(String name, int age, String gender, String address, int lever) {
        super(name, age, gender, address);
        this.lever = lever;
    }

    public Worker() {}

    public int getLever() {
        return lever;
    }

    public void setLever(int lever) {
        this.lever = lever;
    }

    @Override
    public String toString() {
        return "{" +
                "lever=" + lever +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
