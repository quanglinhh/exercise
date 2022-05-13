package Personnel.entity;

public class Engineer extends Personnel{

    private String industry;

    public Engineer(String name, int age, String gender, String address, String industry) {
        super(name, age, gender, address);
        this.industry = industry;
    }

    public Engineer(){}

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    @Override
    public String toString() {
        return "name: "+name+", age: "+age+", gender: "+address+", role: Engineer ,industry: "+industry;
    }
}
