package com.example.studentspringboot.model;



import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name ="Tbluser")
public class TblUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //    @Min(value = 10, message = "name can not be less than 10 character")
//    @Max(value = 50, message = "name can not be greater than 50 character")
    @Column(name="uname")
    @NotBlank(message = "Name is mandatory")
    private String name;
    @Column(name="email")
    @NotEmpty
    private String email;
    @Column(name="phone")
    private String phone;

    public TblUser( String name, String email, String phone) {

        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public TblUser() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}
