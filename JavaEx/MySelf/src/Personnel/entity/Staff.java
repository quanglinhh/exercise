package Personnel.entity;

public class Staff extends Personnel{

    private String job;

    public Staff(String name, int age, String gender, String address, String job) {
        super(name, age, gender, address);
        this.job = job;
    }

    public Staff() {}



    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "name: "+name+", age: "+age+", gender: "+address+", role: Staff ,job: "+job;
    }
}
