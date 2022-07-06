package entity;

public class Worker extends Employee{
    private int lever;

    public Worker(String fullname, int age, String gender, String address, int lever) {
        super(fullname, age, gender, address);
        this.lever = lever;
    }

    public Worker(){}

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
                ", name='" + getFullname() + '\'' +
                ", age=" + getAge() +
                ", gender='" + getGender() + '\'' +
                ", address='" + getAddress() + '\'' +
                '}';
    }
}
