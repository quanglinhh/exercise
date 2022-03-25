public class Customer {
    private long id;
    private String first_name;
    private String last_name;
    private String mobile;
    private String address;

    //constructure

    public Customer(long id, String first_name, String last_name, String mobile, String address) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.mobile = mobile;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "id=" + id + "- first_name=" + first_name + "- last_name=" + last_name + "- mobile=" + mobile + "- address=" + address;
    }
}
