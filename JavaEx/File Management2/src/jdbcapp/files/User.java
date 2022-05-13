package jdbcapp.files;

import java.util.Arrays;

public class User {

     int id;
    private String name;
    private String emai;
    private String[] roles;
    private boolean admin;
    private boolean employee;

    public User(int id, String name, String emai, String[] roles, boolean admin, boolean employee) {
        this.id = id;
        this.name = name;
        this.emai = emai;
        this.roles = roles;
        this.admin = admin;
        this.employee = employee;
    }
    public User(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmai() {
        return emai;
    }

    public void setEmai(String emai) {
        this.emai = emai;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isEmployee() {
        return employee;
    }

    public void setEmployee(boolean employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", emai='" + emai + '\'' +
                ", roles=" + Arrays.toString(roles) +
                ", admin=" + admin +
                ", employee=" + employee +
                '}';
    }
}
