package entity;

public class Engineer extends Employee{
    private String department;

    public Engineer(String fullname, int age, String gender, String address, String department) {
        super(fullname, age, gender, address);
        this.department = department;
    }
    public Engineer(){}

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    @Override
    public String toString() {

        return "{ name: "+getFullname()+", age: "+getAge()+", gender: "+getAddress()+", role: Engineer ,industry: "+department+" }";
    }
}
