package entity;

public class Staff extends Employee{
    private String job;

    public Staff(String fullname, int age, String gender, String address, String job) {
        super(fullname, age, gender, address);
        this.job = job;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }



    @Override
    public String toString() {
        return "{ name: "+getFullname()+", age: "+getAddress()+", gender: "+getAddress()+", role: Staff ,job: "+job+" }";
    }
}
