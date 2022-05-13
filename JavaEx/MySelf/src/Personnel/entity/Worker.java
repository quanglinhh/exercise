package Personnel.entity;

public class Worker extends Personnel{

    public int lever;

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
        return "name: "+name+", age: "+age+", gender: "+address+", role: Worker ,lever: "+lever;
    }
}
